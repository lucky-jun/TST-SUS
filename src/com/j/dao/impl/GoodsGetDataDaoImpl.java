package com.j.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j.dao.GoodsGetDataDao;
import com.j.pojo.Goods;
import com.j.util.JDBCUtil;

public class GoodsGetDataDaoImpl implements GoodsGetDataDao {

	@Override
	public List<Goods> queryByID(int id) throws SQLException {
		Goods goods = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//获取连接
		String sql ="select * from goods where g_id=?";
		List<Goods> list = new ArrayList<Goods>();
		try {
			ps = conn.prepareStatement(sql);//创建Statement对象

			ps.setInt(1, id);//设置sql语句中的？号的值，1为？所在位置的下标
			rs = ps.executeQuery();
			while(rs.next()) {
				 int g_id=rs.getInt(1);
				 String g_name=rs.getString(2);
				 double g_price=rs.getDouble(3);
				 int g_code=rs.getInt(4);
				 double g_promt_price=rs.getDouble(5);
				 //时间转换
				 String g_promt_date_start = rs.getString(6);
				 String g_promt_date_stop = rs.getString(7);
				/* String g_promt_date_start=(g_promt_date_start1+" - "+g_promt_date_stop); */
				 int g_promt_num_number = rs.getInt(8);
				 int g_discount=rs.getInt(9);
				 int g_promt_data=rs.getInt(10);
				 int g_promt_num=rs.getInt(11);
				 int g_stock=rs.getInt(12);
				 int g_stock_urgent=rs.getInt(13);
				 int g_plan=rs.getInt(14);
				 int g_sale=rs.getInt(15);
				 int mf_id=rs.getInt(16);
				 int sp_id=rs.getInt(17);
				 goods = new Goods(g_id, g_name, g_price, g_code, g_promt_price, g_promt_date_start, g_promt_date_stop, g_promt_num_number, g_discount, g_promt_data, g_promt_num, g_stock, g_stock_urgent, g_plan, g_sale, mf_id, sp_id);
				 list.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> queryByName(String gname) throws SQLException {
		Goods goods = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//建立连接
		String sql = "select * from goods where g_name=?";
		List<Goods> list = new ArrayList<Goods>();
		try {
			//创建Statement对象
			ps = conn.prepareStatement(sql);
			//设置sql语句的值
			ps.setString(1, gname);
//			System.out.println("++++:"+ps);
			//执行sql语句
			rs = ps.executeQuery();
			
			while(rs.next()) {
				 int g_id=rs.getInt(1);
				 String g_name=rs.getString(2);
				 double g_price=rs.getDouble(3);
				 int g_code=rs.getInt(4);
				 double g_promt_price=rs.getDouble(5);
					//时间转换
					String g_promt_date_start = rs.getString(6);
					String g_promt_date_stop = rs.getString(7);
				/* String g_promt_date_start=(g_promt_date_start1+" - "+g_promt_date_stop); */
				 int g_promt_num_number = rs.getInt(8);
				 int g_discount=rs.getInt(9);
				 int g_promt_data=rs.getInt(10);
				 int g_promt_num=rs.getInt(11);
				 int g_stock=rs.getInt(12);
				 int g_stock_urgent=rs.getInt(13);
				 int g_plan=rs.getInt(14);
				 int g_sale=rs.getInt(15);
				 int mf_id=rs.getInt(16);
				 int sp_id=rs.getInt(17);
				 goods = new Goods(g_id, g_name, g_price, g_code, g_promt_price, g_promt_date_start, g_promt_date_stop, g_promt_num_number, g_discount, g_promt_data, g_promt_num, g_stock, g_stock_urgent, g_plan, g_sale, mf_id, sp_id);
//				 System.out.println("6666:"+goods);
				 list.add(goods);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean updateByGoods(Goods goods) throws SQLException {
		Connection conn = JDBCUtil.getConn();
		String sql = "update goods set g_name=?, g_price=?, g_code=?, g_promt_price=?, g_promt_date_start=?, g_promt_date_stop=?, g_promt_num_number=?, g_discount=?, g_promt_data=?, g_promt_num=?, g_stock=?, g_stock_urgent=?, g_plan=?, g_sale=?, mf_id=?, sp_id=? where g_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, goods.getG_name());
		ps.setDouble(2, goods.getG_price());
		ps.setInt(3, goods.getG_code());
		ps.setDouble(4, goods.getG_promt_price());
		ps.setString(5, goods.getG_promt_date_start());
		ps.setString(6, goods.getG_promt_date_stop());
		ps.setInt(7, goods.getG_promt_num_number());
		ps.setInt(8, goods.getG_discount());
		ps.setInt(9, goods.getG_promt_data());
		ps.setInt(10, goods.getG_promt_num());
		ps.setInt(11, goods.getG_stock());
		ps.setInt(12, goods.getG_stock_urgent());
		ps.setInt(13, goods.getG_plan());
		ps.setInt(14, goods.getG_sale());
		ps.setInt(15, goods.getMf_id());
		ps.setInt(16, goods.getSp_id());
		ps.setInt(17, goods.getG_id());
//		System.out.println(ps);
		int b = ps.executeUpdate();
//		System.out.println("------------:"+b);
//		System.out.println("+++++++++++:"+(b>0?true:false));
		return b>0?true:false;
	}

	@Override
	public boolean deleteByID(String id) throws SQLException {
		Goods goods = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();//建立连接
		String sql = "delete from goods where g_id  in("+id+")";
		try {
			//创建Statement对象
			ps = conn.prepareStatement(sql);
			//设置sql语句的值
//			ps.setString(1, id);
			//执行sql语句
			int i = ps.executeUpdate();
//			System.out.println("删除商品返回值："+i);
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	


	@Override
	public List<Goods> queryByCode(int code) throws SQLException {
		Goods goods = null;
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConn();
		String sql ="select * from goods where g_code=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, code);
		rs = ps.executeQuery();
		List<Goods> list = new ArrayList<Goods>();
		while(rs.next()) {
			int g_id = rs.getInt(1);
			String g_name = rs.getString(2);
			int g_code = rs.getInt(4);
			goods = new Goods();
			goods.setG_id(g_id);
			goods.setG_name(g_name);
			goods.setG_code(g_code);
			list.add(goods);
		}
		return list;
	}

	@Override
	public boolean insertGoods(Goods goods) throws SQLException {
//		System.out.println("qqqqqqqqqqqqqqqqqqq:"+goods);
		Goods goods1 = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//创建连接
		conn=JDBCUtil.getConn();
		//SQL语句
		String sql= "insert into goods( g_name, g_price, g_code, g_promt_price, g_promt_date_start, g_promt_date_stop, g_promt_num_number, g_discount, g_promt_data, g_promt_num, g_stock, g_stock_urgent, g_plan, g_sale, mf_id, sp_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
				//创建Statement对象
				ps= conn.prepareStatement(sql);
				//填写SQL语句
				ps.setString(1, goods.getG_name());
				ps.setDouble(2, goods.getG_price());
				ps.setInt(3, goods.getG_code());
				ps.setDouble(4, goods.getG_promt_price());
				ps.setString(5, goods.getG_promt_date_start());
				ps.setString(6, goods.getG_promt_date_stop());
//				System.out.println(goods.getG_promt_date_start());
//				System.out.println(goods.getG_promt_date_stop());
				ps.setInt(7, goods.getG_promt_num_number());
				ps.setInt(8, goods.getG_discount());
				ps.setInt(9, goods.getG_promt_data());
				ps.setInt(10, goods.getG_promt_num());
				ps.setInt(11, goods.getG_stock());
				ps.setInt(12, goods.getG_stock_urgent());
				ps.setInt(13, goods.getG_plan());
				ps.setInt(14, goods.getG_sale());
				ps.setInt(15, goods.getMf_id());
				ps.setInt(16, goods.getSp_id());
				//执行SQL语句
				int i = ps.executeUpdate();
//				System.out.println("插入返回结果值："+i);
				if(i>0) {
					return true;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Goods> queryPageGoods(int page, int limit) throws SQLException {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select * from goods limit ?,?");
		ps.setInt(1, page);
		ps.setInt(2, limit);
		ResultSet rs = ps.executeQuery();
		List<Goods> list = new ArrayList<Goods>();
		while(rs.next()){
			int id = rs.getInt(1);
			String name = rs.getString(2);
			double price = rs.getDouble(3);
			int code = rs.getInt(4);
			double g_promt_price = rs.getDouble(5);
			//时间转换
			String g_promt_date_start = rs.getString(6);
			String g_promt_date_stop = rs.getString(7);
			/* String g_promt_date_start=(g_promt_date_start1+" - "+g_promt_date_stop); */
			
			int g_promt_num_number = rs.getInt(8);
			int g_discount = rs.getInt(9);
			int g_promt_data = rs.getInt(10);
			int g_promt_num = rs.getInt(11);
			int g_stock = rs.getInt(12);
			int g_stock_urgent = rs.getInt(13);
			int g_plan = rs.getInt(14);
			int g_sale = rs.getInt(15);
			int mf_id = rs.getInt(16);
			int sp_id = rs.getInt(17);
			Goods goods = new Goods(id, name, price, code, g_promt_price, g_promt_date_start, g_promt_date_stop, g_promt_num_number, g_discount, g_promt_data, g_promt_num, g_stock, g_stock_urgent, g_plan, g_sale, mf_id, sp_id);
			list.add(goods);
		}
		return list;
	}

	@Override
	public int queryCountGoods() throws SQLException {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select count(g_id) from goods");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}
//商品下架
	@Override
	public boolean updataSale(String id,int g_sale) throws SQLException {
		Connection conn = JDBCUtil.getConn();
//		System.out.println("Dao_g_sale:"+g_sale);
//		System.out.println("id:"+id);
		String sql = "update goods set g_sale=? where g_id in("+id+")";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, g_sale);
//		String[] split = id.split(",");
//		String b ="";
//		int c= {};
//		List<Integer> list = new ArrayList<Integer>();
//		for(String a:split) {
//			list.add(Integer.parseInt(a));
//		}
//		System.out.println(b);
//		ps.setString(2, id);
//		System.out.println(ps);
		int i = ps.executeUpdate();
//		System.out.println(i>0?true:false);
		return i>0?true:false;
	}

	

}
