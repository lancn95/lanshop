package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {
	List<User> findAll();

	User findById(long id);

	void save(User user);

	void update(User user);

	void delete(User user);

	List<User> findByPartOfName(String name);
}
