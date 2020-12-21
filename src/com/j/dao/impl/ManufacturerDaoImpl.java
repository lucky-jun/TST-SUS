package com.j.dao.impl;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j.dao.ManufacturerDao;
import com.j.pojo.Goods;
import com.j.pojo.Manufacturer;
import com.j.util.JDBCUtil;

public class ManufacturerDaoImpl implements ManufacturerDao{

	@Override
	public boolean insertManufacturer(Manufacturer manufacturer) {
		Manufacturer mf = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//建立连接
		String sql ="insert into Manufacturer(m_id,m_name,m_add,m_tele) values(?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, manufacturer.getM_id());
			ps.setString(2, manufacturer.getM_name());
			ps.setString(3, manufacturer.getM_add());
			ps.setString(4, manufacturer.getM_tele());
			int i = ps.executeUpdate();
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteManufacturer(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteManufacturer(List list) {
		Manufacturer mf = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//建立连接
		String sql ="";
		return false;
	}

	@Override
	public Manufacturer queryOneMFId(int id) {
		Manufacturer mf = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//建立连接
		String sql ="select * from Manufacturer where m_id=?";
//		List<Manufacturer> list = new ArrayList<Manufacturer>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int m_id = rs.getInt(1);
				String m_name = rs.getString(2);
				String m_add = rs.getString(3);
				String m_tele = rs.getString(4);
				mf = new Manufacturer(m_id, m_name, m_add, m_tele);
//				list.add(mf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mf;
	}

	@Override
	public Manufacturer queryOneMFName(String name) {
		Manufacturer mf = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//建立连接
		String sql ="select * from Manufacturer where m_name=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				int m_id = rs.getInt(1);
				String m_name = rs.getString(2);
				String m_add = rs.getString(3);
				String m_tele = rs.getString(4);
				mf = new Manufacturer(m_id, m_name, m_add, m_tele);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mf;
	}

	@Override
	public List<Manufacturer> queryAllMF() {
		Manufacturer mf = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//建立连接
		String sql ="select * from Manufacturer";
		List<Manufacturer> list = new ArrayList<Manufacturer>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String add = rs.getString(3);
				String tel = rs.getString(4);
				Manufacturer manufacturer = new Manufacturer(id, name, add, tel);
				list.add(manufacturer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean updateManufacturer(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateManufacturer(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
