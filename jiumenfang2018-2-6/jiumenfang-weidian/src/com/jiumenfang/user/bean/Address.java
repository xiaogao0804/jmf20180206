package com.jiumenfang.user.bean;

public class Address {
	private int address_id;
	private String address_name;
	private String address_tel;
	private String address;
	private String order_id;
	
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	public String getAddress_tel() {
		return address_tel;
	}
	public void setAddress_tel(String address_tel) {
		this.address_tel = address_tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address_name=" + address_name + ", address_tel=" + address_tel
				+ ", address=" + address + ", order_id=" + order_id + "]";
	}
	public Address(int address_id, String address_name, String address_tel, String address, String order_id) {
		super();
		this.address_id = address_id;
		this.address_name = address_name;
		this.address_tel = address_tel;
		this.address = address;
		this.order_id = order_id;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
