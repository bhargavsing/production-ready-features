package com.example.production_ready_features.repository;



import com.example.production_ready_features.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   Optional<User> findByEmail(String email);
}
