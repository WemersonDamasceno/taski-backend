package com.taski.taski_api.service.users;

import com.taski.taski_api.generated.model.UserRequest;
import com.taski.taski_api.generated.model.UserResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<UserResponse> getUsersByJob(String job) {
        return users.stream()
                .filter(element -> element.getJob().equals(job))
                .toList();
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse()
                .id(UUID.randomUUID())
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .age(userRequest.getAge())
                .job(userRequest.getJob())
                .birthDate(userRequest.getBirthDate());
        users.add(userResponse);

        return userResponse;
    }

    private final List<UserResponse> users = new ArrayList<>(List.of(
            new UserResponse()
                    .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440010"))
                    .name("Wemerson")
                    .email("wemerson.damasceno@gmail.com")
                    .age(29)
                    .job("Desenvolvedor"),

            new UserResponse()
                    .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"))
                    .name("João")
                    .email("joaozin@gmail.com")
                    .age(32)
                    .job("Dentista")
    ));
}
