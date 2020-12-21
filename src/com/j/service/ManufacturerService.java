package com.j.service;

import java.util.List;
import java.util.Map;

import com.j.pojo.Manufacturer;

public interface ManufacturerService {
	//增
	public Map<String, Object> insertManufacturer(Manufacturer manufacturer);
	//删
	public Map<String, Object> deleteManufacturer(String name);
	public Map<String, Object> deleteManufacturer();
	//查
	public Map<String, Object> queryOneMFId(int id);//id查询厂商全部信息
	public Map<String, Object> queryOneMFName(String name);//名称查询厂商全部信息
	public List<Manufacturer> queryAllMF();//查询全部厂商信息
	//改
	public Map<String, Object> updateManufacturer(String name);
	public Map<String, Object> updateManufacturer(int id);
}
