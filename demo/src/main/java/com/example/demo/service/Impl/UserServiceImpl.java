package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public User findById(long id) {
		User user = userRepository.findById(id).orElse(null);
		return user;
	}

	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public void update(User user) {
		userRepository.save(user);

	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);

	}

	@Override
	public List<User> findByPartOfName(String name) {
		List<User> users = userRepository.searchByNameLike(name);
		return users;
	}

}
