package com.taski.taski_api.features.user.service;

import com.taski.taski_api.generated.model.UserRequest;
import com.taski.taski_api.generated.model.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserResponse> getUsersByJob(String job);
    UserResponse createUser(UserRequest userRequest);
}