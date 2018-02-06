 package com.jiumenfang.user.bean;
 
 public class PerHt
 {
   private int per_hid;
   private String per_hname;
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
@Override
public String toString() {
	return "PerHt [per_hid=" + per_hid + ", per_hname=" + per_hname + "]";
}
public PerHt(int per_hid, String per_hname) {
	super();
	this.per_hid = per_hid;
	this.per_hname = per_hname;
}
public PerHt() {
	super();
}
 
   
 }

