package com.daonguyen.dao;

import com.daonguyen.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	
	private List<Product> products = null;
	
	public ProductDao() {
		products = new ArrayList<Product>();
		products.add(new Product("pro01", "Nokia 1280", 1000,  300000, "dienthoai"));
		products.add(new Product("pro02", "Samsung Galaxy", 1000, 7000000, "dienthoai"));
	}

	public List<Product> findAllOfProducts() {
		return products;
	}

	public Product findProductByCode(String id) {
		for (Product product : products) {
			if(product.getCode().equals(id)) {
				return product;
			}
		}
		return null;
	}
	
	public void add(Product product) {
		products.add(product);
	}
	
	public void edit(Product product) {
		Product entity = findProductByCode(product.getCode());
		if(entity != null) {
			entity.setName(product.getName());
			entity.setPrice(product.getPrice());
			entity.setAmount(product.getAmount());
			entity.setCateCode(product.getCateCode());
		}
	}
	
	public void remove(String code) {
		Product entity = findProductByCode(code);
		if(entity != null) {
			products.remove(entity);
		}
	}
}
