package com.j.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.j.dao.EmployeeDao;
import com.j.pojo.Employee;
import com.j.util.JDBCUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Map<String,Object> queryPassword(String username, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//��ȡ����
		String sql ="select em_id, em_type,em_password from employee where em_username=?";
		ps = conn.prepareStatement(sql);//����Statement����
		ps.setString(1, username);//����sql����еģ��ŵ�ֵ��1Ϊ������λ�õ��±�
		rs = ps.executeQuery();
		Map<String,Object> map = new HashMap<String, Object>();
		while(rs.next()) {
			int id = rs.getInt(1);
			int type = rs.getInt(2);
			String getpassword = rs.getString(3);
//			System.out.println("dao��ѯ���û���Ϊ��"+username);
//			System.out.println("dao��ѯ������Ϊ��"+password);
//			System.out.println("dao��ѯ�ĵ�����Ϊ��"+getpassword);
			map.put("username", username);
			map.put("password", getpassword);
			map.put("type", type);
			map.put("id", id);
		}
//		System.out.println("++++++++:"+username);
//		System.out.println("6666666666:"+password);
		return map;
	}

}
