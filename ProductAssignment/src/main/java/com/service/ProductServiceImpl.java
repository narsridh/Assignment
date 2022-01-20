package com.service;

import java.sql.SQLException;


import java.util.List;

import com.bean.Product;
import com.persistence.ProductDao;
import com.persistence.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao=new ProductDaoImpl(); 
	@Override
	public List<Product> listAllProducts() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return productDao.listAllProducts();
	}

	@Override
	public Product getProductByCode(String productCode) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return productDao.getProductByCode(productCode) ;
	}

}
