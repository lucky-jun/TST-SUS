package com.j.pojo;

public class Supplier {
	private int s_id;
	private String s_name;
	private String s_add;
	private String s_tele;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_add() {
		return s_add;
	}
	public void setS_add(String s_add) {
		this.s_add = s_add;
	}
	public String getS_tele() {
		return s_tele;
	}
	public void setS_tele(String s_tele) {
		this.s_tele = s_tele;
	}
	@Override
	public String toString() {
		return "Supplier [s_id=" + s_id + ", s_name=" + s_name + ", s_add=" + s_add + ", s_tele=" + s_tele + "]";
	}
	public Supplier() {
		super();
	}
	public Supplier(String s_name, String s_add, String s_tele) {
		super();
		this.s_name = s_name;
		this.s_add = s_add;
		this.s_tele = s_tele;
	}
	public Supplier(int s_id, String s_name, String s_add, String s_tele) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_add = s_add;
		this.s_tele = s_tele;
	}
}
