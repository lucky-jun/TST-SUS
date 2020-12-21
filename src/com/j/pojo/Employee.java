package com.j.pojo;

public class Employee {
	private int em_id;
	private String em_name;
	private int em_age;
	private String em_userid;
	private String em_profession;
	private String em_phonenumber;
	private String em_address;
	private int em_type;
	private String em_username;
	private String em_password;
	public int getEm_id() {
		return em_id;
	}
	public void setEm_id(int em_id) {
		this.em_id = em_id;
	}
	public String getEm_name() {
		return em_name;
	}
	public void setEm_name(String em_name) {
		this.em_name = em_name;
	}
	public int getEm_age() {
		return em_age;
	}
	public void setEm_age(int em_age) {
		this.em_age = em_age;
	}
	public String getEm_userid() {
		return em_userid;
	}
	public void setEm_userid(String em_userid) {
		this.em_userid = em_userid;
	}
	public String getEm_profession() {
		return em_profession;
	}
	public void setEm_profession(String em_profession) {
		this.em_profession = em_profession;
	}
	public String getEm_phonenumber() {
		return em_phonenumber;
	}
	public void setEm_phonenumber(String em_phonenumber) {
		this.em_phonenumber = em_phonenumber;
	}
	public String getEm_address() {
		return em_address;
	}
	public void setEm_address(String em_address) {
		this.em_address = em_address;
	}
	public int getEm_type() {
		return em_type;
	}
	public void setEm_type(int em_type) {
		this.em_type = em_type;
	}
	public String getEm_username() {
		return em_username;
	}
	public void setEm_username(String em_username) {
		this.em_username = em_username;
	}
	public String getEm_password() {
		return em_password;
	}
	public void setEm_password(String em_password) {
		this.em_password = em_password;
	}
	@Override
	public String toString() {
		return "Employee [em_id=" + em_id + ", em_name=" + em_name + ", em_age=" + em_age + ", em_userid=" + em_userid
				+ ", em_profession=" + em_profession + ", em_phonenumber=" + em_phonenumber + ", em_address="
				+ em_address + ", em_type=" + em_type + ", em_username=" + em_username + ", em_password=" + em_password
				+ "]";
	}
	public Employee() {
		super();
	}
	public Employee(int em_type, String em_username, String em_password) {
		super();
		this.em_type = em_type;
		this.em_username = em_username;
		this.em_password = em_password;
	}
	public Employee(int em_id, String em_name, int em_age, String em_userid, String em_profession,
			String em_phonenumber, String em_address, int em_type, String em_username, String em_password) {
		super();
		this.em_id = em_id;
		this.em_name = em_name;
		this.em_age = em_age;
		this.em_userid = em_userid;
		this.em_profession = em_profession;
		this.em_phonenumber = em_phonenumber;
		this.em_address = em_address;
		this.em_type = em_type;
		this.em_username = em_username;
		this.em_password = em_password;
	}
}
