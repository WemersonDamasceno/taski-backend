package com.taski.taski_api.features.auth.controllers;

import com.taski.taski_api.features.auth.service.AuthService;
import com.taski.taski_api.generated.api.AuthApi;
import com.taski.taski_api.generated.model.AuthRequest;
import com.taski.taski_api.generated.model.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<AuthResponse> login(AuthRequest authRequest) {
        AuthResponse response = authService.login(authRequest);
        return ResponseEntity.ok(response);
    }
}