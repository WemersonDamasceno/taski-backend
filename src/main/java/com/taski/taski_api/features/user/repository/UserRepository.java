
package com.taski.taski_api.features.user.repository;

import com.taski.taski_api.features.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    List<User> findByJob(String job);

    boolean existsByEmail(String email);
}
