package com.example.codecrate_backend.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_code_snippet_tag")
public class CodeSnippetTag {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "code_snippet_tag_id")
    private UUID id;


    @ManyToOne
    @JoinColumn(name = "code_snippet_id")
    private CodeSnippet codeSnippet;


    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;



}
