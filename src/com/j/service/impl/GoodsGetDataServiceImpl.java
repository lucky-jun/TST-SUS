package com.j.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.j.dao.GoodsGetDataDao;
import com.j.dao.impl.GoodsGetDataDaoImpl;
import com.j.pojo.Goods;
import com.j.service.GoodsGetDataService;

public class GoodsGetDataServiceImpl implements GoodsGetDataService {
	GoodsGetDataDao GoodsGDD = new GoodsGetDataDaoImpl();
	public Map<String, Object> queryPageGoods(int page, int limit) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			int queryCountGoods = GoodsGDD.queryCountGoods();
//			System.out.println("qqqqqqqqqqq:"+queryCountGoods);
			List<Goods> list = null;
			if(page == 0){
				list = GoodsGDD.queryPageGoods(0, limit);
			}else{
				list = GoodsGDD.queryPageGoods((page-1)*limit, limit);
			}
			map.put("code", 0);
			map.put("data", list);
			map.put("count",GoodsGDD.queryCountGoods());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> queryByCode(int code) {
		Map<String,Object> map = new HashMap<String , Object>();
		try {
			List<Goods> queryByCode = GoodsGDD.queryByCode(code);
//			System.out.println("queryByCode:"+queryByCode);
//			System.out.println("queryByCode.isEmpty():"+queryByCode.isEmpty());
			if(queryByCode.isEmpty()) {
				map.put("flag", "空");
				map.put("code", 404);
			}else {
				map.put("flag", "有");
				map.put("code", 0);
			}
			map.put("data", queryByCode);
			map.put("count", queryByCode.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, Object> insertGoods(Goods goods) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
//			if((GoodsGDD.queryByID(goods.getG_id())).isEmpty()) {
				boolean insertGoods = GoodsGDD.insertGoods(goods);
				if(insertGoods) {
					map.put("flag", "true");
				}else {
					map.put("flag", "false");
				}
//			}else {
//				map.put("flag", "该商品已存在，请查找仔细查找！");
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> updateGoods(Goods goods) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		try {
//			System.out.println("goods.g_price:"+goods.getG_price());
			/*
			 * boolean updateByGoods = GoodsGDD.updateByGoods(goods);
			 * System.out.println("updateByGoods:"+updateByGoods);
			 */
			map.put("flag", GoodsGDD.updateByGoods(goods));
		} catch (SQLException e) {
			e.printStackTrace();
			map.put("flag", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteGoods(String g_id) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			boolean deleteByID = GoodsGDD.deleteByID(g_id);
//			System.out.println("deleteByID:"+deleteByID);
			map.put("flag", deleteByID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> queryByIDGoods(int managerID) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			List<Goods> queryByID = GoodsGDD.queryByID(managerID);
//			System.out.println("aaaaa"+queryByID.isEmpty());
			if(queryByID != null || queryByID.isEmpty()){
				map.put("code", 0);
			}else{
				map.put("code", 404);
			}
			map.put("data", queryByID);
			map.put("count",queryByID.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  map;
	}

	@Override
	public Map<String, Object> queryByNameGoods(String gname) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			List<Goods> queryByName = GoodsGDD.queryByName(gname);
//			System.out.println("aaaaa"+queryByName.isEmpty());
			if(queryByName != null || queryByName.isEmpty()){
				map.put("code", 0);
			}else{
				map.put("code", 404);
			}
			map.put("data", queryByName);
			map.put("count",queryByName.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  map;
	}

	@Override
	public Map<String, Object> updateSale(String id,int g_sale) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
//			System.out.println("service_g_sale:"+g_sale);
			boolean updataSale = GoodsGDD.updataSale(id,g_sale);
//			System.out.println("updataSale:"+updataSale);
			map.put("flag", updataSale);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}


}
