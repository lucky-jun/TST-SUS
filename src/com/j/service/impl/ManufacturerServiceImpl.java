package com.j.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.j.dao.GoodsGetDataDao;
import com.j.dao.ManufacturerDao;
import com.j.dao.impl.GoodsGetDataDaoImpl;
import com.j.dao.impl.ManufacturerDaoImpl;
import com.j.pojo.Goods;
import com.j.pojo.Manufacturer;
import com.j.service.ManufacturerService;

public class ManufacturerServiceImpl implements ManufacturerService{
	private ManufacturerDao mfDao= new ManufacturerDaoImpl();
	private GoodsGetDataDao goodsDao = new GoodsGetDataDaoImpl();


	public Map<String, Object> deleteManufacturer() {
		return null;
//		List<Integer> list = new ArrayList<Integer>();
//		List<Goods> queryAllGoods = goodsDao.queryAllGoods();
//		//查询商品表得到一组数，查询厂商表得到一组数，对比去掉相同的，剩余的删除
//		boolean deleteManufacturer = mfDao.deleteManufacturer(list);
//		return deleteManufacturer;
	}


	@Override
	public Map<String, Object> insertManufacturer(Manufacturer manufacturer) {
		Map<String,Object> map = new HashMap<String, Object>();
		if(mfDao.queryOneMFId(manufacturer.getM_id())==null) {
			boolean insertSupplier = mfDao.insertManufacturer(manufacturer);
			if(insertSupplier) {
				map.put("flag", "true");
			}else {
				map.put("flag", "false");
			}
		}else {
			map.put("flag", "true");
		}
		return map;
	}


	@Override
	public Map<String, Object> deleteManufacturer(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Map<String, Object> queryOneMFId(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Map<String, Object> queryOneMFName(String name) {
		
		return null;
	}


	@Override
	public List<Manufacturer> queryAllMF() {
		List<Manufacturer> queryAllMF = mfDao.queryAllMF();
		return queryAllMF;
	}


	@Override
	public Map<String, Object> updateManufacturer(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Map<String, Object> updateManufacturer(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
