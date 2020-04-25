package com.example.demo.domain;

import java.util.Date;


public class Topic {

   private long id;
   private long userkey;
   private String filename;
   private String name;
   private Date createDate;
   public long getId() {
      return id;
   }
   public void setId(long id) {
      this.id = id;
   }
   public long getUserkey() {
      return userkey;
   }
   public void setUserkey(long userkey) {
      this.userkey = userkey;
   }
   public String getFilename() {
      return filename;
   }
   public void setFilename(String filename) {
      this.filename = filename;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public Date getCreateDate() {
      return createDate;
   }
   public void setCreateDate(Date createDate) {
      this.createDate = createDate;
   }
   @Override
   public String toString() {
      return "Topic [id=" + id + ", userkey=" + userkey + ", filename=" + filename + ", name=" + name
            + ", createDate=" + createDate + "]";
   }
}