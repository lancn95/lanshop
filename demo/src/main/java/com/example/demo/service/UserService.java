package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.AppUser;

public interface UserService {
	List<AppUser> findAll();

	AppUser findById(long id);

	void save(AppUser user);

	void update(AppUser user);

	void delete(AppUser user);

	List<AppUser> findByPartOfName(String name);
}
