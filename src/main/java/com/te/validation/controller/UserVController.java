package com.te.validation.controller;

import com.te.validation.dto.UserRegisterDto;
import com.te.validation.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/user")
@AllArgsConstructor
public class UserVController {
    private final UserService userService;
    @PostMapping("/register")
    ResponseEntity<String> register(@RequestBody UserRegisterDto registerDto ){
        String response= userService.register(registerDto);
        return ResponseEntity.accepted().body(response);
    }

}
