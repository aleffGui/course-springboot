package com.courseapp.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courseapp.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
