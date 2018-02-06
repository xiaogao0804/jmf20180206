 package com.jiumenfang.user.bean;
 
 public class Pa
 {
   private int pa_id;
   private int shelf_id;
   private String shelf_type;
   private int rep_id;
   private String rep_enter;
   private String bar_message;
   private String rep_end;
   private int number_id;
   private String number_num;
   private String number_date;
   private int user_id;
   private String user_name;
   private int bz_id;
   private String bz_name;
   private String pa_date;
   private String bz_date;
   private String p_date;
   private String pa_date1;
 
   public int getPa_id()
   {
        return this.pa_id;
   }
   public void setPa_id(int pa_id) {
        this.pa_id = pa_id;
   }
   public int getShelf_id() {
        return this.shelf_id;
   }
   public void setShelf_id(int shelf_id) {
        this.shelf_id = shelf_id;
   }
   public String getShelf_type() {
        return this.shelf_type;
   }
   public void setShelf_type(String shelf_type) {
        this.shelf_type = shelf_type;
   }
   public int getRep_id() {
        return this.rep_id;
   }
   public void setRep_id(int rep_id) {
        this.rep_id = rep_id;
   }
   public String getRep_enter() {
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
   public String getRep_end() {
        return this.rep_end;
   }
   public void setRep_end(String rep_end) {
        this.rep_end = rep_end;
   }
   public int getNumber_id() {
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
   public int getBz_id() {
        return this.bz_id;
   }
   public void setBz_id(int bz_id) {
        this.bz_id = bz_id;
   }
   public String getBz_name() {
       return this.bz_name;
   }
   public void setBz_name(String bz_name) {
       this.bz_name = bz_name;
   }
   public String getPa_date() {
       return this.pa_date;
   }
   public void setPa_date(String pa_date) {
       this.pa_date = pa_date;
   }
   public String getBz_date() {
       return this.bz_date;
   }
   public void setBz_date(String bz_date) {
       this.bz_date = bz_date;
   }
   public String getP_date() {
       return this.p_date;
   }
   public void setP_date(String p_date) {
       this.p_date = p_date;
   }
   public String getPa_date1() {
       return this.pa_date1;
   }
   public void setPa_date1(String pa_date1) {
       this.pa_date1 = pa_date1;
   }
 
   public String toString() {
       return "Pa [pa_id=" + this.pa_id + ", shelf_id=" + this.shelf_id + ", shelf_type=" + this.shelf_type + ", rep_id=" + this.rep_id + 
         ", rep_enter=" + this.rep_enter + ", bar_message=" + this.bar_message + ", rep_end=" + this.rep_end + ", number_id=" + 
         this.number_id + ", number_num=" + this.number_num + ", number_date=" + this.number_date + ", user_id=" + this.user_id + 
         ", user_name=" + this.user_name + ", bz_id=" + this.bz_id + ", bz_name=" + this.bz_name + ", pa_date=" + this.pa_date + 
         ", bz_date=" + this.bz_date + ", p_date=" + this.p_date + ", pa_date1=" + this.pa_date1 + "]";
   }
 
   public Pa(int pa_id, int shelf_id, String shelf_type, int rep_id, String rep_enter, String bar_message, String rep_end, int number_id, String number_num, String number_date, int user_id, String user_name, int bz_id, String bz_name, String pa_date, String bz_date, String p_date, String pa_date1)
   {
       this.pa_id = pa_id;
       this.shelf_id = shelf_id;
       this.shelf_type = shelf_type;
       this.rep_id = rep_id;
       this.rep_enter = rep_enter;
       this.bar_message = bar_message;
       this.rep_end = rep_end;
       this.number_id = number_id;
       this.number_num = number_num;
       this.number_date = number_date;
       this.user_id = user_id;
       this.user_name = user_name;
       this.bz_id = bz_id;
       this.bz_name = bz_name;
       this.pa_date = pa_date;
       this.bz_date = bz_date;
       this.p_date = p_date;
       this.pa_date1 = pa_date1;
   }
 
   public Pa()
   {
   }
 }

