package com.j.service;

import java.util.Map;

import com.j.pojo.Goods;

public interface GoodsGetDataService {
	
	public Map<String, Object> queryPageGoods(int page,int limit);
	public Map<String, Object> queryByIDGoods(int gid);
	public Map<String, Object> queryByNameGoods(String gname);
	public Map<String, Object> queryByCode(int code);
	
	public Map<String, Object> insertGoods(Goods goods);
	
	public Map<String,Object> updateGoods(Goods goods);
	public Map<String,Object> updateSale(String id,int g_sale);
	
	public Map<String, Object> deleteGoods(String gid);
}
