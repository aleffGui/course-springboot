package com.courseapp.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courseapp.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
