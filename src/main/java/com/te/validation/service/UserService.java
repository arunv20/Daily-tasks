package com.te.validation.service;

import com.te.validation.dto.UserEmailDto;
import com.te.validation.dto.UserRegisterDto;
import com.te.validation.entity.User;
import com.te.validation.repository.UserRepository;
import com.te.validation.validation.AadhaarApi;
import com.te.validation.validation.ObjectsValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ObjectsValidator<UserRegisterDto> validator;//always specify the object
    private final ObjectsValidator<UserEmailDto> emailDtoObjectsValidator;
    private final AadhaarApi aadhaarApi;



    public String register(UserRegisterDto registerDto){
       var validation =validator.validate(registerDto);
       if(!validation.isEmpty()){
           return String.join("/n",validation);
       }
       var validateAadhaar=aadhaarApi.validateAadhaarNumber(registerDto.getAadhaar());
       if(validateAadhaar){
        User user = new User();
        BeanUtils.copyProperties(registerDto,user);
        userRepository.save(user);
        return user.getName()+"is registered";
    }else{
           throw new IllegalArgumentException("Enter Valid Aadhaar Number");
       }
    }


    public String test(UserEmailDto userEmailDto){
        var validation=emailDtoObjectsValidator.validate(userEmailDto);
        return "hello";
    }
}
