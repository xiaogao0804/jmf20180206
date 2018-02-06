 package com.jiumenfang.user.bean;
 
 public class Pandian
 {
   private String p_date;
   private String shelf_type;
   private String rep_enter;
   private String bar_message;
   private String rep_end;
   private String number_num;
   private String bz_name;
   private String user_name;
   private int v;
public String getP_date() {
	return p_date;
}
public void setP_date(String p_date) {
	this.p_date = p_date;
}
public String getShelf_type() {
	return shelf_type;
}
public void setShelf_type(String shelf_type) {
	this.shelf_type = shelf_type;
}
public String getRep_enter() {
	return rep_enter;
}
public void setRep_enter(String rep_enter) {
	this.rep_enter = rep_enter;
}
public String getBar_message() {
	return bar_message;
}
public void setBar_message(String bar_message) {
	this.bar_message = bar_message;
}
public String getRep_end() {
	return rep_end;
}
public void setRep_end(String rep_end) {
	this.rep_end = rep_end;
}
public String getNumber_num() {
	return number_num;
}
public void setNumber_num(String number_num) {
	this.number_num = number_num;
}
public String getBz_name() {
	return bz_name;
}
public void setBz_name(String bz_name) {
	this.bz_name = bz_name;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public int getV() {
	return v;
}
public void setV(int v) {
	this.v = v;
}
@Override
public String toString() {
	return "Pandian [p_date=" + p_date + ", shelf_type=" + shelf_type + ", rep_enter=" + rep_enter + ", bar_message="
			+ bar_message + ", rep_end=" + rep_end + ", number_num=" + number_num + ", bz_name=" + bz_name
			+ ", user_name=" + user_name + ", v=" + v + "]";
}
public Pandian(String p_date, String shelf_type, String rep_enter, String bar_message, String rep_end,
		String number_num, String bz_name, String user_name, int v) {
	super();
	this.p_date = p_date;
	this.shelf_type = shelf_type;
	this.rep_enter = rep_enter;
	this.bar_message = bar_message;
	this.rep_end = rep_end;
	this.number_num = number_num;
	this.bz_name = bz_name;
	this.user_name = user_name;
	this.v = v;
}
public Pandian() {
	super();
}

 
 }