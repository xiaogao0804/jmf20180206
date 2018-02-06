 package com.jiumenfang.user.bean;
 
 public class Repertory
 {
   private int rep_id;
   private String rep_enter;
   private int bar_id;
   private String bar_message;
   private int num;
   private int rep_end;
   private int rep_up;
   private int shelf_id;
   private String shelf_type;
   private int rep_out;
   private int order_id;
   private String order_num;
   private int chan_id;
   private String chan_name;
   private int tran_id;
   private String tran_name;
   private int city_id;
   private String city_name;
   private int out_id;
   private String out_num;
   private String out_date;
   private int user_id;
   private String user_name;
   private int end_id;
   private int end_num;
public int getRep_id() {
	return rep_id;
}
public void setRep_id(int rep_id) {
	this.rep_id = rep_id;
}
public String getRep_enter() {
	return rep_enter;
}
public void setRep_enter(String rep_enter) {
	this.rep_enter = rep_enter;
}
public int getBar_id() {
	return bar_id;
}
public void setBar_id(int bar_id) {
	this.bar_id = bar_id;
}
public String getBar_message() {
	return bar_message;
}
public void setBar_message(String bar_message) {
	this.bar_message = bar_message;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public int getRep_end() {
	return rep_end;
}
public void setRep_end(int rep_end) {
	this.rep_end = rep_end;
}
public int getRep_up() {
	return rep_up;
}
public void setRep_up(int rep_up) {
	this.rep_up = rep_up;
}
public int getShelf_id() {
	return shelf_id;
}
public void setShelf_id(int shelf_id) {
	this.shelf_id = shelf_id;
}
public String getShelf_type() {
	return shelf_type;
}
public void setShelf_type(String shelf_type) {
	this.shelf_type = shelf_type;
}
public int getRep_out() {
	return rep_out;
}
public void setRep_out(int rep_out) {
	this.rep_out = rep_out;
}
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}
public String getOrder_num() {
	return order_num;
}
public void setOrder_num(String order_num) {
	this.order_num = order_num;
}
public int getChan_id() {
	return chan_id;
}
public void setChan_id(int chan_id) {
	this.chan_id = chan_id;
}
public String getChan_name() {
	return chan_name;
}
public void setChan_name(String chan_name) {
	this.chan_name = chan_name;
}
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
public int getCity_id() {
	return city_id;
}
public void setCity_id(int city_id) {
	this.city_id = city_id;
}
public String getCity_name() {
	return city_name;
}
public void setCity_name(String city_name) {
	this.city_name = city_name;
}
public int getOut_id() {
	return out_id;
}
public void setOut_id(int out_id) {
	this.out_id = out_id;
}
public String getOut_num() {
	return out_num;
}
public void setOut_num(String out_num) {
	this.out_num = out_num;
}
public String getOut_date() {
	return out_date;
}
public void setOut_date(String out_date) {
	this.out_date = out_date;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public int getEnd_id() {
	return end_id;
}
public void setEnd_id(int end_id) {
	this.end_id = end_id;
}
public int getEnd_num() {
	return end_num;
}
public void setEnd_num(int end_num) {
	this.end_num = end_num;
}
@Override
public String toString() {
	return "Repertory [rep_id=" + rep_id + ", rep_enter=" + rep_enter + ", bar_id=" + bar_id + ", bar_message="
			+ bar_message + ", num=" + num + ", rep_end=" + rep_end + ", rep_up=" + rep_up + ", shelf_id=" + shelf_id
			+ ", shelf_type=" + shelf_type + ", rep_out=" + rep_out + ", order_id=" + order_id + ", order_num="
			+ order_num + ", chan_id=" + chan_id + ", chan_name=" + chan_name + ", tran_id=" + tran_id + ", tran_name="
			+ tran_name + ", city_id=" + city_id + ", city_name=" + city_name + ", out_id=" + out_id + ", out_num="
			+ out_num + ", out_date=" + out_date + ", user_id=" + user_id + ", user_name=" + user_name + ", end_id="
			+ end_id + ", end_num=" + end_num + "]";
}
public Repertory(int rep_id, String rep_enter, int bar_id, String bar_message, int num, int rep_end, int rep_up,
		int shelf_id, String shelf_type, int rep_out, int order_id, String order_num, int chan_id, String chan_name,
		int tran_id, String tran_name, int city_id, String city_name, int out_id, String out_num, String out_date,
		int user_id, String user_name, int end_id, int end_num) {
	super();
	this.rep_id = rep_id;
	this.rep_enter = rep_enter;
	this.bar_id = bar_id;
	this.bar_message = bar_message;
	this.num = num;
	this.rep_end = rep_end;
	this.rep_up = rep_up;
	this.shelf_id = shelf_id;
	this.shelf_type = shelf_type;
	this.rep_out = rep_out;
	this.order_id = order_id;
	this.order_num = order_num;
	this.chan_id = chan_id;
	this.chan_name = chan_name;
	this.tran_id = tran_id;
	this.tran_name = tran_name;
	this.city_id = city_id;
	this.city_name = city_name;
	this.out_id = out_id;
	this.out_num = out_num;
	this.out_date = out_date;
	this.user_id = user_id;
	this.user_name = user_name;
	this.end_id = end_id;
	this.end_num = end_num;
}
public Repertory() {
	super();
}
 
  
 }

