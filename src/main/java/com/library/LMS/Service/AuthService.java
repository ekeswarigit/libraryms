package com.library.LMS.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.LMS.Dto.UserRequest;
import com.library.LMS.Entity.User;
import com.library.LMS.Repository.UserRepository;
import com.library.LMS.Util.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

     private final UserRepository repo;
    private final PasswordEncoder encoder;

    public User register(UserRequest request) {

         User user = UserMapper.toEntity(request);
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public User findByUsername(String username) {
        return repo.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
