 package com.jiumenfang.user.bean;
 
 public class Ends
 {
   private int end_id;
   private int end_num;
   private int rep_id;
 
   public int getEnd_id()
   {
        return this.end_id;
   }
   public void setEnd_id(int end_id) {
       this.end_id = end_id;
   }
   public int getEnd_num() {
       return this.end_num;
   }
   public void setEnd_num(int end_num) {
       this.end_num = end_num;
   }
   public int getRep_id() {
       return this.rep_id;
   }
   public void setRep_id(int rep_id) {
       this.rep_id = rep_id;
   }
 
   public String toString() {
       return "Ends [end_id=" + this.end_id + ", end_num=" + this.end_num + ", rep_id=" + this.rep_id + "]";
   }
 
   public Ends(int end_id, int end_num, int rep_id) {
       this.end_id = end_id;
       this.end_num = end_num;
       this.rep_id = rep_id;
   }
 
   public Ends()
   {
   }
 }

