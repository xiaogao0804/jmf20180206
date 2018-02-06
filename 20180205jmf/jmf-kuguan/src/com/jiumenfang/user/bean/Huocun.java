 package com.jiumenfang.user.bean;
 
 public class Huocun
 {
   private String rep_enter;
   private String bar_message;
   private int num;
   private int rep_end;
   private String shelf_type;
   private String user_name;
 
   public String getRep_enter()
   {
       return this.rep_enter;
   }
   public void setRep_enter(String rep_enter) {
       this.rep_enter = rep_enter;
   }
   public String getBar_message() {
       return this.bar_message;
   }
   public void setBar_message(String bar_message) {
       this.bar_message = bar_message;
   }
   public int getNum() {
       return this.num;
   }
   public void setNum(int num) {
       this.num = num;
   }
   public int getRep_end() {
       return this.rep_end;
   }
   public void setRep_end(int rep_end) {
       this.rep_end = rep_end;
   }
   public String getShelf_type() {
       return this.shelf_type;
   }
   public void setShelf_type(String shelf_type) {
       this.shelf_type = shelf_type;
   }
   public String getUser_name() {
       return this.user_name;
   }
   public void setUser_name(String user_name) {
       this.user_name = user_name;
   }
 
   public String toString() {
       return "Huocun [rep_enter=" + this.rep_enter + ", bar_message=" + this.bar_message + ", num=" + this.num + ", rep_end=" + 
         this.rep_end + ", shelf_type=" + this.shelf_type + ", user_name=" + this.user_name + "]";
   }
 
   public Huocun(String rep_enter, String bar_message, int num, int rep_end, String shelf_type, String user_name) {
       this.rep_enter = rep_enter;
       this.bar_message = bar_message;
       this.num = num;
       this.rep_end = rep_end;
       this.shelf_type = shelf_type;
       this.user_name = user_name;
   }
 
   public Huocun()
   {
   }
 }

