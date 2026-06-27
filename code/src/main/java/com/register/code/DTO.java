package com.register.code;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class DTO {
    @NotBlank(message = "Field cannot be empty")
    @Size(min = 5, max = 16, message = "Username must contain between 5 and 16 characters")
    private String username;

    @NotBlank(message = "Field cannot be empty")
    @Size(min = 5, max = 12, message = "Passwords must contain between 5 and 12 characters")
    private String password;

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
