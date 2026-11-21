package com.taski.taski_api.features.auth.service;

import com.taski.taski_api.generated.model.AuthRequest;
import com.taski.taski_api.generated.model.AuthResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        final String passwordEncoded = passwordEncoder.encode(authRequest.getPassword());
        //TODO: Continuar a implementação aqui <<<<<<




        return new AuthResponse()
                .accessToken("accessToken")
                .expiresIn(13343L)
                .tokenType("Bearer");
    }
}