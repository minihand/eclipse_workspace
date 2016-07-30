package com.wjliuh.lock;




import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;




public class AppOfficial {

	/**
	 * BoundedBuffer ��һ������100�ļ��ϣ���������û��Ԫ��ʱ��take������Ҫ�ȴ���ֱ����Ԫ��ʱ�ŷ���Ԫ��
	 * �����е�Ԫ�����ﵽ���ֵʱ��Ҫ�ȴ�ֱ��Ԫ�ر�take֮���ִ��put�Ĳ���
	 * @author yukaizhao
	 *
	 */
	static class BoundedBuffer {
		final Lock lock = new ReentrantLock();
		final Condition notFull = lock.newCondition();
		final Condition notEmpty = lock.newCondition();

		final Object[] items = new Object[100];
		int putptr, takeptr, count;

		public void put(Object x) throws InterruptedException {
			System .out.println("put wait lock");
			lock.lock();
			System.out.println("put get lock");
			try {
				while (count == items.length) {
					System.out.println("buffer full, please wait");
					notFull.await();
				}
				putInto(x);
				notEmpty.signal();
			} finally {
				lock.unlock();
			}
		}

		private void putInto(Object x) {
			System.out.println("putting..");	
			items[putptr] = x;
			System.out.println("put " + x);
			if (++putptr == items.length)
				putptr = 0;
			++count;
		}

		public void take() throws InterruptedException {
			System.out.println("take wait lock");
			lock.lock();
			System.out.println("take get lock");
			try {
				while (count == 0) {
					System.out.println("no elements, please wait");
					notEmpty.await();
				}
				
				takeOut();
				notFull.signal();
			} finally {
				lock.unlock();
			}
		}

		private void takeOut() {
			Object x = items[takeptr];
			System.out.println("take " + x);
			if (++takeptr == items.length)
				takeptr = 0;
			--count;
		}
	}
	
	public static void main(String[] args) {
		final BoundedBuffer boundedBuffer = new BoundedBuffer();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("t1 run");
				for (int i=0;i<1000;i++) {
					try {
						boundedBuffer.put(Integer.valueOf(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}) ;
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=0;i<1000;i++) {
					try {
						boundedBuffer.take();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}) ;
		
		t1.start();
		t2.start();
	}
}
