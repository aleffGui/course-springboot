package com.courseapp.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.courseapp.course.entities.User;
import com.courseapp.course.repositories.UserRepository;
import com.courseapp.course.services.exceptions.DataBaseException;
import com.courseapp.course.services.exceptions.ResourceNotFoundException;
@Service
public class UserService {
	@Autowired
	private UserRepository ur;
	
	public List<User> findAll() {
		return ur.findAll();
	}
	public User findById(long id) {
		Optional<User> user = ur.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public User insert(User user) {
		return ur.save(user);
	}
	public void delete(Long id) {
		try {
			ur.deleteById(id);	
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
		
	}
	public User update(Long id, User user) {
		try {
			User entity = ur.getById(id);
			updateData(entity, user);
			return ur.save(entity);	
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
	}
}
