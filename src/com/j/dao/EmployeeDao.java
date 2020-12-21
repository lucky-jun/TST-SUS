package com.j.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.j.pojo.Employee;

public interface EmployeeDao {
	public Map<String,Object> queryPassword(String username,String password) throws SQLException;
}
