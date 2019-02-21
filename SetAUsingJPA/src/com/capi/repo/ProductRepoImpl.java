package com.capi.repo;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import com.capi.beans.Product;
import com.capi.util.EntityManagerLoader;

public class ProductRepoImpl implements ProductRepo {
	//HashMap<Integer,Product> hm=new HashMap<>();
	static EntityManager entityManager= EntityManagerLoader.loader();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	@Override
	public Product insertSaleDetails(Product sale) {
		// TODO Auto-generated method stub
//		hm.put(sale.getSaleId(), sale);
//		return hm;
		entityTransaction.begin();
//		 Product product=new Product();
//		 product.setCategory(sale.getCategory());
//		 product.setLineTotal(sale.getLineTotal());
//		 product.setPrice(sale.getPrice());
//		 product.setProdCode(sale.getProdCode());
//		 product.setProdName(sale.getProdName());
//		 product.setQuantity(sale.getQuantity());
//		 product.setSaleDate(sale.getSaleDate());
//		 product.setSaleId(sale.getSaleId());
		 
		 entityManager.persist(sale);
		entityTransaction.commit();
				return sale;
	}

}
