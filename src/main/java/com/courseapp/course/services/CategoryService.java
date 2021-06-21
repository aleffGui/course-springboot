package com.courseapp.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.course.entities.Category;
import com.courseapp.course.repositories.CategoryRepository;
@Service
public class CategoryService {
	@Autowired
	CategoryRepository cr;
	
	public List<Category> findAll() {
		return cr.findAll();
	}
	public Category findById(Long id) {
		Optional<Category> category = cr.findById(id);
		return category.get();
	}
	
}
