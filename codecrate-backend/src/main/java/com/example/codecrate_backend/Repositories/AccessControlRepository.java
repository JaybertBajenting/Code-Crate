package com.example.codecrate_backend.Repositories;

import com.example.codecrate_backend.Models.AccessControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;




@Repository
public interface AccessControlRepository extends JpaRepository<AccessControl, UUID> {
}
