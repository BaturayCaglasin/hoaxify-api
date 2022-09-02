package com.hoaxify.ws.user;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "MYUSERS")
public class MyUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "{hoaxify.constraint.username.NotNull.message}")
    @Size(min=4, max = 255)
    @UniqueUsername
    private String username;
    @NotNull(message = "{hoaxify.constraint.displayname.NotNull.message}")
    @Column(unique = true)
    private String displayName;
    @NotNull(message = "{hoaxify.constraint.password.NotNull.message}")
    @Size(min=4, max = 255)
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;
    @NotNull
    @Size(min=4, max = 255)
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String rePassword;


}
