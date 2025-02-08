package com.example.codecrate_backend.Models;


import com.example.codecrate_backend.Enums.Permission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_access_control")
public class AccessControl {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "access_control_id")
    private UUID id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "code_snippet_id")
    private CodeSnippet codeSnippet;

    private Permission permission;

    private LocalDateTime createdAt;

}
