 package com.jiumenfang.user.bean;
 
 public class Number
 {
   private int number_id;
   private String number_num;
   private String number_date;
   private int user_id;
   private String user_name;
 
   public int getNumber_id()
   {
       return this.number_id;
   }
   public void setNumber_id(int number_id) {
       this.number_id = number_id;
   }
   public String getNumber_num() {
       return this.number_num;
   }
   public void setNumber_num(String number_num) {
       this.number_num = number_num;
   }
   public String getNumber_date() {
       return this.number_date;
   }
   public void setNumber_date(String number_date) {
       this.number_date = number_date;
   }
   public int getUser_id() {
       return this.user_id;
   }
   public void setUser_id(int user_id) {
       this.user_id = user_id;
   }
   public String getUser_name() {
       return this.user_name;
   }
   public void setUser_name(String user_name) {
       this.user_name = user_name;
   }
 
   public String toString() {
       return "Number [number_id=" + this.number_id + ", number_num=" + this.number_num + ", number_date=" + this.number_date + 
         ", user_id=" + this.user_id + ", user_name=" + this.user_name + "]";
   }
 
   public Number(int number_id, String number_num, String number_date, int user_id, String user_name) {
       this.number_id = number_id;
       this.number_num = number_num;
       this.number_date = number_date;
       this.user_id = user_id;
       this.user_name = user_name;
   }
 
   public Number()
   {
   }
 }

