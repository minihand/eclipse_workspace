package com.wjliuh.patch;
import java.util.HashMap;

public class Constants {


	
	public static final HashMap<String,String> TEMPLATE_MAPING = new HashMap<String,String>();
	static{
		TEMPLATE_MAPING.put("pub_billtemplet", "pk_billtemplet");
		/** ����ģ��*/
		TEMPLATE_MAPING.put("pub_billtemplet","pk_billtemplet");
		/** ����ģ�棬b��*/
		TEMPLATE_MAPING.put("pub_billtemplet_b","pk_billtemplet");
		/** ����ģ�棬t��*/
		TEMPLATE_MAPING.put("pub_billtemplet_t","pk_billtemplet");
		/** ��ѯģ�棬����*/
		TEMPLATE_MAPING.put("pub_query_templet","id");
		/** ��ѯģ�棬������*/
		TEMPLATE_MAPING.put("pub_query_condition","pk_templet");
		/** ��ѯģ�棬������*/
		TEMPLATE_MAPING.put("pub_queryscheme","pk_template");
		/** ϵͳģ��*/
		TEMPLATE_MAPING.put("pub_systemplate_base","pk_systemplate");
		/** ��ӡģ�棬����*/
		TEMPLATE_MAPING.put("pub_print_template","ctemplateid");
		/** ��ӡģ�棬����*/
		TEMPLATE_MAPING.put("pub_print_cell","ctemplateid");
		/** ��ӡģ�棬������*/
		TEMPLATE_MAPING.put("pub_print_variable","ctemplateid");
		/** ���ձ�*/
		TEMPLATE_MAPING.put("bd_refinfo","pk_refinfo");
	}
	
	
	
}
