package com.example.codecrate_backend.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_folder_snippet")
public class FolderSnippet {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "folder_snippet_id")
    private UUID id;


    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    @ManyToOne
    @JoinColumn(name = "code_snippet_id")
    private CodeSnippet codeSnippet;


}
