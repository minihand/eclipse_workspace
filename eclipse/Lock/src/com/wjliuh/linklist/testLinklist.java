package com.wjliuh.linklist;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testLinklist {
	static final int MAXIMUM_CAPACITY = 1 << 30;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number =0;
		int rounded = number >= MAXIMUM_CAPACITY? MAXIMUM_CAPACITY : (rounded = Integer.highestOneBit(number)) != 0 ? (Integer.bitCount(number) > 1) ? rounded << 1 : rounded: 1;
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("a", "b");
		ExecutorService exe = Executors.newCachedThreadPool();
		exe.execute(new Runnable(){
				public void run() {
				      
				    }

		});
		
		/** ����һ��"�ɸ�����Ҫ���������߳�"���̳߳أ�����,��֮ǰ������߳̿���ʱ����������*/
		exe = Executors.newCachedThreadPool(); 
		
		/** ����һ�������ù̶��߳������̳߳أ��Թ�����޽���з�ʽ��������Щ�߳�*/
		exe = Executors.newFixedThreadPool(10);
		
		/** ����һ���̳߳أ����ɰ����ڸ����ӳٺ�����������߶��ڵ�ִ��*/
		exe = Executors.newScheduledThreadPool(10);
		
		/** ����һ��ʹ�õ��� worker �̵߳� Executor�����޽���з�ʽ�����и��߳�*/
		exe = Executors.newSingleThreadExecutor();
		
		/** ����һ�����߳�ִ�г������ɰ����ڸ����ӳٺ�����������߶��ڵ�ִ��*/
		exe = Executors.newSingleThreadScheduledExecutor();
		
		/** �������ڴ������̵߳��̹߳�������Щ���߳��뵱ǰ�߳̾�����ͬ��Ȩ��*/
		Executors.privilegedThreadFactory();

	}

	
}
