package com.example.demo.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

// Data Transfer Object (урезанная версия целого User для клиента)
// Объект будем передавать и принимать
@Data
public class UserDTO {

    private Long id;
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    @NotEmpty
    private String username;
    private String bio;
}
