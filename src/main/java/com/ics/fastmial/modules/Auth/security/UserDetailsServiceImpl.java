package com.ics.fastmial.modules.Auth.security;

import com.ics.fastmial.entity.Auth;
import com.ics.fastmial.modules.Auth.Dto.AppUserRole;
import com.ics.fastmial.repositories.AuthRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Autowired
    AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Auth> authList = authRepository.findByUsername(username);
        if(authList == null || authList.size()==0){
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }

        Auth auth = authList.get(0);
        List<AppUserRole> roles = new ArrayList<>();
        roles.add(AppUserRole.ROLE_CLIENT);
        UserDetails userDetails = new User(username,auth.getPassword(),roles);
        return userDetails;
    }
}
