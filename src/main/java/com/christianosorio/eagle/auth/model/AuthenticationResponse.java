package com.christianosorio.eagle.auth.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {
    private final String userName;
    private final String jwt;
    private final String userId;
    private final Boolean auth;

    public AuthenticationResponse(final String userName,
                                  final String jwt,
                                  final String userId,
                                  final Boolean auth) {
        this.userName = userName;
        this.jwt = jwt;
        this.userId = userId;
        this.auth = auth;
    }
}
