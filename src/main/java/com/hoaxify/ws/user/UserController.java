package com.hoaxify.ws.user;

import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.shared.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;


    @CrossOrigin
    @PostMapping("/api/1.0/users")
    public GenericResponse createUser(@Valid @RequestBody MyUsers user) {

/*   //Codes before Jakarta Bean Validation
        String username = user.getUsername();
        String displayName = user.getDisplayName();
        String password = user.getPassword();
        String rePassword = user.getRePassword();


        * if (username == null || username.isEmpty()) {
            validationErrors.put("username", "Username cannot be null");
        }

        if (displayName == null || displayName.isEmpty()) {
            validationErrors.put("displayName", "Display Name cannot be null");
        }

        if (password == null || password.isEmpty()) {
            validationErrors.put("password", "Password cannot be null");
        }
        if (rePassword == null || rePassword.isEmpty()) {
            validationErrors.put("rePassword", "Re-Password cannot be null");
        }

        if (validationErrors.size() > 0) {
            error.setValidationErrors(validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        *
        * */
        logger.info(user.toString());
        userService.save(user);
        return new GenericResponse("User is created.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException exception) {
        ApiError error = new ApiError(400, "Validation Error", "/api/1.0/users");
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        error.setValidationErrors(validationErrors);
        return error;
    }
}
