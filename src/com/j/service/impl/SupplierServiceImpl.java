package com.j.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.j.dao.SupplierDao;
import com.j.dao.impl.SupplierDaoImpl;
import com.j.pojo.Supplier;
import com.j.service.SupplierService;

public class SupplierServiceImpl implements SupplierService{
	private SupplierDao supplierDao = new SupplierDaoImpl();

	@Override
	public Map<String, Object> insertSupplier(Supplier supplier) {
		Map<String,Object> map = new HashMap<String, Object>();
		if(supplierDao.querySupplier(supplier.getS_id())==null) {
			boolean insertSupplier = supplierDao.insertSupplier(supplier);
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
	public Map<String, Object> deleteSupplier(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> querySupplier(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> querySupplier(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> queryAll() {
		List<Supplier> queryAll = supplierDao.queryAll();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("data", queryAll);
		map.put("msg", "");
		map.put("count", queryAll.size());
		return map;
	}

	@Override
	public Map<String, Object> updateSupplier(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}
