package dss.system.configuration;

public final class SecurityConstants {
    public static final long EXPIRATION_TIME = 30;
    public static final String SECRET = "SECRET_KEY";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/user/login";
    public static final String REGISTER_URL = "/api/user/registration";
    public static final String LOGIN = "/login";
    public static final String REGISTRATION = "/registration";
    public static final String ROOT = "/";
    public static final String WORKSPACE = "/workspace";
    public static final String STATIC = "/static/**";
}
