package com.j.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.j.pojo.Warehousing;

public interface WarehousingService {
	//��
	public Map<String, Object> queryOneName(String name);//��ѯָ����Ʒ���
	public Map<String, Object> queryOneName(int id);//��ѯָ����Ʒ���
	public Map<String, Object> queryOneDate(Date date);//ָ�����ڲ�ѯ���
	public Map<String, Object> queryAll();//��ѯȫ�������Ϣ
	//��
	public Map<String, Object> insertWarehousing(Warehousing whsing);//�����Ʒ
	//ɾ��
	public Map<String, Object> deleteWarehousing(String name);
	public Map<String, Object> deleteWarehousing(int id);
	//��
	public Map<String, Object> updateWarehousing(String name);
	public Map<String, Object> updateWarehousing(int id);
}
