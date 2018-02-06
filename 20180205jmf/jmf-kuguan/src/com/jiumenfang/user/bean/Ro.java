 package com.jiumenfang.user.bean;
 
 public class Ro
 {
   private int ro_id;
   private int rep_id;
   private String out_sum;
public int getRo_id() {
	return ro_id;
}
public void setRo_id(int ro_id) {
	this.ro_id = ro_id;
}
public int getRep_id() {
	return rep_id;
}
public void setRep_id(int rep_id) {
	this.rep_id = rep_id;
}
public String getOut_sum() {
	return out_sum;
}
public void setOut_sum(String out_sum) {
	this.out_sum = out_sum;
}
@Override
public String toString() {
	return "Ro [ro_id=" + ro_id + ", rep_id=" + rep_id + ", out_sum=" + out_sum + "]";
}
public Ro(int ro_id, int rep_id, String out_sum) {
	super();
	this.ro_id = ro_id;
	this.rep_id = rep_id;
	this.out_sum = out_sum;
}
public Ro() {
	super();
}
 

 }

