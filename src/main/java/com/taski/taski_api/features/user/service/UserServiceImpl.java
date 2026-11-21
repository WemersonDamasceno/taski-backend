
package com.taski.taski_api.features.user.service;

import com.taski.taski_api.features.user.entity.User;
import com.taski.taski_api.features.user.repository.UserRepository;
import com.taski.taski_api.generated.model.UserRequest;
import com.taski.taski_api.generated.model.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserResponse> getUsersByJob(String job) {
        return userRepository.findByJob(job)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {

        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        User user = new User();

        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setAge(userRequest.getAge());
        user.setJob(userRequest.getJob());
        user.setBirthDate(userRequest.getBirthDate());

        User savedUser = userRepository.save(user);

        return toResponse(savedUser);
    }

    private UserResponse toResponse(User user) {
        return new UserResponse()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .job(user.getJob())
                .birthDate(user.getBirthDate());
    }
}
