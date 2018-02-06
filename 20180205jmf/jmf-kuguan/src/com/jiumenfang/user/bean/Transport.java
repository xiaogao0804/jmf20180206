 package com.jiumenfang.user.bean;
 
 public class Transport
 {
   private int tran_id;
   private String tran_name;
   private String tran_date;
public int getTran_id() {
	return tran_id;
}
public void setTran_id(int tran_id) {
	this.tran_id = tran_id;
}
public String getTran_name() {
	return tran_name;
}
public void setTran_name(String tran_name) {
	this.tran_name = tran_name;
}
public String getTran_date() {
	return tran_date;
}
public void setTran_date(String tran_date) {
	this.tran_date = tran_date;
}
@Override
public String toString() {
	return "Transport [tran_id=" + tran_id + ", tran_name=" + tran_name + ", tran_date=" + tran_date + "]";
}
public Transport(int tran_id, String tran_name, String tran_date) {
	super();
	this.tran_id = tran_id;
	this.tran_name = tran_name;
	this.tran_date = tran_date;
}
public Transport() {
	super();
}
 

 }

