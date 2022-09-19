package com.hoaxify.ws.configuration;

import com.hoaxify.ws.user.MyUsers;
import com.hoaxify.ws.user.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUsers inDB= usersRepository.findByUsername(username);
        if(inDB==null){
            throw new UsernameNotFoundException("User is not found.");
        }

        return new HoaxifyUserDetails(inDB);
    }
}
