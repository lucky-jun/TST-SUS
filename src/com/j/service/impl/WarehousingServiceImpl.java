package com.j.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.j.dao.WarehousingDao;
import com.j.dao.impl.WarehousingDaoImpl;
import com.j.pojo.Warehousing;
import com.j.service.WarehousingService;

public class WarehousingServiceImpl implements WarehousingService{
	private WarehousingDao warehousingDao = new WarehousingDaoImpl();
	
	@Override
	public Map<String, Object> insertWarehousing(Warehousing whsing) {
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format =simpleDateFormat.format(date1);
		whsing.setW_date(format);
		Map<String,Object> map = new HashMap<String, Object>();
		if(whsing.getW_innum()>0) {
			
			map.put("flag", warehousingDao.insertWarehousing(whsing));
		}
		
		
		
		
		return map;
	}
	@Override
	public Map<String, Object> queryOneName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> queryOneName(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> queryOneDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> deleteWarehousing(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> deleteWarehousing(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> updateWarehousing(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> updateWarehousing(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}