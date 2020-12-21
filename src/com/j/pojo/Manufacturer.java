package com.j.pojo;

public class Manufacturer {
	private int m_id;
	private String m_name;
	private String m_add;
	private String m_tele;
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_add() {
		return m_add;
	}
	public void setM_add(String m_add) {
		this.m_add = m_add;
	}
	public String getM_tele() {
		return m_tele;
	}
	public void setM_tele(String m_tele) {
		this.m_tele = m_tele;
	}
	@Override
	public String toString() {
		return "m_id=" + m_id + ", m_name=" + m_name + ", m_add=" + m_add + ", m_tele=" + m_tele ;
	}
	public Manufacturer() {
		super();
	}
	public Manufacturer(String m_name, String m_add, String m_tele) {
		super();
		this.m_name = m_name;
		this.m_add = m_add;
		this.m_tele = m_tele;
	}
	public Manufacturer(int m_id, String m_name, String m_add, String m_tele) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_add = m_add;
		this.m_tele = m_tele;
	}
}
