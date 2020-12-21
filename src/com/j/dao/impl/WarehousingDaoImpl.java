package com.j.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.j.dao.WarehousingDao;
import com.j.pojo.Goods;
import com.j.pojo.Warehousing;
import com.j.util.JDBCUtil;

public class WarehousingDaoImpl implements WarehousingDao{
	@Override
	public Warehousing queryOneName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Warehousing queryOneName(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Warehousing queryOneDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Warehousing> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

//	添加信息
	@Override
	public boolean insertWarehousing(Warehousing whsing) {
//		Warehousing whsing = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//创建连接
		conn=JDBCUtil.getConn();
		//SQL语句
		String sql= "insert into warehousing(gd_id,gd_name,w_innum,w_price_unit,w_price_total,w_date) values(?,?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, whsing.getGd_id());
			ps.setString(2, whsing.getGd_name());
			ps.setInt(3, whsing.getW_innum());
			ps.setDouble(4, whsing.getW_price_unit());
			ps.setDouble(5, whsing.getW_price_total());
			ps.setString(6, whsing.getW_date());
			int i = ps.executeUpdate();
			return i>0?true:false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteWarehousing(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWarehousing(int id) {
		Goods goods = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//建立连接
		String sql = "delete from Warehousing where gd_id =?";
			//创建Statement对象
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				int i = ps.executeUpdate();
				return i>0?true:false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean updateWarehousing(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateWarehousing(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
