package com.te.validation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRegisterDto {
    //We need to validate object erro
    //Spring boot starter validation dependency is used to validate an object
    @NotNull(message = "Name should not be empty")
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotNull(message = "email should not be empty")
    @NotEmpty(message = "email should not be empty")
    @Email(message = "Enter Valid email")
    private String email;

    @NotNull(message = "Enter a valid aadhaar")
    private Integer aadhaar;
    @NotNull(message = "panNumber should not be empty")
    @NotEmpty(message = "panNumber should not be empty")
    private String panNumber;
    @NotNull(message = "city should not be empty")
    @NotEmpty(message = "city should not be empty")
    private String city;
}
