 package com.jiumenfang.user.bean;
 
 public class City
 {
   private int city_id;
   private String city_name;
   private String city_date;
   private int user_id;
 
   public int getCity_id()
   {
       return this.city_id;
   }
   public void setCity_id(int city_id) {
       this.city_id = city_id;
   }
   public String getCity_name() {
       return this.city_name;
   }
   public void setCity_name(String city_name) {
       this.city_name = city_name;
   }
   public String getCity_date() {
       return this.city_date;
   }
   public void setCity_date(String city_date) {
       this.city_date = city_date;
   }
   public int getUser_id() {
       return this.user_id;
   }
   public void setUser_id(int user_id) {
       this.user_id = user_id;
   }
 
   public String toString() {
       return "City [city_id=" + this.city_id + ", city_name=" + this.city_name + ", city_date=" + this.city_date + ", user_id=" + 
         this.user_id + "]";
   }
 
   public City(int city_id, String city_name, String city_date, int user_id) {
       this.city_id = city_id;
     this.city_name = city_name;
     this.city_date = city_date;
     this.user_id = user_id;
   }
 
   public City()
   {
   }
 }

