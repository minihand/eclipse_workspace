package com.wjliuh.ant;

import com.wjliuh.model.TestModel;

/**
 * ѧϰant��һ����
 * @author JIE
 *
 */
public class AntClass {

	private static TestModel model;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getModel().getJob());

	}
	public static TestModel getModel() {
		if(null == model){
			model = TestModel.getInstance();
		}
		return model;
	}

}
