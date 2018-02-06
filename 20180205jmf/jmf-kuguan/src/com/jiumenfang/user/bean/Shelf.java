 package com.jiumenfang.user.bean;
 
 public class Shelf
 {
   private int shelf_id;
   private String shelf_type;
   private int s_id;
public int getShelf_id() {
	return shelf_id;
}
public void setShelf_id(int shelf_id) {
	this.shelf_id = shelf_id;
}
public String getShelf_type() {
	return shelf_type;
}
public void setShelf_type(String shelf_type) {
	this.shelf_type = shelf_type;
}
public int getS_id() {
	return s_id;
}
public void setS_id(int s_id) {
	this.s_id = s_id;
}
@Override
public String toString() {
	return "Shelf [shelf_id=" + shelf_id + ", shelf_type=" + shelf_type + ", s_id=" + s_id + "]";
}
public Shelf(int shelf_id, String shelf_type, int s_id) {
	super();
	this.shelf_id = shelf_id;
	this.shelf_type = shelf_type;
	this.s_id = s_id;
}
public Shelf() {
	super();
}
 

 }

