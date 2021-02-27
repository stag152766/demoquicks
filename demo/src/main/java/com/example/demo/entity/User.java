package com.example.demo.entity;

import com.example.demo.entity.enums.ERole;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;


@Data // для автогенерации геттеров и сеттеров
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, updatable = false)
    private String username;
    @Column(nullable = false)
    private String lastname;
    @Column(unique = true)
    private String email;
    @Column(columnDefinition = "text")
    private String bio;
    @Column(length = 3000)
    private String password;

    // зависимость между юзером и ролями 1 ко многих
    // реализуем через доп таблицу связи
    @ElementCollection(targetClass = ERole.class)
    @CollectionTable(name = "user_role",
    joinColumns = @JoinColumn(columnDefinition = "user_id"))
    private Set<ERole> role = new HashSet<>();

    // у 1 юзера много постов
    // каскадный тип - когда удалим юзера,
    // то удаляются все посты
    // не нужно получать все посты, когда хотим получить
    // фио юзера
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
    mappedBy = "user", orphanRemoval = true)
    private List<Post> post = new ArrayList<>();

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    // задает значение атрибуту перед записью в бд
    @PrePersist
    protected void onCreate(){
        this.createdDate = LocalDateTime.now();
    }
}
