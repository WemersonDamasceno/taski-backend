package com.taski.taski_api.features.auth.service;

import com.taski.taski_api.generated.model.AuthRequest;
import com.taski.taski_api.generated.model.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest authRequest);
}
