
package com.taski.taski_api.controller;

import com.taski.taski_api.generated.api.UsersApi;
import com.taski.taski_api.generated.model.UserRequest;
import com.taski.taski_api.generated.model.UserResponse;
import com.taski.taski_api.service.users.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UsersApi {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Override
    public ResponseEntity<List<UserResponse>> getUsersByJob(String job) {
        List<UserResponse> response = userService.getUsersByJob(job);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserResponse> createUser(@Valid UserRequest userRequest){
        UserResponse userResponse = userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
}
