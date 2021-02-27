package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private Long userId;
    // пустой коммент не записывается в бд
    @Column(columnDefinition = "text", nullable = false)
    private String message;
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @PrePersist
    public void onCreate(){
        this.createdDate = LocalDateTime.now();
    }

}
