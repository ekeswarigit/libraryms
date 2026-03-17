package com.library.LMS.Security;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.library.LMS.Entity.User;
import com.library.LMS.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                new ArrayList<>() // roles later
        );
    }
}
