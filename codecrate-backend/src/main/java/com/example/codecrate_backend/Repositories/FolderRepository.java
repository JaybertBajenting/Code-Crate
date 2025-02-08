package com.example.codecrate_backend.Repositories;

import com.example.codecrate_backend.Models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;




@Repository
public interface FolderRepository extends JpaRepository<Folder, UUID> {
}
