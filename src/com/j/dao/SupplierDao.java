package com.j.dao;

import java.util.List;

import com.j.pojo.Supplier;

public interface SupplierDao {
	//Ôö
	public boolean insertSupplier(Supplier supplier);
	//É¾
	public boolean deleteSupplier(String name);
	//²é
	public Supplier querySupplier(String name);
	public Supplier querySupplier(int id);
	public List<Supplier> queryAll();
	//¸Ä
	public boolean updateSupplier(String name);
}
