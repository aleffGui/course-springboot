package com.courseapp.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.course.entities.Order;
import com.courseapp.course.repositories.OrderRepository;
@Service
public class OrderService {
	@Autowired
	private OrderRepository or;
	
	public List<Order> findAll() {
		return or.findAll();
	}
	public Order findById(long id) {
		Optional<Order> Order = or.findById(id);
		return Order.get();
	}
}
