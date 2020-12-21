package com.j.pojo;

import java.util.Date;

public class Goods {
	private int g_id;
	private String g_name;
	private double g_price;
	private int g_code;
	private double g_promt_price;
	private String g_promt_date_start;
	private String g_promt_date_stop;
	private int g_promt_num_number;
	private int g_discount;
	private int g_promt_data; 
	private int g_promt_num;
	private int g_stock;
	private int g_stock_urgent;
	private int g_plan;
	private int g_sale;
	private int mf_id;
	private int sp_id;
	
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public double getG_price() {
		return g_price;
	}
	public void setG_price(double g_price) {
		this.g_price = g_price;
	}
	public int getG_code() {
		return g_code;
	}
	public void setG_code(int g_code) {
		this.g_code = g_code;
	}
	public double getG_promt_price() {
		return g_promt_price;
	}
	public void setG_promt_price(double g_promt_price) {
		this.g_promt_price = g_promt_price;
	}
	public String getG_promt_date_start() {
		return g_promt_date_start;
	}
	public void setG_promt_date_start(String g_promt_date_start) {
		this.g_promt_date_start = g_promt_date_start;
	}
	public String getG_promt_date_stop() {
		return g_promt_date_stop;
	}
	public void setG_promt_date_stop(String g_promt_date_stop) {
		this.g_promt_date_stop = g_promt_date_stop;
	}
	public int getG_promt_num_number() {
		return g_promt_num_number;
	}
	public void setG_promt_num_number(int g_promt_num_number) {
		this.g_promt_num_number = g_promt_num_number;
	}
	public int getG_discount() {
		return g_discount;
	}
	public void setG_discount(int g_discount) {
		this.g_discount = g_discount;
	}
	public int getG_promt_data() {
		return g_promt_data;
	}
	public void setG_promt_data(int g_promt_data) {
		this.g_promt_data = g_promt_data;
	}
	public int getG_promt_num() {
		return g_promt_num;
	}
	public void setG_promt_num(int g_promt_num) {
		this.g_promt_num = g_promt_num;
	}
	public int getG_stock() {
		return g_stock;
	}
	public void setG_stock(int g_stock) {
		this.g_stock = g_stock;
	}
	public int getG_stock_urgent() {
		return g_stock_urgent;
	}
	public void setG_stock_urgent(int g_stock_urgent) {
		this.g_stock_urgent = g_stock_urgent;
	}
	public int getG_plan() {
		return g_plan;
	}
	public void setG_plan(int g_plan) {
		this.g_plan = g_plan;
	}
	public int getG_sale() {
		return g_sale;
	}
	public void setG_sale(int g_sale) {
		this.g_sale = g_sale;
	}
	public int getMf_id() {
		return mf_id;
	}
	public void setMf_id(int mf_id) {
		this.mf_id = mf_id;
	}
	public int getSp_id() {
		return sp_id;
	}
	public void setSp_id(int sp_id) {
		this.sp_id = sp_id;
	}
	
//	public void CXpanduan() {
////		String pd=null;
//		System.out.println("�ж��Ƿ������"+g_discount);
//		if(g_discount==0) {
//			this.pd = "��";
//		}else {
//			this.pd = "��";
//		}
//	}
	
	private String pdis;
	private String psale;
	private String pdate;
	private String pnum;
	private String pdstart;
	private String pdstop;
	
	@Override
	public String toString() {
		if(g_discount==1) {
			this.pdis = "��";
		}else {
			this.pdis = "��";
		}
		return "��ƷID:" + g_id + ", ��Ʒ����:" + g_name + ", ��Ʒ�۸�:" + g_price + ", ��Ʒ��������:" + g_code
				+ ", ��Ʒ�����۸�:" + g_promt_price + ", ��Ʒ������ʼ����:" + g_promt_date_start
				+ ", ��Ʒ������ֹ����:" + g_promt_date_stop +",������Ʒ������"+g_promt_num_number+ ", ��Ʒ�Ƿ���۴���:" + pdis +",�Ƿ����ڴ�����"+g_promt_data+",�Ƿ�����������"+g_promt_num+ ", ��Ʒ�����:" + g_stock
				+ ", ��Ʒ��汨������:" + g_stock_urgent + ", ��Ʒ�ƻ���������:" + g_plan + ", ��Ʒ�Ƿ���������:" + g_sale + ", ��Ʒ���̱�ţ�"
				+ mf_id + ", ��Ʒ��Ӧ�̱��:" + sp_id;
	}
	public String toString2() {
		if(g_discount==1) {
			this.pdis = "��";
		}else {
			this.pdis = "��";
		}
		if(g_sale==1) {
			this.psale = "��";
		}else {
			this.psale = "��";
		}
		if(g_promt_data==1) {
			this.pdate = "��";
		}else {
			this.pdate = "��";
		}
		if(g_promt_date_start==null) {
			this.pdstart = "��";
		}else {
			this.pdstart = g_promt_date_start;
		}
		if(g_promt_date_stop==null) {
			this.pdstop = "��";
		}else {
			this.pdstop = g_promt_date_stop;
		}
		if(g_promt_num==1) {
			this.pnum = "��";
		}else {
			this.pnum = "��";
		}
		return "��ƷID:" + g_id + ", ��Ʒ����:" + g_name + ", ��Ʒ�۸�:" + g_price + ", ��Ʒ��������:" + g_code
				+ "\n��Ʒ�Ƿ���������:" + psale
				+ "\n��Ʒ�Ƿ���۴���:" + pdis
				+ "\n��Ʒ��ԭ�۸�:"+g_price
				+ "\n��Ʒ�����۸�:" + g_promt_price  
				+ "\n�Ƿ����ڴ�����"+pdate
				+ "\n��Ʒ������ʼ����:" + pdstart+ "\t ��Ʒ������ֹ����:" + pdstop
				+ "\n�Ƿ�����������"+pnum
				+ "\n������Ʒ������"+g_promt_num_number
				+ "\n��Ʒ�����:" + g_stock ;
	}
	public Goods() {
		super();
	}
	//��ID���췽��
	public Goods(String g_name, double g_price, int g_code, double g_promt_price, String g_promt_date_start,
			String g_promt_date_stop, int g_promt_num_number, int g_discount, int g_promt_data, int g_promt_num,
			int g_stock, int g_stock_urgent, int g_plan, int g_sale, int mf_id, int sp_id) {
		super();
		this.g_name = g_name;
		this.g_price = g_price;
		this.g_code = g_code;
		this.g_promt_price = g_promt_price;
		this.g_promt_date_start = g_promt_date_start;
		this.g_promt_date_stop = g_promt_date_stop;
		this.g_promt_num_number = g_promt_num_number;
		this.g_discount = g_discount;
		this.g_promt_data = g_promt_data;
		this.g_promt_num = g_promt_num;
		this.g_stock = g_stock;
		this.g_stock_urgent = g_stock_urgent;
		this.g_plan = g_plan;
		this.g_sale = g_sale;
		this.mf_id = mf_id;
		this.sp_id = sp_id;
	}
	//ȫ�ι��췽��
	public Goods(int g_id, String g_name, double g_price, int g_code, double g_promt_price, String g_promt_date_start,
			String g_promt_date_stop, int g_promt_num_number, int g_discount, int g_promt_data, int g_promt_num,
			int g_stock, int g_stock_urgent, int g_plan, int g_sale, int mf_id, int sp_id) {
		super();
		this.g_id = g_id;
		this.g_name = g_name;
		this.g_price = g_price;
		this.g_code = g_code;
		this.g_promt_price = g_promt_price;
		this.g_promt_date_start = g_promt_date_start;
		this.g_promt_date_stop = g_promt_date_stop;
		this.g_promt_num_number = g_promt_num_number;
		this.g_discount = g_discount;
		this.g_promt_data = g_promt_data;
		this.g_promt_num = g_promt_num;
		this.g_stock = g_stock;
		this.g_stock_urgent = g_stock_urgent;
		this.g_plan = g_plan;
		this.g_sale = g_sale;
		this.mf_id = mf_id;
		this.sp_id = sp_id;
	}
}
