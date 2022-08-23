package com.hoaxify.ws.user;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name="MYUSERS")
public class MyUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String display_name;
    private String password;
    private String re_password;


}
