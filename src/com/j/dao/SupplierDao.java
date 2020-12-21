package com.j.dao;

import java.util.List;

import com.j.pojo.Supplier;

public interface SupplierDao {
	//��
	public boolean insertSupplier(Supplier supplier);
	//ɾ
	public boolean deleteSupplier(String name);
	//��
	public Supplier querySupplier(String name);
	public Supplier querySupplier(int id);
	public List<Supplier> queryAll();
	//��
	public boolean updateSupplier(String name);
}
