package com.example.codecrate_backend.Models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_tag")
public class Tag {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tag_id")
    private UUID id;


    @Column(name = "tag_name")
    private String name;

    private LocalDateTime createdAt;


    @OneToMany(mappedBy = "tag",cascade = CascadeType.ALL)
    private List<CodeSnippetTag> codeSnippetTagList;

}
