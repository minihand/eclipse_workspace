package com.wjliuh.io;

import java.io.File;

import java.io.FileOutputStream;

import java.io.*;
/**
 * �������Ҫ�ǲ���ant�������jdk�Լ���jar����
 * @author JIE
 *
 */
public class FileTest {

	public FileTest() {

	}

	public static void main(String[] args) {

		FileOutputStream out = null;

		FileOutputStream outSTr = null;

		BufferedOutputStream Buff = null;

		FileWriter fw = null;

		int count = 1000;// д�ļ�����

		try {

			out = new FileOutputStream(new File("G:/add.txt"));

			long begin = System.currentTimeMillis();

			for (int i = 0; i < count; i++) {

				out.write("����java �ļ�����\r\n".getBytes());

			}

			out.close();

			long end = System.currentTimeMillis();

			System.out.println("FileOutputStreamִ�к�ʱ:" + (end - begin) + " ����");

			outSTr = new FileOutputStream(new File("G:/add0.txt"));

			Buff = new BufferedOutputStream(outSTr);

			long begin0 = System.currentTimeMillis();

			for (int i = 0; i < count; i++) {

				Buff.write("����java �ļ�����\r\n".getBytes());

			}

			Buff.flush();

			Buff.close();

			long end0 = System.currentTimeMillis();

			System.out.println("BufferedOutputStreamִ�к�ʱ:" + (end0 - begin0)
					+ " ����");

			fw = new FileWriter("G:/add2.txt");

			long begin3 = System.currentTimeMillis();

			for (int i = 0; i < count; i++) {

				fw.write("����java �ļ�����\r\n");

			}

			fw.close();

			long end3 = System.currentTimeMillis();

			System.out.println("FileWriterִ�к�ʱ:" + (end3 - begin3) + " ����");

		} catch (Exception e) {

			e.printStackTrace();

		}

		finally {

			try {

				fw.close();

				Buff.close();

				outSTr.close();

				out.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	}

}