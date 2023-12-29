package com.ToorenRomaros.api.entities.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum  implements GrantedAuthority {
    USER(Const.USER),
    CRITIC(Const.CRITIC),
    ADMIN(Const.ADMIN),
    MODERATOR(Const.MODERATOR);

    private String authority;

    RoleEnum(String authority) {
        this.authority = authority;
    }

    @JsonCreator
    public static RoleEnum fromAuthority(String authority) {
        for (RoleEnum b : RoleEnum.values()) {
            if (b.authority.equals(authority)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + authority + "'");
    }

    @Override
    public String toString() {
        return String.valueOf(authority);
    }

    @Override
    @JsonValue
    public String getAuthority() {
        return authority;
    }

    public static class Const {

        public static final String ADMIN = "ROLE_ADMIN";
        public static final String USER = "ROLE_USER";
        public static final String CRITIC = "ROLE_CRITIC";
        public static final String MODERATOR = "ROLE_MODERATOR";
    }
}
