package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	@Query("SELECT ur.role.roleName from UserRole ur where ur.user.userId =:userId")
	List<String> getRoleName (@Param("userId") long userId);
}
