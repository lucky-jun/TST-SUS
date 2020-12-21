package com.j.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.j.dao.EmployeeDao;
import com.j.dao.impl.EmployeeDaoImpl;
import com.j.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	@Override
	public Map<String,Object> queryPassword(String username, String password) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> queryPassword = employeeDao.queryPassword(username, password);
//			System.out.println(queryPassword.get("password"));
//			System.out.println(password);
//			System.out.println(queryPassword.get("password").equals(password));
//			System.out.println(queryPassword.get("password").equals(password));
//			System.out.println(queryPassword.isEmpty());
			if(!queryPassword.isEmpty()) {
				//�ж������Ƿ�һ��
				if(queryPassword.get("password").equals(password)) {
//					System.out.println(queryPassword.get("type"));
					//����һ�£���ȡ�û�Ȩ�޲�����
					Object type = queryPassword.get("type");
//					System.out.println(type);
					map.put("type", type);
					map.put("id",queryPassword.get("id"));
					map.put("flag", true);
					}else {
						//�������ʱ����
						map.put("flag", false);
					}
			}else {
				//���û�������ʱ����
				map.put("flag", false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

}
