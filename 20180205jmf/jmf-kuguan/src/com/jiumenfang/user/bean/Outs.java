 package com.jiumenfang.user.bean;
 
 public class Outs
 {
   private int out_id;
   private int rep_id;
   private int out_num;
   private String out_date;
   private int user_id;
   private int orders_id;
   private String order_num;
   private String orders_date;
   private int status_id;
   private String status_name;
 
   public int getOut_id()
   {
       return this.out_id;
   }
   public void setOut_id(int out_id) {
       this.out_id = out_id;
   }
   public int getRep_id() {
       return this.rep_id;
   }
   public void setRep_id(int rep_id) {
       this.rep_id = rep_id;
   }
   public int getOut_num() {
       return this.out_num;
   }
   public void setOut_num(int out_num) {
       this.out_num = out_num;
   }
   public String getOut_date() {
       return this.out_date;
   }
   public void setOut_date(String out_date) {
       this.out_date = out_date;
   }
   public int getUser_id() {
       return this.user_id;
   }
   public void setUser_id(int user_id) {
       this.user_id = user_id;
   }
   public int getOrders_id() {
       return this.orders_id;
   }
   public void setOrders_id(int orders_id) {
       this.orders_id = orders_id;
   }
   public String getOrder_num() {
       return this.order_num;
   }
   public void setOrder_num(String order_num) {
       this.order_num = order_num;
   }
   public String getOrders_date() {
       return this.orders_date;
   }
   public void setOrders_date(String orders_date) {
       this.orders_date = orders_date;
   }
   public int getStatus_id() {
       return this.status_id;
   }
   public void setStatus_id(int status_id) {
       this.status_id = status_id;
   }
   public String getStatus_name() {
       return this.status_name;
   }
   public void setStatus_name(String status_name) {
       this.status_name = status_name;
   }
 
   public String toString() {
       return "Outs [out_id=" + this.out_id + ", rep_id=" + this.rep_id + ", out_num=" + this.out_num + ", out_date=" + this.out_date + 
         ", user_id=" + this.user_id + ", orders_id=" + this.orders_id + ", order_num=" + this.order_num + ", orders_date=" + 
         this.orders_date + ", status_id=" + this.status_id + ", status_name=" + this.status_name + "]";
   }
 
   public Outs(int out_id, int rep_id, int out_num, String out_date, int user_id, int orders_id, String order_num, String orders_date, int status_id, String status_name)
   {
       this.out_id = out_id;
       this.rep_id = rep_id;
       this.out_num = out_num;
       this.out_date = out_date;
       this.user_id = user_id;
       this.orders_id = orders_id;
       this.order_num = order_num;
       this.orders_date = orders_date;
       this.status_id = status_id;
       this.status_name = status_name;
   }
 
   public Outs()
   {
   }
 }

