package com.products.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.apirest.models.ProductModel;
import com.products.apirest.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
//@RequestMapping("/api")
@Api(value="API REST Products")
@CrossOrigin(origins="*")
public class ProductResource {
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/api/products")
	@ApiOperation(value="Return a list of registered products")
	public List<ProductModel> listProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/api/products/{id}")
	@ApiOperation(value="Return a single registered product")
	public ProductModel listOneProduct(@PathVariable(value="id") long id){
		return productRepository.findById(id);
	}
	
	@PostMapping("/api/products")
	@ApiOperation(value="Register a product into database")
	public ProductModel saveProduct(@RequestBody ProductModel product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/api/products")
	@ApiOperation(value="Deletes a product from database")
	public void deleteProduct(@RequestBody ProductModel product) {
		productRepository.delete(product);
	}
	
	@PutMapping("/api/products/update")
	@ApiOperation(value="Update a product from database")
	public ProductModel updateProduct(@RequestBody ProductModel product) {
		return productRepository.save(product);
	}
}
