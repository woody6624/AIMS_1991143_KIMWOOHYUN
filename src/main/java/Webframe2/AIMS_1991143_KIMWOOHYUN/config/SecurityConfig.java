package Webframe2.AIMS_1991143_KIMWOOHYUN.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html
//해당 url의 spring-security를 참조하였습니다.
@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers("/", "/").permitAll()
                .anyRequest().hasRole("USER"));

        http.formLogin((auth) -> auth
                .loginPage("/login")
                .loginProcessingUrl("/authenticate")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/")
                .permitAll());
        http                              //로그아웃에 대한 부분입니다.로그아웃 실행시 /logout으로 이동합니다.
                .logout((auth) -> auth.logoutUrl("/logout")
                        .logoutSuccessUrl("/")); //로그아웃 성공시에 메인 페이지로 이동합니다.경로명 "/"


        return http.build();
    }
}
