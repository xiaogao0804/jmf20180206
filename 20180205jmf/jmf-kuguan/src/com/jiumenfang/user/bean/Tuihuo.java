 package com.jiumenfang.user.bean;
 
 public class Tuihuo
 {
   private String uploadDate1;
   private String kuaidi;
   private String yundan;
   private String chanpin;
   private int num;
   private String user_name;
   private String uploadPath1;
public String getUploadDate1() {
	return uploadDate1;
}
public void setUploadDate1(String uploadDate1) {
	this.uploadDate1 = uploadDate1;
}
public String getKuaidi() {
	return kuaidi;
}
public void setKuaidi(String kuaidi) {
	this.kuaidi = kuaidi;
}
public String getYundan() {
	return yundan;
}
public void setYundan(String yundan) {
	this.yundan = yundan;
}
public String getChanpin() {
	return chanpin;
}
public void setChanpin(String chanpin) {
	this.chanpin = chanpin;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getUploadPath1() {
	return uploadPath1;
}
public void setUploadPath1(String uploadPath1) {
	this.uploadPath1 = uploadPath1;
}
@Override
public String toString() {
	return "Tuihuo [uploadDate1=" + uploadDate1 + ", kuaidi=" + kuaidi + ", yundan=" + yundan + ", chanpin=" + chanpin
			+ ", num=" + num + ", user_name=" + user_name + ", uploadPath1=" + uploadPath1 + "]";
}
public Tuihuo(String uploadDate1, String kuaidi, String yundan, String chanpin, int num, String user_name,
		String uploadPath1) {
	super();
	this.uploadDate1 = uploadDate1;
	this.kuaidi = kuaidi;
	this.yundan = yundan;
	this.chanpin = chanpin;
	this.num = num;
	this.user_name = user_name;
	this.uploadPath1 = uploadPath1;
}
public Tuihuo() {
	super();
}
 
 }

