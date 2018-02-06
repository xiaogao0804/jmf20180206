 package com.jiumenfang.user.bean;
 
 public class Address
 {
   private int address_id;
   private String address_name;
   private String address_notes;
   private String address_date;
   private String yundan;
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
public String getAddress_notes() {
	return address_notes;
}
public void setAddress_notes(String address_notes) {
	this.address_notes = address_notes;
}
public String getAddress_date() {
	return address_date;
}
public void setAddress_date(String address_date) {
	this.address_date = address_date;
}
public String getYundan() {
	return yundan;
}
public void setYundan(String yundan) {
	this.yundan = yundan;
}
@Override
public String toString() {
	return "Address [address_id=" + address_id + ", address_name=" + address_name + ", address_notes=" + address_notes
			+ ", address_date=" + address_date + ", yundan=" + yundan + "]";
}
public Address(int address_id, String address_name, String address_notes, String address_date, String yundan) {
	super();
	this.address_id = address_id;
	this.address_name = address_name;
	this.address_notes = address_notes;
	this.address_date = address_date;
	this.yundan = yundan;
}
public Address() {
	super();
}
   
 }

