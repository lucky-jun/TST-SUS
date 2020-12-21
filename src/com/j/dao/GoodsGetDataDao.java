package com.j.dao;

import java.sql.SQLException;
import java.util.List;

import com.j.pojo.Goods;

public interface GoodsGetDataDao {
	//��ѯ
	public List<Goods> queryByID(int gid) throws SQLException;
	public List<Goods> queryByName(String gname) throws SQLException;
//	public List<User> queryByName(String username, String password) throws SQLException;
	public List<Goods> queryByCode(int code) throws SQLException;
	
	
	//��ҳ��ѯ
	public List<Goods> queryPageGoods(int page, int limit) throws SQLException;
    public int queryCountGoods() throws SQLException;	
	//�޸�
	public boolean updateByGoods(Goods goods) throws SQLException;
	public boolean updataSale(String id,int g_sale) throws SQLException;
	//ɾ��
	public boolean deleteByID(String id) throws SQLException;
	//���
	public boolean insertGoods(Goods goods) throws SQLException;

}
