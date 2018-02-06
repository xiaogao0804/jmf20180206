 package com.jiumenfang.user.bean;
 
 public class Client
 {
   private int client_id;
   private String client_name;
   private String client_tel;
   private String client_date;
   private int user_id;
 
   public int getClient_id()
   {
       return this.client_id;
   }
   public void setClient_id(int client_id) {
       this.client_id = client_id;
   }
   public String getClient_name() {
       return this.client_name;
   }
   public void setClient_name(String client_name) {
       this.client_name = client_name;
   }
   public String getClient_tel() {
       return this.client_tel;
   }
   public void setClient_tel(String client_tel) {
       this.client_tel = client_tel;
   }
   public String getClient_date() {
       return this.client_date;
   }
   public void setClient_date(String client_date) {
       this.client_date = client_date;
   }
   public int getUser_id() {
       return this.user_id;
   }
   public void setUser_id(int user_id) {
       this.user_id = user_id;
   }
 
   public String toString() {
       return "Client [client_id=" + this.client_id + ", client_name=" + this.client_name + ", client_tel=" + this.client_tel + 
         ", client_date=" + this.client_date + ", user_id=" + this.user_id + "]";
   }
 
   public Client(int client_id, String client_name, String client_tel, String client_date, int user_id) {
       this.client_id = client_id;
       this.client_name = client_name;
       this.client_tel = client_tel;
       this.client_date = client_date;
       this.user_id = user_id;
   }
 
   public Client()
   {
   }
 }

