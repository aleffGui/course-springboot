package com.courseapp.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courseapp.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>  {

}
