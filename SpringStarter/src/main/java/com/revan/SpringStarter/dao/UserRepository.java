package com.revan.SpringStarter.dao;

import com.revan.SpringStarter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
