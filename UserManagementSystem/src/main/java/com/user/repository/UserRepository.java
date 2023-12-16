package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.Users;
import java.util.Optional;


public interface UserRepository extends JpaRepository<Users, Integer> {
	Optional<Users> findByEmail(String email);
}
