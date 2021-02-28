package com.example.demo.security;

public class SecurityConstants {
    // константы отвечающие за генерацию, авторизацию и др


    public static final String SING_UP_URLS = "/api/auth/**";

    public static final String SECRET = "SecretKeyGenJWT";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorication ";
    public static final String CONTENT_TYPE = "application/json ";
    public static final long EXPIRATION_TIME = 600_000; // 10 min
}
