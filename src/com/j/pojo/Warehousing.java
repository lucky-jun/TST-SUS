package com.j.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Warehousing {
	private int w_id;
	private int gd_id;
	private String gd_name;
	private int w_innum; 
	private double w_price_unit;
	private double w_price_total;
	private String w_date;
	public int getW_id() {
		return w_id;
	}
	public void setW_id(int w_id) {
		this.w_id = w_id;
	}
	public int getGd_id() {
		return gd_id;
	}
	public void setGd_id(int gd_id) {
		this.gd_id = gd_id;
	}
	public String getGd_name() {
		return gd_name;
	}
	public void setGd_name(String gd_name) {
		this.gd_name = gd_name;
	}
	public int getW_innum() {
		return w_innum;
	}
	public void setW_innum(int w_innum) {
		this.w_innum = w_innum;
	}
	public double getW_price_unit() {
		return w_price_unit;
	}
	public void setW_price_unit(double w_price_unit) {
		this.w_price_unit = w_price_unit;
	}
	public double getW_price_total() {
		return w_price_total;
	}
	public void setW_price_total(double w_price_total) {
		this.w_price_total = w_price_total;
	}
	public String getW_date() {
		return w_date;
	}
	public void setW_date(String date) {
		this.w_date = date;
	}
	@Override
	public String toString() {
		return "Warehousing [w_id=" + w_id + ", gd_id=" + gd_id + ", gd_name=" + gd_name + ", w_innum=" + w_innum
				+ ", w_price_unit=" + w_price_unit + ", w_price_total=" + w_price_total + ", w_date=" + w_date + "]";
	}
	public Warehousing() {
		super();
	}
	public Warehousing(int gd_id, String gd_name, int w_innum, double w_price_unit, double w_price_total) {
		super();
		this.gd_id = gd_id;
		this.gd_name = gd_name;
		this.w_innum = w_innum;
		this.w_price_unit = w_price_unit;
		this.w_price_total = w_price_total;
	}
	public Warehousing(int gd_id, String gd_name, int w_innum, double w_price_unit, double w_price_total,
			String w_date) {
		super();
		this.gd_id = gd_id;
		this.gd_name = gd_name;
		this.w_innum = w_innum;
		this.w_price_unit = w_price_unit;
		this.w_price_total = w_price_total;
		this.w_date = w_date;
	}
	public Warehousing(int w_id, int gd_id, String gd_name, int w_innum, double w_price_unit, double w_price_total,
			String w_date) {
		super();
		this.w_id = w_id;
		this.gd_id = gd_id;
		this.gd_name = gd_name;
		this.w_innum = w_innum;
		this.w_price_unit = w_price_unit;
		this.w_price_total = w_price_total;
		this.w_date = w_date;
	}
	
}
