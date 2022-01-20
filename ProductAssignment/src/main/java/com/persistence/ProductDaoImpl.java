package com.persistence;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.bean.Product;
import com.helper.*;

//import helper.OracleConnection;
public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> listAllProducts() throws ClassNotFoundException, SQLException {
		 List<Product> productList = new ArrayList<Product>();
			Connection connection = OracleConnection.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTS");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				long id = resultSet.getLong("ID");
				String code = resultSet.getString("CODE");
				String name = resultSet.getString("NAME");
				String description = resultSet.getString("DESCRIPTION");
				double price = resultSet.getDouble("PRICE");
				
				Product product=new Product(id, code, name, description, price);
				productList.add(product);
			}

			connection.close();

			return productList;
	}

	@Override
	public Product getProductByCode(String productCode) throws ClassNotFoundException, SQLException {
		
Product product=null;
		
		Connection connection = OracleConnection.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTS WHERE CODE=?");
		preparedStatement.setString(1, productCode);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
			long id = resultSet.getLong("ID");
			String code = resultSet.getString("CODE");
			String name = resultSet.getString("NAME");
			String description = resultSet.getString("DESCRIPTION");
			double price = resultSet.getDouble("PRICE");
			
			 product=new Product(id, code, name, description, price);
		
		}

		connection.close();
		return product;
	}
	


	}


