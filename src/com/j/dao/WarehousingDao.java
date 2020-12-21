package com.j.dao;

import java.util.Date;
import java.util.List;

import com.j.pojo.Warehousing;

public interface WarehousingDao {
	//��
	public Warehousing queryOneName(String name);//��ѯָ����Ʒ���
	public Warehousing queryOneName(int id);//��ѯָ����Ʒ���
	public Warehousing queryOneDate(Date date);//ָ�����ڲ�ѯ���
	public List<Warehousing> queryAll();//��ѯȫ�������Ϣ
	//��
	public boolean insertWarehousing(Warehousing whsing);//�����Ʒ
	//ɾ��
	public boolean deleteWarehousing(String name);
	public boolean deleteWarehousing(int id);
	//��
	public boolean updateWarehousing(String name);
	public boolean updateWarehousing(int id);
	
}
