package com.obss.movieTracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import com.obss.movieTracker.model.Role;
import com.obss.movieTracker.model.Users;
import com.obss.movieTracker.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (user != null) {
            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
            return buildUserForAuthentication(user, authorities);
        }
        throw new UsernameNotFoundException("Username not found");
    }

    private List<GrantedAuthority> getUserAuthority(List<Role> list) {
        List<GrantedAuthority> roles = new ArrayList<>();
        list.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        });
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(Users user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }
}
