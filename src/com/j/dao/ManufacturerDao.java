package com.j.dao;

import java.util.List;

import com.j.pojo.Manufacturer;

public interface ManufacturerDao {
	//��
	public boolean insertManufacturer(Manufacturer manufacturer);
	//ɾ
	public boolean deleteManufacturer(String name);
	public boolean deleteManufacturer(List list);
	//��
	public Manufacturer queryOneMFId(int id);//id��ѯ����ȫ����Ϣ
	public Manufacturer queryOneMFName(String name);//���Ʋ�ѯ����ȫ����Ϣ
	public List<Manufacturer> queryAllMF();//��ѯȫ��������Ϣ
	//��
	public boolean updateManufacturer(String name);
	public boolean updateManufacturer(int id);
}
