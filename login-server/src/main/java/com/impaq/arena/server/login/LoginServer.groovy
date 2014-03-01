package com.impaq.arena.server.login

import com.impaq.arena.server.login.user.CurrentUserResolver
import com.impaq.arena.server.login.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

import static org.springframework.http.HttpMethod.GET
import static org.springframework.http.HttpMethod.POST

@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
class LoginServer {

    public static void main(String[] args) {
        SpringApplication.run(LoginServer.class, args)
    }

    @Configuration
    static class WebConfig extends WebMvcConfigurerAdapter {

        @Override
        void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
            argumentResolvers.add(new CurrentUserResolver())
        }
    }

    @Configuration
    static class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        UserService userService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .antMatchers(GET, "/").permitAll()
                    .antMatchers(POST, "/player").permitAll()
                    .anyRequest().authenticated()
            http
                .httpBasic()
                    .realmName("IMPAQ Arena")
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                .userDetailsService(userService)
        }
    }
}
