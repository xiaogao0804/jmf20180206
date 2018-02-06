 package com.jiumenfang.user.bean;
 
 public class chuOrder
 {
   private String order_num;
   private String rep_enters;
   private String bar_message;
   private int out_num;
   private String shelf_type;
   private String chan_name;
   private String tran_name;
   private String city_name;
   private String user_name;
   private String address_notes;
   private String client_name;
   private String yundan;
public String getOrder_num() {
	return order_num;
}
public void setOrder_num(String order_num) {
	this.order_num = order_num;
}
public String getRep_enters() {
	return rep_enters;
}
public void setRep_enters(String rep_enters) {
	this.rep_enters = rep_enters;
}
public String getBar_message() {
	return bar_message;
}
public void setBar_message(String bar_message) {
	this.bar_message = bar_message;
}
public int getOut_num() {
	return out_num;
}
public void setOut_num(int out_num) {
	this.out_num = out_num;
}
public String getShelf_type() {
	return shelf_type;
}
public void setShelf_type(String shelf_type) {
	this.shelf_type = shelf_type;
}
public String getChan_name() {
	return chan_name;
}
public void setChan_name(String chan_name) {
	this.chan_name = chan_name;
}
public String getTran_name() {
	return tran_name;
}
public void setTran_name(String tran_name) {
	this.tran_name = tran_name;
}
public String getCity_name() {
	return city_name;
}
public void setCity_name(String city_name) {
	this.city_name = city_name;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getAddress_notes() {
	return address_notes;
}
public void setAddress_notes(String address_notes) {
	this.address_notes = address_notes;
}
public String getClient_name() {
	return client_name;
}
public void setClient_name(String client_name) {
	this.client_name = client_name;
}
public String getYundan() {
	return yundan;
}
public void setYundan(String yundan) {
	this.yundan = yundan;
}
@Override
public String toString() {
	return "chuOrder [order_num=" + order_num + ", rep_enters=" + rep_enters + ", bar_message=" + bar_message
			+ ", out_num=" + out_num + ", shelf_type=" + shelf_type + ", chan_name=" + chan_name + ", tran_name="
			+ tran_name + ", city_name=" + city_name + ", user_name=" + user_name + ", address_notes=" + address_notes
			+ ", client_name=" + client_name + ", yundan=" + yundan + "]";
}
public chuOrder(String order_num, String rep_enters, String bar_message, int out_num, String shelf_type,
		String chan_name, String tran_name, String city_name, String user_name, String address_notes,
		String client_name, String yundan) {
	super();
	this.order_num = order_num;
	this.rep_enters = rep_enters;
	this.bar_message = bar_message;
	this.out_num = out_num;
	this.shelf_type = shelf_type;
	this.chan_name = chan_name;
	this.tran_name = tran_name;
	this.city_name = city_name;
	this.user_name = user_name;
	this.address_notes = address_notes;
	this.client_name = client_name;
	this.yundan = yundan;
}
public chuOrder() {
	super();
}

  
 }

