package com.sathya.servlet;

import java.util.Arrays;
import java.sql.Date;


public class Product {
  String proid;
  String proname;
  double proPrice;
  String proBrand;
  String proMadein;
  Date proMfgDate;
  Date proExpDate;
  byte[] imageWork;
  byte[] proAudio;
  byte[] proVideo;
 
  
  
  public byte[] getProAudio() {
	  return proAudio;
  }

  public void setProAudio(byte[] proAudio) {
	  this.proAudio = proAudio;
  }

  public byte[] getProVideo() {
	  return proVideo;
  }

  public void setProVideo(byte[] proVideo) {
	  this.proVideo = proVideo;
  }

  public Product() {
	  super();
	// TODO Auto-generated constructor stub
  }

  
  public Product(String proid, String proname, double proPrice, String proBrand, String proMadein, Date proMfgDate,
		  Date proExpDate, byte[] imageWork) {
	super();
	this.proid = proid;
	this.proname = proname;
	this.proPrice = proPrice;
	this.proBrand = proBrand;
	this.proMadein = proMadein;
	this.proMfgDate = proMfgDate;
	this.proExpDate = proExpDate;
	this.imageWork = imageWork;
  }
  @Override
  public String toString() {
	  return "product [proid=" + proid + ", proname=" + proname + ", proPrice=" + proPrice + ", proBrand=" + proBrand
			+ ", proMadein=" + proMadein + ", proMfgDate=" + proMfgDate + ", proExpDate=" + proExpDate + ", imageWork="
			+ Arrays.toString(imageWork) + "]";
  }

  public String getProid() {
	  return proid;
  }
  public void setProid(String proid) {
	  this.proid = proid;
  }
  public String getProname() {
	  return proname;
  }
  public void setProname(String proname) {
	  this.proname = proname;
  }
  public double getProPrice() {
	  return proPrice;
  }
  public void setProPrice(double proPrice) {
	  this.proPrice = proPrice;
  }
  public String getProBrand() {
	  return proBrand;
  }
  public void setProBrand(String proBrand) {
	  this.proBrand = proBrand;
  }
  public String getProMadein() {
	  return proMadein;
  }
  public void setProMadein(String proMadein) {
	  this.proMadein = proMadein;
  }
  public Date getProMfgDate() {
	  return proMfgDate;
  }
  public void setProMfgDate(Date proMfgDate) {
	  this.proMfgDate = proMfgDate;
  }
  public Date getProExpDate() {
	  return proExpDate;
  }
  public void setProExpDate(Date proExpDate) {
	  this.proExpDate = proExpDate;
  }
  public byte[] getImageWork() {
	  return imageWork;
  }
  public void setImageWork(byte[] imageWork) {
	  this.imageWork = imageWork;
  }
  
    
}