package com.wjliuh.utils;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.wjliuh.model.CommonMethodEntity;

public class HttpHelper {

    /** ʹ�ñ�Ԫ�ش��� Form Bean (��Ԫ�ص����ƺ� Form Bean ��������ȫһ��) */
    public <T> T createFormBean(HttpServletRequest request, Class<T> clazz)
    {
        return createFormBean(request, clazz, null);
    }

    /** ʹ�ñ�Ԫ�ش��� Form Bean (�� keyMap ӳ�����Ԫ�����Ʋ���Ӧ�� Form Bean ����) */
    public   <T> T createFormBean(HttpServletRequest request, Class<T> clazz, Map<String, String> keyMap)
    {
        Map<String, String[]> properties = getParamMap(request);
        return null;
    }
    
    /** ʹ�ñ�Ԫ����� Form Bean (��Ԫ�ص����ƺ� Form Bean ��������ȫһ��) */
    public   <T> void fillFormBeanProperties(HttpServletRequest request, T bean)
    {
        fillFormBeanProperties(request, bean, null);
    }
    
    /** ʹ�ñ�Ԫ����� Form Bean (�� keyMap ӳ�����Ԫ�����Ʋ���Ӧ�� Form Bean ����) */
    public   <T> void fillFormBeanProperties(HttpServletRequest request, T bean, Map<String, String> keyMap)
    {
     Map<String, String[]> properties = getParamMap(request);
//     setProperties(bean, properties, keyMap);
    }
    
    /** ��ȡ {@link HttpServletRequest} �����в������ƺ�ֵ */
    public   Map<String, String[]> getParamMap(HttpServletRequest request)
    {
        return request.getParameterMap();
    }
    
    public static CommonMethodEntity getFormBean(HttpServletRequest request, Class<CommonMethodEntity> class1){
    	
    	CommonMethodEntity entity = new CommonMethodEntity();
    	entity.setMethodCode(String.valueOf(System.currentTimeMillis()));
    	entity.setAppendix(request.getParameter("appendix"));
    	entity.setAppendixpath(request.getParameter("appendixpath"));
    	entity.setCreatetime(request.getParameter("createtime"));
    	entity.setDescription(request.getParameter("description"));
    	
    	String isDelete = request.getParameter("isdelete");
    	if("on".equals(isDelete)){
    		entity.setIsdelete("Y");
    	}else{
    		entity.setIsdelete("N");
    	}
    	
    	entity.setMethodName(request.getParameter("methodName"));
    	entity.setUpdatetime(request.getParameter("updatetime"));
    	entity.setId(UUID.randomUUID().toString());
    	return entity;
    }
}
