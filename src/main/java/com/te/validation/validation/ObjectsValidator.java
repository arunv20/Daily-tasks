package com.te.validation.validation;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;


import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectsValidator<T> {
    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    //building default validator design pattern factory refer design pattern playlist
    private final Validator validator=validatorFactory.getValidator();// we are calling validator from the  factory
    
//    public Set<String> validate(UserRegisterDto objectToValidate){
//        Set<ConstraintViolation<UserRegisterDto>> validation = validator.validate(objectToValidate);
//        if(!validation.isEmpty()){
//           return validation.stream().map(ConstraintViolation::getMessage)
//                    .collect(Collectors.toSet());
//        }
//        return Collections.emptySet();
//    }
    // in above method validate method take only userRegisterDto type of object
    // we want to validate in all type-generic solution - OOP
    public Set<String> validate(T objectToValidate){
        Set<ConstraintViolation<T>> validation = validator.validate(objectToValidate);
        if(!validation.isEmpty()){
            return validation.stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }



}
