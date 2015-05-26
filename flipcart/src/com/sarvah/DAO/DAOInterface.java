package com.sarvah.DAO;

import java.sql.ResultSet;

import com.sarvah.DTO.ProductBean;

public interface DAOInterface {
	boolean insertProduct(ProductBean bean);
	ResultSet searchProduct(ProductBean bean);
	boolean deleteProduct(ProductBean bean);
}
