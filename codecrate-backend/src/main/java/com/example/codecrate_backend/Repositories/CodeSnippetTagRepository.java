package com.example.codecrate_backend.Repositories;

import com.example.codecrate_backend.Models.CodeSnippetTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface CodeSnippetTagRepository extends JpaRepository<CodeSnippetTag, UUID> {
//    CodeSnippetTag findByCodeSnippetIdAndTagId(UUID codeSnippetId, UUID tagId);
//    List<CodeSnippetTag> findByCodeSnippetId(UUID codeSnippetId);
//    List<CodeSnippetTag> findByTagId(UUID tagId);
//    void deleteByCodeSnippetIdAndTagId(UUID codeSnippetId, UUID tagId);
//    void deleteByCodeSnippetId(UUID codeSnippetId);
//    void deleteByTagId(UUID tagId);
}
