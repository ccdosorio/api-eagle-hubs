package com.christianosorio.eagle.auth.service;

import com.christianosorio.eagle.auth.model.AuthenticationResponse;
import com.christianosorio.eagle.config.security.JWTUtil;
import com.christianosorio.eagle.exception.impl.ForbiddenException;
import com.christianosorio.eagle.model.user.User;
import com.christianosorio.eagle.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final JWTUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthService(final JWTUtil jwtUtil, final UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    public AuthenticationResponse authUser(final String userName, final String password) {
        final Optional<User> userDetails = userRepository.authUser(userName, password);

        if (userDetails.isPresent()) {
            final String jwt = jwtUtil.generateToken(userDetails.get());

            return new AuthenticationResponse(userDetails.get().getUserName(),
                    jwt,
                    String.valueOf(userDetails.get().getUserId()),
                    true);
        } else {
            throw ForbiddenException.builder()
                    .exceptionMessage("The username entered is incorrect")
                    .build();
        }
    }

}
