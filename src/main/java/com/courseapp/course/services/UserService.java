package com.courseapp.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.course.entities.User;
import com.courseapp.course.repositories.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository ur;
	
	public List<User> findAll() {
		return ur.findAll();
	}
	public User findById(long id) {
		Optional<User> user = ur.findById(id);
		return user.get();
	}
	public User insert(User user) {
		return ur.save(user);
	}
	public void delete(Long id) {
		ur.deleteById(id);
	}
	public User update(Long id, User user) {
		User entity = ur.getOne(id);
		updateData(entity, user);
		return ur.save(entity);
	}
	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
	}
}
