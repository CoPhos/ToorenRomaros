package com.ToorenRomaros.api.config;

import com.ToorenRomaros.api.dto.user.UserSignedInDto;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.entities.user.UserTokenEntity;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import com.ToorenRomaros.api.repositories.user.UserTokenRepository;
import com.ToorenRomaros.api.security.CustomUserDetails;
import com.ToorenRomaros.api.security.JwtManager;
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
    private final JwtManager tokenManager;
    private final UserTokenRepository userTokenRepository;
    @Value("${fronted.url}")
    private String frontendUrl;

    public OAuth2LoginSuccessHandler(UserRepository userRepository, @Lazy JwtManager tokenManager, UserTokenRepository userTokenRepository) {
        this.userRepository = userRepository;
        this.tokenManager = tokenManager;
        this.userTokenRepository = userTokenRepository;
    }
    //TODO:
    // The Google OAuth2 works, but I definitely need to redesign this code. Also,
    // I cannot use an HTTP-only cookie because I can't access it with JavaScript,
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
                        DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority(userEntity.getRole().name())), attributes, "sub");
                        Authentication securityAuthentication = new OAuth2AuthenticationToken(newUser,  List.of(new SimpleGrantedAuthority(userEntity.getRole().name())),
                                oAuth2AuthenticationToken.getAuthorizedClientRegistrationId());
                        SecurityContextHolder.getContext().setAuthentication(securityAuthentication);
                        UserSignedInDto userSignedInDto = createSignedInUser(userEntity);
                        userSignedInDto.setRefreshToken(createRefreshToken(userEntity));
                        try {
                            storeUserInfoInCookie(response, "id", userEntity.getId().toString());
                            storeUserInfoInCookie(response, "accessToken",userSignedInDto.getAccessToken());
                            storeUserInfoInCookie(response, "refreshToken",userSignedInDto.getRefreshToken());
                            storeUserInfoInCookie(response, "email",email);
                            storeUserInfoInCookie(response, "name",name);
                        } catch (UnsupportedEncodingException e) {
                        }

                    }, () -> {
                        UserEntity userEntity = new UserEntity(name, email);
                        UserEntity savedUser = userRepository.save(userEntity);
                        DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority(userEntity.getRole().name())),
                                attributes, "sub");
                        Authentication securityAuth = new OAuth2AuthenticationToken(newUser, List.of(new SimpleGrantedAuthority(userEntity.getRole().name())),
                                oAuth2AuthenticationToken.getAuthorizedClientRegistrationId());
                        SecurityContextHolder.getContext().setAuthentication(securityAuth);

                        UserSignedInDto userSignedInDto = createSignedInUser(userEntity);
                        userSignedInDto.setRefreshToken(createRefreshToken(userEntity));

                        try {
                            storeUserInfoInCookie(response, "id", savedUser.getId().toString());
                            storeUserInfoInCookie(response, "accessToken",userSignedInDto.getAccessToken());
                            storeUserInfoInCookie(response, "refreshToken",userSignedInDto.getRefreshToken());
                            storeUserInfoInCookie(response, "email",email);
                            storeUserInfoInCookie(response, "name",name);
                        } catch (UnsupportedEncodingException e) {
                        }
                    });
        }

        this.setAlwaysUseDefaultTargetUrl(true);
        this.setDefaultTargetUrl(frontendUrl);
        super.onAuthenticationSuccess(request, response, authentication);
    }
    public  String createRefreshToken(UserEntity user) {
        String token = UserServiceImpl.RandomHolder.randomKey(128);
        userTokenRepository.save(new UserTokenEntity().setRefreshToken(token).setUser(user));
        return token;
    }
    private UserSignedInDto createSignedInUser(UserEntity userEntity) {
        String token;
        token = tokenManager.create(new CustomUserDetails(
                userEntity.getUsername(),
                "",
                Objects.nonNull(userEntity.getRole()) ? userEntity.getRole().name() : ""));
        return new UserSignedInDto(userEntity.getUsername(), token,userEntity.getEmail(), userEntity.getId().toString());
    }
    private void storeUserInfoInCookie(HttpServletResponse response, String cookieName, String cookieValue) throws UnsupportedEncodingException {
        String encodedValue = URLEncoder.encode(cookieValue, StandardCharsets.UTF_8);
        Cookie userCookie = new Cookie(cookieName, encodedValue);
        userCookie.setMaxAge(30);
        userCookie.setPath("/");
        userCookie.setSecure(true);
        response.addCookie(userCookie);
    }
}
