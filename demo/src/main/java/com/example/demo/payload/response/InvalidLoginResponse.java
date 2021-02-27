package com.example.demo.payload.response;


import lombok.Getter;


// возвращаем объект если пользователь не авторизован
@Getter
public class InvalidLoginResponse {

    private String username;
    private String password;

    public InvalidLoginResponse(){
        this.username = "Invalid Username";
        this.password = "Invalid Password";
    }
}
