package com.ToorenRomaros.api.filters;

import com.ToorenRomaros.api.dto.recaptcha.RecaptchaResponseDto;

import com.ToorenRomaros.api.services.RecaptchaService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.ToorenRomaros.api.security.Constants.SIGNUP_URL;
import static com.ToorenRomaros.api.security.Constants.TOKEN_URL;

public class RecaptchaFilter extends OncePerRequestFilter {
    private final RecaptchaService recaptchaService;

    public RecaptchaFilter(RecaptchaService recaptchaService) {
        this.recaptchaService = recaptchaService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if ("POST".equals(request.getMethod())) {
            String requestURI = request.getRequestURI();
            if (SIGNUP_URL.equals(requestURI) || TOKEN_URL.equals(requestURI)) {
                String recaptcha = request.getHeader("recaptcha");
                RecaptchaResponseDto recaptchaResponse = recaptchaService.validateToken(recaptcha);
                if (!recaptchaResponse.getSuccess()) {
                    throw new BadCredentialsException("Invalid reCaptcha token");
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
