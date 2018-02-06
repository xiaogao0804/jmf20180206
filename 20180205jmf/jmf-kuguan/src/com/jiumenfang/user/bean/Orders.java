 package com.jiumenfang.user.bean;
 
 public class Orders
 {
   private int order_id;
   private String order_num;
   private String orders_date;
   private int status_id;
   private String status_name;
   private int user_id;
   private int out_id;
   private int rep_id;
   private String out_num;
   private String out_date;
   private String out_sum;
   private String user_name;
   private int status_ids;
   private String status_names;
   private int reps_id;
   private String orders_date1;
 
   public int getOrder_id()
   {
        return this.order_id;
   }
   public void setOrder_id(int order_id) {
        this.order_id = order_id;
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
   public int getUser_id() {
        return this.user_id;
   }
   public void setUser_id(int user_id) {
        this.user_id = user_id;
   }
   public int getOut_id() {
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
   public String getOut_num() {
        return this.out_num;
   }
   public void setOut_num(String out_num) {
        this.out_num = out_num;
   }
   public String getOut_date() {
        return this.out_date;
   }
   public void setOut_date(String out_date) {
        this.out_date = out_date;
   }
   public String getOut_sum() {
        return this.out_sum;
   }
   public void setOut_sum(String out_sum) {
        this.out_sum = out_sum;
   }
   public String getUser_name() {
        return this.user_name;
   }
   public void setUser_name(String user_name) {
        this.user_name = user_name;
   }
   public int getStatus_ids() {
        return this.status_ids;
   }
   public void setStatus_ids(int status_ids) {
        this.status_ids = status_ids;
   }
   public String getStatus_names() {
       return this.status_names;
   }
   public void setStatus_names(String status_names) {
       this.status_names = status_names;
   }
   public int getReps_id() {
       return this.reps_id;
   }
   public void setReps_id(int reps_id) {
       this.reps_id = reps_id;
   }
   public String getOrders_date1() {
       return this.orders_date1;
   }
   public void setOrders_date1(String orders_date1) {
       this.orders_date1 = orders_date1;
   }
 
   public String toString() {
       return "Orders [order_id=" + this.order_id + ", order_num=" + this.order_num + ", orders_date=" + this.orders_date + 
         ", status_id=" + this.status_id + ", status_name=" + this.status_name + ", user_id=" + this.user_id + ", out_id=" + 
         this.out_id + ", rep_id=" + this.rep_id + ", out_num=" + this.out_num + ", out_date=" + this.out_date + ", out_sum=" + 
         this.out_sum + ", user_name=" + this.user_name + ", status_ids=" + this.status_ids + ", status_names=" + this.status_names + 
         ", reps_id=" + this.reps_id + ", orders_date1=" + this.orders_date1 + "]";
   }
 
   public Orders(int order_id, String order_num, String orders_date, int status_id, String status_name, int user_id, int out_id, int rep_id, String out_num, String out_date, String out_sum, String user_name, int status_ids, String status_names, int reps_id, String orders_date1)
   {
       this.order_id = order_id;
       this.order_num = order_num;
       this.orders_date = orders_date;
       this.status_id = status_id;
       this.status_name = status_name;
       this.user_id = user_id;
       this.out_id = out_id;
       this.rep_id = rep_id;
       this.out_num = out_num;
       this.out_date = out_date;
       this.out_sum = out_sum;
       this.user_name = user_name;
       this.status_ids = status_ids;
       this.status_names = status_names;
       this.reps_id = reps_id;
       this.orders_date1 = orders_date1;
   }
 
   public Orders()
   {
   }
 }

