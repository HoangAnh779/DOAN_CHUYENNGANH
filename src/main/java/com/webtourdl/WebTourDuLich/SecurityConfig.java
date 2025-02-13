package com.webtourdl.WebTourDuLich;

import com.webtourdl.WebTourDuLich.error.CustomAccessDeniedHandler;
import com.webtourdl.WebTourDuLich.oauth.CustomOAuth2UserService;
import com.webtourdl.WebTourDuLich.oauth.OAuth2LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final DataSource dataSource;
    private final CustomOAuth2UserService oAuth2UserService;
    private final OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
    private final CustomAccessDeniedHandler accessDeniedHandler;

    public SecurityConfig(DataSource dataSource, CustomOAuth2UserService oAuth2UserService, OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler, CustomAccessDeniedHandler accessDeniedHandler) {
        this.dataSource = dataSource;
        this.oAuth2UserService = oAuth2UserService;
        this.oAuth2LoginSuccessHandler = oAuth2LoginSuccessHandler; // Thêm vào constructor
        this.accessDeniedHandler = accessDeniedHandler;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/login", "/oauth2/**","/register","/updateAccount","/forgotPassword", "/changePassword")
                )
                .authorizeRequests(auth -> auth
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/public/**", "/", "/tin-tuc","/updateAccount",
                                "/about", "/tour/**", "/register", "/error","/account","/login","/momo/**",
                                "/logout", "/forgotPassword", "/lien-he", "/changePassword", "/updateAccount", "/user/**","/admin/**"
                        ).permitAll()
                        .requestMatchers( "/api/**").permitAll()
                        .requestMatchers("/oauth2/**").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/**") // Bỏ qua CSRF cho các endpoint này
                )
                .exceptionHandling(e -> e.accessDeniedHandler(accessDeniedHandler)
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error")
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(oAuth2UserService)
                        )
                        .successHandler(oAuth2LoginSuccessHandler)
                )
                .build();
    }
}
