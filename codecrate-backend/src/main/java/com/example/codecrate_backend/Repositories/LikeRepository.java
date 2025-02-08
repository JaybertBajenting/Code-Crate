package com.example.codecrate_backend.Repositories;

import com.example.codecrate_backend.Models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;





@Repository
public interface LikeRepository extends JpaRepository<Like, UUID> {
}
