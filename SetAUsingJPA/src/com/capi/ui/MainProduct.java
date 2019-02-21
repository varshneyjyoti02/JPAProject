package com.capi.ui;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.capi.beans.Product;
import com.capi.exception.ProductNameIsNumeric;
import com.capi.service.ProductService;
import com.capi.service.ProductServiceImpl;

public class MainProduct {
	 
	public static void main(String[] args) 
	{
		ProductService ps=new ProductServiceImpl();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				 int saleId=(int)( Math.random()*1000);
				 System.out.println("Enter Product Code");
			     int prodCode=sc.nextInt();
			     while(!ps.validateProductCode(prodCode)) {
			    	 System.out.println("Invalid Code");
			    	 prodCode=sc.nextInt();
					}

			     sc.nextLine();
			     System.out.println("Enter Product Category");
				 String category=sc.nextLine();
				 while (!ps.validateProductCat(category)) {
					 System.out.println("Invalid Category");
					 category=sc.nextLine();
					}
				 System.out.println("Enter Product Name");
				 String prodName=sc.nextLine();
				 try {
					while (!ps.validateProductName(prodName, category)) {
						 System.out.println("Invalid Name");
						 prodName=sc.nextLine();
						}
				} catch (ProductNameIsNumeric e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					break;
				}
				 LocalDate saleDate=LocalDate.now();
				 System.out.println("Enter Product Quantity");
				 int quantity=sc.nextInt();
				 
				 while(!ps.validateQuantity(quantity)) {
					 System.out.println("Invalid Quantity");
					 quantity=sc.nextInt();
					}
				 sc.nextLine();
				 System.out.println("Enter Product Price");
				 int price=sc.nextInt();
				 sc.nextLine();
				 while(!ps.validateProductPrice(price)) {
					 System.out.println("Invalid Price");
					 price=sc.nextInt();
					} 
				 float lineTotal=quantity*price;
				 Product product=new Product(saleId,prodCode,prodName,category,saleDate,quantity,lineTotal,price);
				 try {
					ps.insertSaleDetails(product);
				} catch (ProductNameIsNumeric e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
//				 HashMap<Integer,Product> hm=ps.insertSaleDetails(product);
//				 Iterator it=hm.keySet().iterator();
//				 while(it.hasNext())
//				 {
//					 System.out.println("Sales id:");
//					 int id=(int) it.next();
//					 System.out.println(id);
//					 System.out.println(hm.get(id));
//					 
//				 }
				 
				break;
			case 2:
				break;
				default:System.out.println("You have entered an Invalid choice");
			}
			
		}
	}

}
