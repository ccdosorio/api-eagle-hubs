package com.christianosorio.eagle.auth;

import static org.springframework.http.HttpStatus.OK;

import com.christianosorio.eagle.auth.model.AuthenticationRequest;
import com.christianosorio.eagle.auth.model.AuthenticationResponse;
import com.christianosorio.eagle.auth.service.AuthService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthRestController {

    private final AuthService authService;

    public AuthRestController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(
            value = "/authenticate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(OK)
    public AuthenticationResponse createToken(@RequestBody AuthenticationRequest request) {
        return authService.authUser(request.getUserName(), request.getPassword());
    }
}