package com.capi.service;

import java.util.regex.Pattern;

import com.capi.beans.Product;
import com.capi.exception.ProductNameIsNumeric;
import com.capi.repo.ProductRepo;
import com.capi.repo.ProductRepoImpl;

public class ProductServiceImpl implements ProductService {
	ProductRepo pr=new ProductRepoImpl();

	@Override
	public Product insertSaleDetails(Product sale) throws ProductNameIsNumeric {
		// TODO Auto-generated method stub
		if (Pattern.compile("[0-9]").matcher(sale.getProdName()).find()) {
			throw new ProductNameIsNumeric();
		}
		return pr.insertSaleDetails(sale);
	}

	@Override
	public boolean validateProductCode(int prodId) {
		// TODO Auto-generated method stub
		if(prodId==1001||prodId==1002||prodId==1003||prodId==1004)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean validateQuantity(int qty) {
		// TODO Auto-generated method stub
		if(qty>0&&qty<5)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean validateProductCat(String prodCat) {
		// TODO Auto-generated method stub
		if(prodCat.equals("Electronics")||prodCat.contentEquals("Toys"))
		{
			return true;
		}
		
		return false;
	}

	@Override
	public boolean validateProductName(String prodName, String prodCat) throws ProductNameIsNumeric {
		// TODO Auto-generated method stub
		if (Pattern.compile("[0-9]").matcher(prodName).find()) {
			throw new ProductNameIsNumeric();
		}
		
		if(prodCat.equals("Electronics")&&((prodName.equals("TV")||prodName.equals
				("Smart Phone")||prodName.equals("Video Game")))||prodCat.equals("Toys")&&(
				(prodName.equals("Soft Toy")||prodName.equals
						("Telescope")||prodName.equals("Barbee Doll")))) {
			return true;
		}
		return false;
	}

	@Override
	public boolean validateProductPrice(float price) {
		// TODO Auto-generated method stub
		if(price>200)
		{
			return true;
		}
		return false;
	}

	

}
