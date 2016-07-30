package com.wjliuh.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 */
public class DownMusicUtil {

	/**
	 * ��������
	 * @param filePath  ���غ�洢·��
	 * @param musicPath �����������ַ
	 * @return �����ļ���
	 */
	public static String DownFiles(String filePath,String musicPath){
		//�ļ�Ŀ¼
		File files = new File(filePath);
		
		if(files.exists()){
			files.mkdirs();
		}
		URL url = null;
		FileOutputStream fos = null;
		HttpURLConnection conn = null;
		InputStream is = null;
		try {
			//��ȡ�����ļ����ص�ַ��������������
			url = new URL(musicPath);
			//����������
			conn = (HttpURLConnection) url.openConnection();
			conn.getResponseCode();
			//��ȡ����������
			is = conn.getInputStream();
			//http://luoo.800edu.net/low/luoo/radio665/05.mp3
			//��ȡ�����ļ���
			String fileName = musicPath.substring(musicPath.lastIndexOf("/"));
			//ƴ�Ӿ���·��
			String absoPath = filePath + fileName;
			File file = new File(absoPath);
			fos = new FileOutputStream(file);
			int i = 0;
			while((i = is.read())!=-1){
				fos.write(i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static List<String> getMusicPaths(String presuffix){
		URL url = null;
		HttpURLConnection conn = null;
		List<String> urls = new ArrayList<String>();
		try {
			for(int i=1;i<=20;i++){
				String urlpath = "";
				//��ȡ�����ļ����ص�ַ��������������
				if(i<10){
					urlpath = presuffix+"0"+i+".mp3";
				}else{
					urlpath = presuffix+i+".mp3";
				}
				url = new URL(urlpath);
				//����������
				conn = (HttpURLConnection) url.openConnection();
				if(conn.getResponseCode() == 200){
					urls.add(urlpath);
				}
				
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return urls;
	}
	
	public static void main(String[] args){
		List<String> musics = getMusicPaths("http://luoo.800edu.net/low/luoo/radio665/");
		String filePath = "G:\\";

		for(String str :musics){
			DownFiles(filePath,str);
		}
		
	}
}
