package com.j.dao;

import java.util.List;

import com.j.pojo.Manufacturer;

public interface ManufacturerDao {
	//增
	public boolean insertManufacturer(Manufacturer manufacturer);
	//删
	public boolean deleteManufacturer(String name);
	public boolean deleteManufacturer(List list);
	//查
	public Manufacturer queryOneMFId(int id);//id查询厂商全部信息
	public Manufacturer queryOneMFName(String name);//名称查询厂商全部信息
	public List<Manufacturer> queryAllMF();//查询全部厂商信息
	//改
	public boolean updateManufacturer(String name);
	public boolean updateManufacturer(int id);
}
