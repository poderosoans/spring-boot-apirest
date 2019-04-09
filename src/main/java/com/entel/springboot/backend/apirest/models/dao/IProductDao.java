package com.entel.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.entel.springboot.backend.apirest.models.entity.Product;

public interface IProductDao extends CrudRepository<Product, Long>{

	@Query("SELECT p from Product p WHERE p.name like %?1%")
	public List<Product> findByName(String term);
	
	public List<Product> findByNameContainingIgnoreCase(String term);

	public List<Product> findByNameStartingWithIgnoreCase(String term);
}
