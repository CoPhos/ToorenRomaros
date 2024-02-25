package com.ToorenRomaros.api.security;

public class Constants {
    public static final String ENCODER_ID = "bcrypt";
    public static final String AUTHORIZATION = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String SECRET_KEY = "SECRET_KEY";
    public static final long EXPIRATION_TIME = 9_000_000; // 900_000 15 mins - 1000 10sec for testing
    public static final String ROLE_CLAIM = "roles";
    public static final String AUTHORITY_PREFIX = "ROLE_";
    //URLs
    public static final String API_URL_PREFIX = "/api/v1/**";
    public static final String H2_URL_PREFIX = "/h2-console/**";
    public static final String SIGNUP_URL = "/api/v1/users";
    public static final String TOKEN_URL = "/api/v1/auth/token";
    public static final String REFRESH_URL = "/api/v1/auth/token/refresh";
    public static final String RESET_PASSWORD_URL = "/api/v1/auth/reset-password";
    public static final String ADMIN_URL = "/api/v1/admin/**";

    public static final String[] SWAGGER_WHITELIST = {
            "/v2/api-docs", "/v3/api-docs", "/v3/api-docs/**", "/swagger-resources", "/swagger-resources/**", "/configuration/ui", "/configuration/security","/swagger-ui/**", "/swagger-ui.html", "/webjars/**"
    };
    public static final String[] GET_WHITELIST = {
            "/api/v1/film/**",
            "/api/v1/films/**",
            "/api/v1/posts/**",
            "/api/v1/**/media/images/",
            "/api/v1/images/**",
    };
    public static final String[] POST_WHITELIST = {
            "/api/v1/auth/token",
            "/api/v1/users",
            "/api/v1/auth/token/refresh",
            "/api/v1/**/image",
            "/api/v1/posts/images/**",
            "/api/v1/auth/forgot-password",
    };
}