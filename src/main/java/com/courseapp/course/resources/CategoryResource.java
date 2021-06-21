package com.courseapp.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseapp.course.entities.Category;
import com.courseapp.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	@Autowired
	CategoryService cs;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> categories = cs.findAll();
		return ResponseEntity.ok().body(categories);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category category = cs.findById(id);
		return ResponseEntity.ok().body(category);
	}
	
}
