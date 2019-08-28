package com.tieto.bookyourshelf.library.config;

import com.tieto.bookyourshelf.library.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    };

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new CustomAuthenticationSuccessHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/app/login**","/app/registration**").permitAll()
                .antMatchers("/app/uploadImage", "/app/faceRecognition").permitAll()
                .antMatchers("/app/books","/app/book*").permitAll()
                .antMatchers("/app/account").authenticated()
                .antMatchers(HttpMethod.GET,"/app/user*","/app/user/**","/app/book/add").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET,"/app/scanBook").hasAuthority("ROLE_USER")
                .and()
                .formLogin()
                .loginPage("/app/login").permitAll().loginProcessingUrl("/app/loginAction").permitAll()
                .successHandler(myAuthenticationSuccessHandler())
                .failureHandler((req,res,exp)->{  // Failure handler invoked after authentication failure
                    String errMsg="";
                    if(exp.getClass().isAssignableFrom(BadCredentialsException.class)){
                        errMsg="Invalid username or password.";
                    }else{
                        errMsg="Unknown error - "+exp.getMessage();
                    }
                    req.getSession().setAttribute("message", errMsg);
                    res.sendRedirect("/app/login"); // Redirect user to login page with error message.
                })
                .and()
                .logout().logoutSuccessUrl("/").permitAll()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .csrf().disable();
    }
}







