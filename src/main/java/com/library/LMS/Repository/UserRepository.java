package com.library.LMS.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.library.LMS.Dto.UserRequest;
import com.library.LMS.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User save(UserRequest user);
}
