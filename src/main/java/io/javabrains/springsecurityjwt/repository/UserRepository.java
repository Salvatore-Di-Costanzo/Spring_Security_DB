package io.javabrains.springsecurityjwt.repository;

import io.javabrains.springsecurityjwt.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {

    Users findByUsername(String username);
}
