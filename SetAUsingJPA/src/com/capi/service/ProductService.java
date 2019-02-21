package com.capi.service;

import java.util.HashMap;

import com.capi.beans.Product;
import com.capi.exception.ProductNameIsNumeric;

public interface ProductService {

	
	public Product insertSaleDetails(Product sale) throws ProductNameIsNumeric ;
	public boolean validateProductCode(int prodId);
	boolean validateQuantity(int qty);
	public boolean validateProductCat(String prodCat);
	public boolean validateProductName(String prodName,String prodCat) throws ProductNameIsNumeric ;
	public boolean validateProductPrice(float price);

}
