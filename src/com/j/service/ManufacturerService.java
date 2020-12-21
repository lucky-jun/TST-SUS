package com.j.service;

import java.util.List;
import java.util.Map;

import com.j.pojo.Manufacturer;

public interface ManufacturerService {
	//��
	public Map<String, Object> insertManufacturer(Manufacturer manufacturer);
	//ɾ
	public Map<String, Object> deleteManufacturer(String name);
	public Map<String, Object> deleteManufacturer();
	//��
	public Map<String, Object> queryOneMFId(int id);//id��ѯ����ȫ����Ϣ
	public Map<String, Object> queryOneMFName(String name);//���Ʋ�ѯ����ȫ����Ϣ
	public List<Manufacturer> queryAllMF();//��ѯȫ��������Ϣ
	//��
	public Map<String, Object> updateManufacturer(String name);
	public Map<String, Object> updateManufacturer(int id);
}
