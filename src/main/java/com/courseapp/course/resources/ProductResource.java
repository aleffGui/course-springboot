package com.courseapp.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseapp.course.entities.Product;
import com.courseapp.course.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	ProductService ps;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> product = ps.findAll();
		return ResponseEntity.ok().body(product);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product product = ps.findById(id);
		return ResponseEntity.ok().body(product);
	}
}
