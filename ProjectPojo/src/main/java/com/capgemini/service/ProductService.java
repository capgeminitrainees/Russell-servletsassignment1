package com.capgemini.service;

import com.capgemini.model.Product;

public interface ProductService {
	
	public void startSave(Product product);
	
	public void startDelete(int productId);
	
	public Product startUpdate(int productId);
	
	public void startUpdatingServer(Product product);

}
