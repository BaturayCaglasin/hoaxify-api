package com.hoaxify.ws.user;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    @Autowired
    UsersRepository usersRepository;


    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        MyUsers user = usersRepository.findByUsername(username);
        if (user != null) {
            return false;
        }
        return true;
    }
}
