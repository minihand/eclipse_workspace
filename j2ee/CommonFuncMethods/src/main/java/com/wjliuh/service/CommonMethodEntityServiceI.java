package com.wjliuh.service;

import java.util.List;
import java.util.Map;

import com.wjliuh.model.CommonMethodEntity;

public interface CommonMethodEntityServiceI {

	/**
	 * ����id��ѯ
	 * @param id
	 * @return
	 */
	public CommonMethodEntity getCommonMethodEntityById(String id);
	
	/**
	 * ȫ����
	 * @return
	 */
	public List<CommonMethodEntity> queryCommonMethodEntity();
	
	/**
	 * ����
	 * @param entity
	 * @return
	 */
	public int insertCommonMethod(CommonMethodEntity entity);
	
	/**
	 * ����������
	 * @param param ����map
	 * @return ʵ���б�
	 */
	public List<CommonMethodEntity> selectByWhere(CommonMethodEntity entity);

	/**
	 * ����������
	 * @param param ����map
	 * @return ʵ���б�
	 */
	public List<CommonMethodEntity> selectByOptions(Map<Object,Object> param);
	
	/**
	 * ģ��ȫ�ļ���
	 * @param param ����map
	 * @return ʵ���б�
	 */
	public List<CommonMethodEntity> fullTextSearcher(Map<Object,Object> param);
}
