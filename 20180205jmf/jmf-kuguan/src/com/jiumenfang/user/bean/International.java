 package com.jiumenfang.user.bean;
 
 public class International
 {
   private int inter_id;
   private String inter_type;
 
   public int getInter_id()
   {
        return this.inter_id;
   }
   public void setInter_id(int inter_id) {
       this.inter_id = inter_id;
   }
   public String getInter_type() {
       return this.inter_type;
   }
   public void setInter_type(String inter_type) {
       this.inter_type = inter_type;
   }
 
   public International(int inter_id, String inter_type) {
       this.inter_id = inter_id;
       this.inter_type = inter_type;
   }
 
   public International()
   {
   }
 }

