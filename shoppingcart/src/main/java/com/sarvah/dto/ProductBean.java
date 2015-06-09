package com.sarvah.dto;

import org.apache.log4j.Logger;



public class ProductBean {
	static Logger log = Logger.getLogger(ProductBean.class);
	int pid;
	int scid;
	String pname;
	double price;
	String modifieddate;
	
	public ProductBean(int pid,int scid,String pname,double price,String modifieddate)
	{
		this.pid=pid;
		this.scid=scid;
		this.pname=pname;
		this.price=price;
		this.modifieddate=modifieddate;
	}
	public ProductBean(String pname)
	{
		this.pname=pname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	} 
}
