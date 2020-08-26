package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AppUser;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<AppUser> findAll() {
		List<AppUser> users = userRepository.findAll();
		return users;
	}

	@Override
	public AppUser findById(long id) {
		AppUser user = userRepository.findById(id).orElse(null);
		return user;
	}

	@Override
	public void save(AppUser user) {
		userRepository.save(user);

	}

	@Override
	public void update(AppUser user) {
		userRepository.save(user);

	}

	@Override
	public void delete(AppUser user) {
		userRepository.delete(user);

	}

	@Override
	public List<AppUser> findByPartOfName(String name) {
		List<AppUser> users = userRepository.searchByNameLike(name);
		return users;
	}

}
