package com.wjliuh.referjar;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * �������Ҫ����ant����ʹ��ʱ��������ⲿjar��
 * @author JIE
 *
 */
public class TestExternalJar {

	private static Log log = LogFactory.getLog("");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {


		FileOutputStream out = null;

		int count = 1000;// д�ļ�����

		try {

			out = new FileOutputStream(new File("G:/add.txt"));

			long begin = System.currentTimeMillis();

			for (int i = 0; i < count; i++) {

				out.write("����java �ļ�����\r\n".getBytes());

			}
			out.flush();

			long end = System.currentTimeMillis();

			System.out.println("FileOutputStreamִ�к�ʱ:" + (end - begin) + " ����");
			log.debug("FileOutputStreamִ�к�ʱ:" + (end - begin) + " ����");


		} catch (Exception e) {

			e.printStackTrace();

		}finally {

			try {

				out.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	

	}

}
