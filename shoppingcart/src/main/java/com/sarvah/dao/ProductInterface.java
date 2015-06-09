package com.sarvah.dao;

import java.sql.ResultSet;

import com.sarvah.dto.ProductBean;

public interface ProductInterface {
	boolean insertProduct(ProductBean bean);
	ResultSet searchProduct(ProductBean bean);
	boolean deleteProduct(ProductBean bean);
}
