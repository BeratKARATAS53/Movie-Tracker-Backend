package com.obss.movieTracker.service.impl;

import com.obss.movieTracker.config.JwtAuthenticationProvider;
import com.obss.movieTracker.model.Users;
import com.obss.movieTracker.model.request.LoginRequestBody;
import com.obss.movieTracker.repository.UserRepository;
import com.obss.movieTracker.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtAuthenticationProvider authenticationProvider;

    @Override
    public String login(LoginRequestBody loginRequestBody) {
        Users user = userRepository.findByUsername(loginRequestBody.getUsername());
        if (user != null) {
            if (!bCryptPasswordEncoder.matches(loginRequestBody.getPassword(), user.getPassword())) {
                throw new Error("Parola Hatalı!");
            } else {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequestBody.getUsername(), loginRequestBody.getPassword()));
                String token = authenticationProvider.createToken(loginRequestBody.getUsername(), user.getRole());
                return token;
            }
        }
        throw new Error("Böyle Bir Kullanıcı Sisteme Kayıtlı Değil. Ya da Kullanıcı Adı Hatalı!");
    }
}
