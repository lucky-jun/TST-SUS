package com.j.service;

import java.util.List;
import java.util.Map;

import com.j.pojo.Supplier;

public interface SupplierService {
	//Ôö
	public Map<String, Object> insertSupplier(Supplier supplier);
	//É¾
	public Map<String, Object> deleteSupplier(String name);
	//²é
	public Map<String, Object> querySupplier(String name);
	public Map<String, Object> querySupplier(int id);
	public Map<String, Object> queryAll();
	//¸Ä
	public Map<String, Object> updateSupplier(String name);
}
