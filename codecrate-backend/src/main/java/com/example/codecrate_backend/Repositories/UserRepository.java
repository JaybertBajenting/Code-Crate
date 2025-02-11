package com.example.codecrate_backend.Repositories;

import com.example.codecrate_backend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;





@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmailOrUsername(String email, String username);
}
