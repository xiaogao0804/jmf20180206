 package com.jiumenfang.user.bean;
 
 public class Barcode
 {
   private int bar_id;
   private String bar_num;
   private String bar_message;
 
   public int getBar_id()
   {
     return this.bar_id;
   }
   public void setBar_id(int bar_id) {
     this.bar_id = bar_id;
   }
   public String getBar_num() {
     return this.bar_num;
   }
   public void setBar_num(String bar_num) {
     this.bar_num = bar_num;
   }
   public String getBar_message() {
     return this.bar_message;
   }
   public void setBar_message(String bar_message) {
     this.bar_message = bar_message;
   }
 
   public Barcode(int bar_id, String bar_num, String bar_message) {
     this.bar_id = bar_id;
     this.bar_num = bar_num;
     this.bar_message = bar_message;
   }
 
   public Barcode(){
   }
 }

