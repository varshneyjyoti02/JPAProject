package com.capi.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.capi.beans.Product;
import com.capi.exception.ProductNameIsNumeric;
import com.capi.service.ProductService;
import com.capi.service.ProductServiceImpl;

public class TestMain {
	ProductService ss = new ProductServiceImpl();
	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = com.capi.exception.ProductNameIsNumeric.class)
	public void test() throws ProductNameIsNumeric {
		ss.insertSaleDetails(new Product(1001, 1001, "123", "Electronics", LocalDate.now(), 2, 5000, 1200));
		
	}

	@Test
	public void test1() throws ProductNameIsNumeric {
		ss.insertSaleDetails(new Product(1001, 1001,  "TV","Electronics", LocalDate.now(), 3, 900, 300));
		
	}


}
