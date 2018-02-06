 package com.jiumenfang.user.bean;
 
 public class Upload1
 {
   private int upload1_id;
   private String kuaidi;
   private String yundan;
   private String chanpin;
   private int num;
   private String uploadPath1;
   private String uploadDate1;
   private int user_id;
   private String user_name;
   private String uploadDate2;
   private int path1_id;
   private String path1Date;
public int getUpload1_id() {
	return upload1_id;
}
public void setUpload1_id(int upload1_id) {
	this.upload1_id = upload1_id;
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
public String getUploadPath1() {
	return uploadPath1;
}
public void setUploadPath1(String uploadPath1) {
	this.uploadPath1 = uploadPath1;
}
public String getUploadDate1() {
	return uploadDate1;
}
public void setUploadDate1(String uploadDate1) {
	this.uploadDate1 = uploadDate1;
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
public String getUploadDate2() {
	return uploadDate2;
}
public void setUploadDate2(String uploadDate2) {
	this.uploadDate2 = uploadDate2;
}
public int getPath1_id() {
	return path1_id;
}
public void setPath1_id(int path1_id) {
	this.path1_id = path1_id;
}
public String getPath1Date() {
	return path1Date;
}
public void setPath1Date(String path1Date) {
	this.path1Date = path1Date;
}
@Override
public String toString() {
	return "Upload1 [upload1_id=" + upload1_id + ", kuaidi=" + kuaidi + ", yundan=" + yundan + ", chanpin=" + chanpin
			+ ", num=" + num + ", uploadPath1=" + uploadPath1 + ", uploadDate1=" + uploadDate1 + ", user_id=" + user_id
			+ ", user_name=" + user_name + ", uploadDate2=" + uploadDate2 + ", path1_id=" + path1_id + ", path1Date="
			+ path1Date + "]";
}
public Upload1(int upload1_id, String kuaidi, String yundan, String chanpin, int num, String uploadPath1,
		String uploadDate1, int user_id, String user_name, String uploadDate2, int path1_id, String path1Date) {
	super();
	this.upload1_id = upload1_id;
	this.kuaidi = kuaidi;
	this.yundan = yundan;
	this.chanpin = chanpin;
	this.num = num;
	this.uploadPath1 = uploadPath1;
	this.uploadDate1 = uploadDate1;
	this.user_id = user_id;
	this.user_name = user_name;
	this.uploadDate2 = uploadDate2;
	this.path1_id = path1_id;
	this.path1Date = path1Date;
}
public Upload1() {
	super();
}
 
 }

