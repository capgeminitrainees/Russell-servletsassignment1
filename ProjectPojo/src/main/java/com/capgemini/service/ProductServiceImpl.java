package com.capgemini.service;

import com.capgemini.dao.ProductDao;
import com.capgemini.dao.ProductDaoImpl;
import com.capgemini.model.Product;

public class ProductServiceImpl implements ProductService{

	public void startSave(Product product) {
		
		ProductDao productdao = new ProductDaoImpl();
		productdao.saveProduct(product);
		
	}

	public void startDelete(int productId) {
		
		ProductDao productdao = new ProductDaoImpl();
		productdao.deleteProduct(productId);
		
	}
	
	public Product startUpdate(int productId) {
		
		ProductDao productdao = new ProductDaoImpl();
		return productdao.updateProduct(productId);
		
	}

	public void startUpdatingServer(Product product) {
		ProductDao productdao = new ProductDaoImpl();
		productdao.updateServer(product);
		
	}
	
}
