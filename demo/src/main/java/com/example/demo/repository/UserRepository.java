package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u from User u where u.userName like concat ('%',:name,'%')")
	List<User> searchByNameLike(@Param("name") String name);
	
}
