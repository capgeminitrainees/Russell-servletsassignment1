package com.capgemini.dao;


import java.util.List;

import com.capgemini.model.Product;

public interface ProductDao {
	
	public void saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public void deleteProduct(int productId);
	
	public Product updateProduct(int productId);
	
	public void updateServer(Product product);

}
