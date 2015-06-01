package com.sarvah.dto;

import org.apache.log4j.Logger;



public class CartItemBean {
	static Logger log = Logger.getLogger(CartItemBean.class);
	 private String strPartNumber;
	    private String strModelDescription;
	    private double dblUnitCost;
	    private int iQuantity;
	    private double dblTotalCost;
	     
	    public String getPartNumber() {
	        return strPartNumber;
	    }
	    public void setPartNumber(String strPartNumber) {
	        this.strPartNumber = strPartNumber;
	    }
	    public String getModelDescription() {
	        return strModelDescription;
	    }
	    public void setModelDescription(String strModelDescription) {
	        this.strModelDescription = strModelDescription;
	    }
	    public double getUnitCost() {
	        return dblUnitCost;
	    }
	    public void setUnitCost(double dblUnitCost) {
	        this.dblUnitCost = dblUnitCost;
	    }
	    public int getQuantity() {
	        return iQuantity;
	    }
	    public void setQuantity(int quantity) {
	        iQuantity = quantity;
	    }
	    public double getTotalCost() {
	        return dblTotalCost;
	    }
	    public void setTotalCost(double dblTotalCost) {
	        this.dblTotalCost = dblTotalCost;
	    }
}
