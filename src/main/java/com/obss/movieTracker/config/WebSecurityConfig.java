package com.obss.movieTracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.obss.movieTracker.service.impl.UserDetailsServiceImpl;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationProvider authenticationProvider;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Disable CSRF (cross site request forgery)
        http.csrf().disable();

        // No session will be created or used by spring security
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Entry points
        http.authorizeRequests().anyRequest().permitAll();
        /*
        http.authorizeRequests().antMatchers("/rest/login").permitAll()
        .antMatchers("/rest/users/**").hasAuthority("ROLE_ADMIN")
        .antMatchers(HttpMethod.GET, "/rest/movies/**", "/rest/directors/**")
        .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
        .antMatchers(HttpMethod.DELETE, "/rest/movies/**", "/rest/directors/**").hasAuthority("ROLE_ADMIN")
        .antMatchers(HttpMethod.POST, "/rest/movies/**", "/rest/directors/**").hasAuthority("ROLE_ADMIN")
        .antMatchers(HttpMethod.PUT, "/rest/movies/**", "/rest/directors/**").hasAuthority("ROLE_ADMIN")
        // Disallow everything else..
        .anyRequest().authenticated();
        */

        // Apply JWT
        http.apply(new AuthenticationConfigurer(authenticationProvider));

        // Optional, if you want to test the API from a browser
        // http.httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetailsService userDetailsService = getUserDetailsService();
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationEntryPoint unauthorizedEntryPoint() {
        return (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                "Unauthorized");
    }

    @Bean
    public UserDetailsService getUserDetailsService() {
        return new UserDetailsServiceImpl();
    }

}
