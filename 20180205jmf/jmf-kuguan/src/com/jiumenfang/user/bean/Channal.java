 package com.jiumenfang.user.bean;
 
 public class Channal
 {
   private int chan_id;
   private String chan_name;
   private String chan_date;
   private int rep_id;
   private String chan_rep_date;
   private int user_id;
 
   public int getChan_id()
   {
     return this.chan_id;
   }
   public void setChan_id(int chan_id) {
     this.chan_id = chan_id;
   }
   public String getChan_name() {
     return this.chan_name;
   }
   public void setChan_name(String chan_name) {
     this.chan_name = chan_name;
   }
   public String getChan_date() {
     return this.chan_date;
   }
   public void setChan_date(String chan_date) {
     this.chan_date = chan_date;
   }
   public int getRep_id() {
     return this.rep_id;
   }
   public void setRep_id(int rep_id) {
     this.rep_id = rep_id;
   }
   public String getChan_rep_date() {
     return this.chan_rep_date;
   }
   public void setChan_rep_date(String chan_rep_date) {
     this.chan_rep_date = chan_rep_date;
   }
   public int getUser_id() {
     return this.user_id;
   }
   public void setUser_id(int user_id) {
     this.user_id = user_id;
   }
 
   public String toString() {
     return "Channal [chan_id=" + this.chan_id + ", chan_name=" + this.chan_name + ", chan_date=" + this.chan_date + ", rep_id=" + 
       this.rep_id + ", chan_rep_date=" + this.chan_rep_date + ", user_id=" + this.user_id + "]";
   }
 
   public Channal(int chan_id, String chan_name, String chan_date, int rep_id, String chan_rep_date, int user_id) {
     this.chan_id = chan_id;
     this.chan_name = chan_name;
     this.chan_date = chan_date;
     this.rep_id = rep_id;
     this.chan_rep_date = chan_rep_date;
     this.user_id = user_id;
   }
 
   public Channal(){
   }
 }

