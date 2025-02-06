package com.example.codecrate_backend.Repositories;

import com.example.codecrate_backend.Models.CodeSnippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CodeSnippetRepository extends JpaRepository<CodeSnippet, UUID> {
    CodeSnippet findByTitle(String title);
    CodeSnippet findByCode(String code);
    CodeSnippet findByTitleOrCode(String title, String code);
}
