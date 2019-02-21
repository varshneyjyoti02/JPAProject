package com.capi.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@Column(name="SaleId",length=20)
	private int saleId;
	@Column(name="ProductCode",length=20)
	private int prodCode;
	@Column(name="ProductName",length=20)
	private String prodName;
	@Column(name="Category",length=20)
	private String category;
	@Column(name="SaleDate")
	private LocalDate saleDate;
	@Column(name="Quantity",length=20)
	private int quantity;
	@Column(name="LineTotal",length=20)
	private float lineTotal;
	@Column(name="Price",length=20)
	private int price;
	@Override
	public String toString() {
		return "Product [saleId=" + saleId + ", prodCode=" + prodCode + ", prodName=" + prodName + ", category="
				+ category + ", saleDate=" + saleDate + ", quantity=" + quantity + ", lineTotal=" + lineTotal
				+ ", price=" + price + "]";
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int saleId, int prodCode, String prodName, String category, LocalDate saleDate, int quantity,
			float lineTotal, int price) {
		super();
		this.saleId = saleId;
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.category = category;
		this.saleDate = saleDate;
		this.quantity = quantity;
		this.lineTotal = lineTotal;
		this.price = price;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public int getProdCode() {
		return prodCode;
	}
	public void setProdCode(int prodCode) {
		this.prodCode = prodCode;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(float lineTotal) {
		this.lineTotal = lineTotal;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
