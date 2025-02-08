package com.example.codecrate_backend.Models;


import com.example.codecrate_backend.Enums.ProgrammingLanguage;
import com.example.codecrate_backend.Enums.Visibility;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_code_snippet")
public class CodeSnippet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "code_snippet_id")
    private UUID id;

    private String title;

    private String description;

    private ProgrammingLanguage programmingLanguage;

    private String code;

    private Visibility visibility;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;




    @OneToMany(mappedBy = "codeSnippet",cascade = CascadeType.ALL)
    private List<CodeSnippetTag> codeSnippetTagList;


    @OneToMany(mappedBy = "codeSnippet",cascade = CascadeType.ALL)
    private List<Like> likes;


    @OneToMany(mappedBy = "codeSnippet",cascade = CascadeType.ALL)
    private List<Comment> comments;




    @OneToMany(mappedBy = "codeSnippet",cascade = CascadeType.ALL)
    private List<FolderSnippet> folderSnippetList;


    @OneToMany(mappedBy = "codeSnippet",cascade = CascadeType.ALL)
    private List<AccessControl> accessControlList;
}
