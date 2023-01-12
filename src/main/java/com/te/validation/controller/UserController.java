package com.te.validation.controller;

import com.te.validation.dto.UserRegisterDto;
import com.te.validation.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    ResponseEntity<String> register(@RequestBody @Valid UserRegisterDto registerDto,
                                    BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            return ResponseEntity.badRequest().body(bindingResult.getAllErrors()
//                    .stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining())
//            );
//
//        } // Its a traditional way and its not a good practice to write the validation in Controller
        // Let do some other way to validate an object
       String response= userService.register(registerDto);
       return ResponseEntity.accepted().body(response);
    }


}
