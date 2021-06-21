package com.courseapp.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.course.entities.Product;
import com.courseapp.course.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository pr;
	
	public List<Product> findAll() {
		List<Product> products = pr.findAll();
		return products;
	}
	public Product findById(Long id) {
		Optional<Product> product = pr.findById(id);
		return product.get();
	}
}
