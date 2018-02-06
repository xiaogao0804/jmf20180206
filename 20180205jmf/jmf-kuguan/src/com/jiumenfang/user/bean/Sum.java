 package com.jiumenfang.user.bean;
 
 public class Sum
 {
   private int sum_id;
   private String sum;
   private String sum_date;
   private int reps_id;
public int getSum_id() {
	return sum_id;
}
public void setSum_id(int sum_id) {
	this.sum_id = sum_id;
}
public String getSum() {
	return sum;
}
public void setSum(String sum) {
	this.sum = sum;
}
public String getSum_date() {
	return sum_date;
}
public void setSum_date(String sum_date) {
	this.sum_date = sum_date;
}
public int getReps_id() {
	return reps_id;
}
public void setReps_id(int reps_id) {
	this.reps_id = reps_id;
}
@Override
public String toString() {
	return "Sum [sum_id=" + sum_id + ", sum=" + sum + ", sum_date=" + sum_date + ", reps_id=" + reps_id + "]";
}
public Sum(int sum_id, String sum, String sum_date, int reps_id) {
	super();
	this.sum_id = sum_id;
	this.sum = sum;
	this.sum_date = sum_date;
	this.reps_id = reps_id;
}
public Sum() {
	super();
}
   
 }

