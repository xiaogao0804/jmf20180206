 package com.jiumenfang.user.bean;
 
 public class Upload
 {
   private int upload_id;
   private String title;
   private String area;
   private String uploadPath;
   private String uploadDate;
   private int user_id;
   private String user_name;
   private String uploadDate1;
   private int path_id;
   private String pathDate;
public int getUpload_id() {
	return upload_id;
}
public void setUpload_id(int upload_id) {
	this.upload_id = upload_id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getUploadPath() {
	return uploadPath;
}
public void setUploadPath(String uploadPath) {
	this.uploadPath = uploadPath;
}
public String getUploadDate() {
	return uploadDate;
}
public void setUploadDate(String uploadDate) {
	this.uploadDate = uploadDate;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getUploadDate1() {
	return uploadDate1;
}
public void setUploadDate1(String uploadDate1) {
	this.uploadDate1 = uploadDate1;
}
public int getPath_id() {
	return path_id;
}
public void setPath_id(int path_id) {
	this.path_id = path_id;
}
public String getPathDate() {
	return pathDate;
}
public void setPathDate(String pathDate) {
	this.pathDate = pathDate;
}
@Override
public String toString() {
	return "Upload [upload_id=" + upload_id + ", title=" + title + ", area=" + area + ", uploadPath=" + uploadPath
			+ ", uploadDate=" + uploadDate + ", user_id=" + user_id + ", user_name=" + user_name + ", uploadDate1="
			+ uploadDate1 + ", path_id=" + path_id + ", pathDate=" + pathDate + "]";
}
public Upload(int upload_id, String title, String area, String uploadPath, String uploadDate, int user_id,
		String user_name, String uploadDate1, int path_id, String pathDate) {
	super();
	this.upload_id = upload_id;
	this.title = title;
	this.area = area;
	this.uploadPath = uploadPath;
	this.uploadDate = uploadDate;
	this.user_id = user_id;
	this.user_name = user_name;
	this.uploadDate1 = uploadDate1;
	this.path_id = path_id;
	this.pathDate = pathDate;
}
public Upload() {
	super();
}
 
 }

