 package com.jiumenfang.user.bean;
 
 import java.awt.image.BufferedImage;
 
 public class Danzheng
 {
   private String uploadDate;
   private String title;
   private String area;
   private String user_name;
   private String uploadPath;
   private BufferedImage uploadImg;
 
   public String getUploadDate()
   {
       return this.uploadDate;
   }
   public void setUploadDate(String uploadDate) {
       this.uploadDate = uploadDate;
   }
   public String getTitle() {
       return this.title;
   }
   public void setTitle(String title) {
       this.title = title;
   }
   public String getArea() {
       return this.area;
   }
   public void setArea(String area) {
       this.area = area;
   }
   public String getUser_name() {
       return this.user_name;
   }
   public void setUser_name(String user_name) {
      this.user_name = user_name;
   }
   public String getUploadPath() {
       return this.uploadPath;
   }
   public void setUploadPath(String uploadPath) {
       this.uploadPath = uploadPath;
   }
   public BufferedImage getUploadImg() {
       return this.uploadImg;
   }
   public void setUploadImg(BufferedImage uploadImg) {
       this.uploadImg = uploadImg;
   }
 
   public String toString() {
       return "Danzheng [uploadDate=" + this.uploadDate + ", title=" + this.title + ", area=" + this.area + ", user_name=" + this.user_name + 
         ", uploadPath=" + this.uploadPath + ", uploadImg=" + this.uploadImg + "]";
   }
 
   public Danzheng(String uploadDate, String title, String area, String user_name, String uploadPath, BufferedImage uploadImg)
   {
       this.uploadDate = uploadDate;
       this.title = title;
       this.area = area;
       this.user_name = user_name;
       this.uploadPath = uploadPath;
       this.uploadImg = uploadImg;
   }
 
   public Danzheng()
   {
   }
 }

