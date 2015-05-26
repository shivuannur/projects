package com.sarvah.DTO;
public class ProductBean {
	int pid;
	int scid;
	String catalogno;
	String pname;
	double price;
	String modifieddate;
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
	public String getCatalogno() {
		return catalogno;
	}
	public void setCatalogno(String catalogno) {
		this.catalogno = catalogno;
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
