package com.j.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j.dao.SupplierDao;
import com.j.pojo.Manufacturer;
import com.j.pojo.Supplier;
import com.j.util.JDBCUtil;

public class SupplierDaoImpl implements SupplierDao{

	@Override
	public boolean insertSupplier(Supplier supplier) {
		Supplier sp = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//建立连接
		String sql ="insert into Supplier(s_id,s_name,s_add,s_tele) values(?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, supplier.getS_id());
			ps.setString(2, supplier.getS_name());
			ps.setString(3, supplier.getS_add());
			ps.setString(4, supplier.getS_tele());
			int i = ps.executeUpdate();
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteSupplier(String name) {
		Supplier sp = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//建立连接
		String sql ="delete from Supplier where s_name=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			int i = ps.executeUpdate();
			return i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Supplier querySupplier(String name) {
		Supplier sp = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//建立连接
		String sql ="select * from Supplier where s_name=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				int s_id = rs.getInt(1);
				String s_name = rs.getString(2);
				String s_add = rs.getString(3);
				String s_tele = rs.getString(4);
				sp = new Supplier(s_id, s_name, s_add, s_tele);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sp;
	}

	@Override
	public Supplier querySupplier(int id) {
		Supplier sp = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//建立连接
		String sql ="select * from Supplier where s_id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int s_id = rs.getInt(1);
				String s_name = rs.getString(2);
				String s_add = rs.getString(3);
				String s_tele = rs.getString(4);
				sp = new Supplier(s_id, s_name, s_add, s_tele);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println();
		return sp;
	}

	@Override
	public List<Supplier> queryAll() {
		Supplier sp = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//建立连接
		String sql ="select * from Supplier";
		List<Supplier> list = new ArrayList<Supplier>();
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int s_id = rs.getInt(1);
				String s_name = rs.getString(2);
				String s_add = rs.getString(3);
				String s_tele = rs.getString(4);
				sp = new Supplier(s_id, s_name, s_add, s_tele);
				list.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean updateSupplier(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
