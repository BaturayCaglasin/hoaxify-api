package com.hoaxify.ws.user;

import org.springframework.data.jpa.repository.JpaRepository;
//DB'ye erişim için bir takım metotları bulunduran standart bir interface.
public interface UsersRepository extends JpaRepository <MyUsers,Long> {

    MyUsers findByUsername(String usernamme); //Arka planda; Spring buna karşılık gelen query'i oluşturuyor olacak.


}
