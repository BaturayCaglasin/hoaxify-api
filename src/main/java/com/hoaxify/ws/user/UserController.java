package com.hoaxify.ws.user;

import com.hoaxify.ws.shared.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;


//Bu HTTP request'i ile erişilecek. Rest'e bir entity eklenecekse POST metodu kullanılır. Bu metodun POST metotlarını çalıştıracağını göstermek adına POSTMAPPING isminde bir annotion ile; bu metodun POST edeceğini söylüyoruz.

    @CrossOrigin
    @PostMapping("/api/1.0/users")
    //@RequestBody annotion'ı ile; formdan gelen data bu metoda hizmet edecektir. Gelen request içindeki Body'i bize ver.
    public GenericResponse createUser(@RequestBody MyUsers user) {
        userService.save(user);
        logger.info(user.toString()); //gelen body ekrana yansıtılır.

        GenericResponse response = new GenericResponse();
        response.setMessage("User Created.");
        return response;
    }
}
