package com.webtourdl.WebTourDuLich.oauth;

import com.webtourdl.WebTourDuLich.entity.User;
import com.webtourdl.WebTourDuLich.enumtype.AuthenticationProvider;
import com.webtourdl.WebTourDuLich.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private UserServiceImpl userServiceimpl;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException , ServletException{
        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getEmail();
        String name = oAuth2User.getName();

        User user = userServiceimpl.getUserByEmail(email);
        if(user == null){
            userServiceimpl.createNewCustomerAfterOAuthLoginSuccess(email,name, AuthenticationProvider.GOOGLE);
        }else{
            userServiceimpl.updateUserCustomerAfterOAuthLoginSuccess(user,name,AuthenticationProvider.GOOGLE);
        }
        System.out.println("User logged in with email: " + email);
        super.onAuthenticationSuccess(request,response,authentication);
    }
}

