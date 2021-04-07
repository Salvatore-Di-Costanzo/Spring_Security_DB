package io.javabrains.springsecurityjwt.service;

import io.javabrains.springsecurityjwt.model.UserItem;
import io.javabrains.springsecurityjwt.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    private MyUserDetailsService (UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userService.loadUserByUsername(username);

        UserItem userItem =  new UserItem(user.getUsername(),user.getPassword(),true,true,true,true, new ArrayList<GrantedAuthority>());;

        userItem.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER"));
        return userItem;
    }
}