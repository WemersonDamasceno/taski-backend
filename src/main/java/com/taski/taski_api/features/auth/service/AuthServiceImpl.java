
package com.taski.taski_api.features.auth.service;

import com.taski.taski_api.features.auth.repository.AuthRepository;
import com.taski.taski_api.features.auth.security.JwtService;
import com.taski.taski_api.features.user.entity.User;
import com.taski.taski_api.generated.model.AuthRequest;
import com.taski.taski_api.generated.model.AuthResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final AuthRepository authRepository;
    private final JwtService jwtService;

    public AuthServiceImpl(
            PasswordEncoder passwordEncoder,
            AuthRepository authRepository,
            JwtService jwtService
    ) {
        this.passwordEncoder = passwordEncoder;
        this.authRepository = authRepository;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {

        final User user = authRepository
                .findByEmail(authRequest.getEmail())
                .orElseThrow(() ->
                        new BadCredentialsException("Email ou senha inválidos")
                );

        final boolean passwordMatches = passwordEncoder.matches(
                authRequest.getPassword(),
                user.getPassword()
        );

        if (!passwordMatches) {
            throw new BadCredentialsException("Email ou senha inválidos");
        }

        final String token = jwtService.generateToken(
                user.getId().toString()
        );

        return new AuthResponse()
                .accessToken(token)
                .expiresIn(jwtService.getExpirationSeconds())
                .tokenType("Bearer");
    }
}
