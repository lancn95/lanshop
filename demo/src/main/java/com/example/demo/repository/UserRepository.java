package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{
	
	@Query("SELECT u from AppUser u where u.userName like concat ('%',:name,'%')")
	List<AppUser> searchByNameLike(@Param("name") String name);
	
	@Query("SELECT u from AppUser u WHERE u.email =:email")
	AppUser findUserByName(@Param("email") String email);
	
}
