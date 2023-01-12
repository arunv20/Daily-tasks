package com.te.validation.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserEmailDto {
    @NotNull
    private String email;
}
