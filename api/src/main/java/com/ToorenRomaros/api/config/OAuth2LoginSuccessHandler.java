package com.ToorenRomaros.api.config;

import com.ToorenRomaros.api.dto.user.UserSignedInDto;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserTokenEntity;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.repositories.user.UserTokenRepository;
import com.ToorenRomaros.api.security.CustomUserDetails;
import com.ToorenRomaros.api.security.JwtManager;
import com.ToorenRomaros.api.services.UserService;
import com.ToorenRomaros.api.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private final UserRepository userRepository;
    private final UserService userService;
    @Value("${fronted.url}")
    private String frontendUrl;

    public OAuth2LoginSuccessHandler(UserRepository userRepository, @Lazy UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
    //TODO: I cannot use a HTTP-only cookie because I can't access it with JavaScript,
    // I cannot use a Session cookie,
    // and I cannot read a JSON response either.
    // The only way I found to send an access token and refresh token is via just a cookie.
    // For sure, this might not be the best or most secure way to implement this, but I ran out of ideas.
    // The token returned from Google is for accessing Google's resources, so I cannot use it in my app.
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;

        if("google".equals(oAuth2AuthenticationToken.getAuthorizedClientRegistrationId())){
            DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();
            Map<String, Object> attributes = principal.getAttributes();
            String email = attributes.getOrDefault("email", "").toString();
            String name = attributes.getOrDefault("name", "").toString();

            userRepository.findByEmail(email)
                    .ifPresentOrElse(userEntity -> {
                        try {
                            userService.createUserAndSignIn(userEntity, email, name, response);
                        } catch (UnsupportedEncodingException e) {
                        }
                    }, () -> {
                        UserEntity userEntity = new UserEntity(name, email);
                        UserEntity savedUser = userRepository.save(userEntity);
                        try {
                            userService.createUserAndSignIn(savedUser, email, name,response);
                        } catch (UnsupportedEncodingException e) {
                        }
                    });
        }
        this.setAlwaysUseDefaultTargetUrl(true);
        this.setDefaultTargetUrl(frontendUrl);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
