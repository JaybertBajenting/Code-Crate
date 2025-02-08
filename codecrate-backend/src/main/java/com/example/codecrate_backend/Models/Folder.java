package com.example.codecrate_backend.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_folder")
public class Folder {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "folder_id")
    private UUID id;


    @Column(name = "folder_name")
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;




    @OneToMany(mappedBy = "folder",cascade = CascadeType.ALL)
    private List<FolderSnippet> folderSnippetList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
