package com.wjliuh.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class AbstractExecutor {

	/** ��Ŀ��Ŀ¼ */
	private String projectDir;
	
	/** ���油����Ŀ¼ */
	private String targetDir;
	
	/** ������ */
	private InputStream is;
	
	/** ����� */
	private OutputStream os;
	
	public AbstractExecutor(String projectDir, String targetDir) {
		this.projectDir = projectDir;
		this.targetDir = targetDir;
	}

	/**
	 * ������д��ȡ�Զ����Դ���ļ�
	 */
	public abstract File getCodeFile();
	
	/**
	 * ������д��ȡ�Զ���Ķ����Ʊ����class�ļ�
	 */
	public abstract File getBinaryFile();

	/**
	 * ������д��ȡ�Զ���ı��油�����ļ�
	 */
	public abstract File getTargetBinaryFile();

	/**
	 * ������д��ȡ�Զ���ı��油����Դ���ļ�
	 */
	public abstract File getTargetCodeFile();
	
	/**
	 * ����class�ļ�
	 */
	public void copyBinary(){
		if(!getBinaryFile().exists()){
			return;
		}
		doCopy(getBinaryFile(),getTargetBinaryFile());
		
	}
	
	/**
	 * ����Դ��java�ļ�
	 */
	public void copyCode(){
		if(!getCodeFile().exists()){
			return;
		}
		doCopy(getCodeFile(),getTargetCodeFile());
		
	}
	
	/**
	 * ���Ʋ���
	 * @param src
	 * @param to
	 */
	private void doCopy(File src,File to) {
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(to);
			byte[] buffer = new byte[256];
			int read;
			while((read=is.read(buffer))!=-1){
				os.write(buffer, 0, read);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(null != is){
					is.close();
				}
				if(null != os){
					os.flush();
					os.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	

	public String getProjectDir() {
		return projectDir;
	}
	public void setProjectDir(String projectDir) {
		this.projectDir = projectDir;
	}
	public void setTargetDir(String targetDir) {
		this.targetDir = targetDir;
	}
	public String getTargetDir() {
		return targetDir;
	}
	
	public String getScope(String scope){
		if("client".equals(scope)){
			return "client/classes";
		}else if("public".equals(scope)){
			return "classes";
		}else if("private".equals(scope)){
			return "META-INF/classes";
		}
		return null;
	}
	
}
