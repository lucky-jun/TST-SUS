package com.j.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.j.pojo.Warehousing;

public interface WarehousingService {
	//查
	public Map<String, Object> queryOneName(String name);//查询指定商品入库
	public Map<String, Object> queryOneName(int id);//查询指定商品入库
	public Map<String, Object> queryOneDate(Date date);//指定日期查询入库
	public Map<String, Object> queryAll();//查询全部入库信息
	//增
	public Map<String, Object> insertWarehousing(Warehousing whsing);//添加商品
	//删除
	public Map<String, Object> deleteWarehousing(String name);
	public Map<String, Object> deleteWarehousing(int id);
	//改
	public Map<String, Object> updateWarehousing(String name);
	public Map<String, Object> updateWarehousing(int id);
}
