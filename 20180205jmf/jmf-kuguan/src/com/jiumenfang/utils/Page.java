/*     */ package com.jiumenfang.utils;
/*     */ 
/*     */ import java.util.List;
/*     */ 
/*     */ public final class Page<T>
/*     */ {
/*     */   public static final int DEFAULT_PAGE_SIZE = 3;
/*     */   private int count;
/*     */   private int pageSize;
/*     */   private int pageCount;
/*     */   private int currentPage;
/*     */   private int previousPage;
/*     */   private int nextPage;
/*     */   private int startRecord;
/*     */   private int endRecord;
/*     */   private List<T> list;
/*     */ 
/*     */   public Page(String current, int count, String pageSize)
/*     */   {
/*  72 */     this.count = count;
/*  73 */     init(current, pageSize);
/*     */   }
/*     */ 
/*     */   private void init(String current, String size) {
/*  77 */     initPageSize(size);
/*  78 */     initPageCount();
/*  79 */     initCurrentPage(current);
/*  80 */     initPreviousPage();
/*  81 */     initNextPage();
/*  82 */     initStartRecord();
/*  83 */     initEndRecord();
/*     */   }
/*     */ 
/*     */   private void initPageSize(String size) {
/*  87 */     if ((size == null) || (size.trim().isEmpty())) {
/*  88 */       this.pageSize = 3;
/*  89 */       return;
/*     */     }
/*     */     try {
/*  92 */       this.pageSize = Integer.parseInt(size);
/*     */     } catch (Exception e) {
/*  94 */       this.pageSize = 3;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initEndRecord() {
/*  99 */     this.endRecord = (this.startRecord + this.pageSize - 1);
/* 100 */     if (this.endRecord > this.count)
/* 101 */       this.endRecord = this.count;
/*     */   }
/*     */ 
/*     */   private void initStartRecord()
/*     */   {
/* 106 */     this.startRecord = ((this.currentPage - 1) * this.pageSize);
/* 107 */     if (this.startRecord < 0) {
/* 108 */       this.startRecord = 0;
/*     */     }
/* 110 */     if (this.startRecord > this.count)
/* 111 */       this.startRecord = this.count;
/*     */   }
/*     */ 
/*     */   private void initNextPage()
/*     */   {
/* 116 */     this.nextPage = (this.currentPage + 1);
/* 117 */     if (this.nextPage > this.pageCount)
/* 118 */       this.nextPage = this.pageCount;
/*     */   }
/*     */ 
/*     */   private void initPreviousPage()
/*     */   {
/* 123 */     this.previousPage = (this.currentPage - 1);
/* 124 */     if (this.previousPage < 1)
/* 125 */       this.previousPage = 1;
/*     */   }
/*     */ 
/*     */   private void initCurrentPage(String current)
/*     */   {
/* 130 */     if ((current == null) || (current.trim().isEmpty())) {
/* 131 */       this.currentPage = 1;
/* 132 */       return;
/*     */     }
/*     */     try {
/* 135 */       this.currentPage = Integer.parseInt(current);
/*     */     } catch (Exception e) {
/* 137 */       this.currentPage = 1;
/*     */     }
/* 139 */     if (this.currentPage < 1) {
/* 140 */       this.currentPage = 1;
/* 141 */       return;
/*     */     }
/* 143 */     if (this.currentPage > this.pageCount)
/* 144 */       this.currentPage = this.pageCount;
/*     */   }
/*     */ 
/*     */   private void initPageCount()
/*     */   {
/* 149 */     this.pageCount = (this.count / this.pageSize);
/* 150 */     if (this.count % this.pageSize != 0)
/* 151 */       this.pageCount += 1;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/* 156 */     return this.count;
/*     */   }
/*     */ 
/*     */   public int getPageSize() {
/* 160 */     return this.pageSize;
/*     */   }
/*     */ 
/*     */   public int getPageCount() {
/* 164 */     return this.pageCount;
/*     */   }
/*     */ 
/*     */   public int getCurrentPage() {
/* 168 */     return this.currentPage;
/*     */   }
/*     */ 
/*     */   public int getPreviousPage() {
/* 172 */     return this.previousPage;
/*     */   }
/*     */ 
/*     */   public int getNextPage() {
/* 176 */     return this.nextPage;
/*     */   }
/*     */ 
/*     */   public int getStartRecord() {
/* 180 */     return this.startRecord;
/*     */   }
/*     */ 
/*     */   public int getEndRecord() {
/* 184 */     return this.endRecord;
/*     */   }
/*     */ 
/*     */   public List<T> getList() {
/* 188 */     return this.list;
/*     */   }
/*     */ 
/*     */   public void setList(List<T> list) {
/* 192 */     this.list = list;
/*     */   }
/*     */ }

/* Location:           C:\Users\九门坊\Desktop\jmf\新建文件夹\WEB-INF\classes\
 * Qualified Name:     com.jiumenfang.utils.Page
 * JD-Core Version:    0.6.2
 */