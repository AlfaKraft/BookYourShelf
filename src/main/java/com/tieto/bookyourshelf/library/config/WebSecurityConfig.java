package com.tieto.bookyourshelf.library.config;

import com.tieto.bookyourshelf.library.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
@EnableWebSecurity //algne
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
                .antMatchers("/app/login**").permitAll()
                .antMatchers("/app/books","/app/book*").permitAll()
                .antMatchers(HttpMethod.GET,"/app/user*","/app/user/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET,"/app/scanBook").hasAuthority("ROLE_USER")
                .and()
                .formLogin()
                .loginPage("/app/login").permitAll().loginProcessingUrl("/app/loginAction").permitAll()
                .successHandler(myAuthenticationSuccessHandler())
               // .failureUrl("/app/books")
                .and()
                .logout().logoutSuccessUrl("/").permitAll()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .csrf().disable();
    }
}


    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/app/login*").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/app/login")
                .defaultSuccessUrl("/app/index", true)
                .failureUrl("/login?error=true")
                .and()
                .logout().logoutSuccessUrl("/app/login");
    }
}*/





