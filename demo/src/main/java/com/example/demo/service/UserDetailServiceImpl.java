package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AppUser;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// find user by username
		AppUser appUser = userRepository.findUserByName(email);
		if (appUser == null) {
			System.out.println("User not found " + email);
			throw new UsernameNotFoundException("User" + email + " was not found in the database");

		}
		System.out.println("Found User: " + appUser);

		// [ROLE_USER, ROLE_ADMIN,..]
		List<String> RolesUser = roleRepository.getRoleName(appUser.getUserId());
		System.out.println("rolesName: " + RolesUser);

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		for (String role : RolesUser) {
			// ROLE_USER, ROLE_ADMIN
			GrantedAuthority authority = new SimpleGrantedAuthority(role);
			grantList.add(authority);
		}
		boolean enabled = appUser.isEnabled();
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), appUser.getEncrytedPassword(), enabled,
				accountNonExpired, //
				credentialsNonExpired, accountNonLocked, grantList);
		
		return userDetails;
	}

}
