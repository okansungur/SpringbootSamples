package com.example.tmp.monopro.repo;


import com.example.tmp.monopro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

}
