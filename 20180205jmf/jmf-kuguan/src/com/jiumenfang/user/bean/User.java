 package com.jiumenfang.user.bean;
 
 public class User
 {
   private int user_id;
   private String user_name;
   private String user_password;
   private int per_id;
   private String per_name;
   private int per_hid;
   private String per_hname;
   private int uid;
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
public String getUser_password() {
	return user_password;
}
public void setUser_password(String user_password) {
	this.user_password = user_password;
}
public int getPer_id() {
	return per_id;
}
public void setPer_id(int per_id) {
	this.per_id = per_id;
}
public String getPer_name() {
	return per_name;
}
public void setPer_name(String per_name) {
	this.per_name = per_name;
}
public int getPer_hid() {
	return per_hid;
}
public void setPer_hid(int per_hid) {
	this.per_hid = per_hid;
}
public String getPer_hname() {
	return per_hname;
}
public void setPer_hname(String per_hname) {
	this.per_hname = per_hname;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
@Override
public String toString() {
	return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password + ", per_id="
			+ per_id + ", per_name=" + per_name + ", per_hid=" + per_hid + ", per_hname=" + per_hname + ", uid=" + uid
			+ "]";
}
public User(int user_id, String user_name, String user_password, int per_id, String per_name, int per_hid,
		String per_hname, int uid) {
	super();
	this.user_id = user_id;
	this.user_name = user_name;
	this.user_password = user_password;
	this.per_id = per_id;
	this.per_name = per_name;
	this.per_hid = per_hid;
	this.per_hname = per_hname;
	this.uid = uid;
}
public User() {
	super();
}

 }

