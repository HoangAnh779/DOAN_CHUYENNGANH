//package com.webtourdl.WebTourDuLich.security.oauth;
//
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomOAuth2UserService extends DefaultOAuth2UserService {
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        // Gọi phương thức loadUser của DefaultOAuth2UserService
//        OAuth2User oAuth2User = super.loadUser(userRequest);
//
//        // Log tất cả các thuộc tính OAuth2 để kiểm tra
//        System.out.println("OAuth2 attributes: " + oAuth2User.getAttributes());
//
//        // Lấy email từ attributes
//        String email = oAuth2User.getAttribute("email");
//        String username = null;
//
//        // Nếu có email, lấy phần trước '@' của email làm username
//        if (email != null) {
//            username = email.split("@")[0]; // Phần trước '@' của email làm username
//        } else if (oAuth2User.getAttribute("name") != null) {
//            // Nếu không có email, dùng name làm username
//            username = oAuth2User.getAttribute("name");
//        }
//
//        // Kiểm tra xem đã có username chưa, nếu không có thì ném lỗi
//        if (username == null) {
//            throw new IllegalArgumentException("Unable to determine username from OAuth2 attributes.");
//        }
//
//        // Tạo một map mutable (có thể thay đổi) từ attributes của OAuth2User
//        Map<String, Object> updatedAttributes = new HashMap<>(oAuth2User.getAttributes());
//
//
//        // Thêm username vào attributes
//        updatedAttributes.put("username", username);
//        System.out.println("username: " +username);
//        // Trả về OAuth2User mới với username đã thêm vào
//        return new DefaultOAuth2User(
//                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")),
//                updatedAttributes,
//                "username" // Key xác định username trong attributes
//        );
//    }
//}
package com.webtourdl.WebTourDuLich.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
        OAuth2User user = super.loadUser(userRequest);
        return  new CustomOAuth2User(user);
    }
}