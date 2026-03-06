package com.example.production_ready_features.repository;

import com.example.production_ready_features.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
