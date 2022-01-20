package com.product.ProductAssignment;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bean.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

@Path("/products")
public class ProductResource {

	private ProductService productService=new ProductServiceImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProductResource(){
		try {
			return productService.listAllProducts();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Path("/code/{pcode}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductCodeResource(@PathParam("pcode") String productCode) {
		try {
			return productService.getProductByCode(productCode);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}


