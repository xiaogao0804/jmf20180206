 package com.jiumenfang.user.bean;
 
 public class Permission
 {
   private int per_id;
   private String per_name;
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
@Override
public String toString() {
	return "Permission [per_id=" + per_id + ", per_name=" + per_name + "]";
}
public Permission(int per_id, String per_name) {
	super();
	this.per_id = per_id;
	this.per_name = per_name;
}
public Permission() {
	super();
}
 

 }

