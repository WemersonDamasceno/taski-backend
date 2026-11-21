package com.taski.taski_api.features.auth.repository;

import com.taski.taski_api.features.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
