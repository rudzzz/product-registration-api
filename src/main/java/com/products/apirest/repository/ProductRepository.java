package com.products.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.apirest.models.ProductModel;


public interface ProductRepository extends JpaRepository<ProductModel, Long>{
	ProductModel findById(long id);
}
