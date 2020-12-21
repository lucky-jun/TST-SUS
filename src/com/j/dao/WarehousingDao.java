package com.j.dao;

import java.util.Date;
import java.util.List;

import com.j.pojo.Warehousing;

public interface WarehousingDao {
	//查
	public Warehousing queryOneName(String name);//查询指定商品入库
	public Warehousing queryOneName(int id);//查询指定商品入库
	public Warehousing queryOneDate(Date date);//指定日期查询入库
	public List<Warehousing> queryAll();//查询全部入库信息
	//增
	public boolean insertWarehousing(Warehousing whsing);//添加商品
	//删除
	public boolean deleteWarehousing(String name);
	public boolean deleteWarehousing(int id);
	//改
	public boolean updateWarehousing(String name);
	public boolean updateWarehousing(int id);
	
}
