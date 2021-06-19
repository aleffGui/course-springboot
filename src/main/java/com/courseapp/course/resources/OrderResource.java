package com.courseapp.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseapp.course.entities.Order;
import com.courseapp.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	@Autowired
	private OrderService os;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> osers = os.findAll();
		return ResponseEntity.ok().body(osers);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable("id") long id) {
		Order user = os.findById(id);
		return ResponseEntity.ok().body(user);	
	}
}
