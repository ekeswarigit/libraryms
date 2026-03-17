package com.library.LMS.Util;
import com.library.LMS.Dto.AuthResponse;
import com.library.LMS.Dto.UserRequest;
import com.library.LMS.Dto.UserResponse;
import com.library.LMS.Entity.User;

public class UserMapper {

    // 🔹 DTO → Entity
    public static User toEntity(UserRequest request) {
        return User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword()) // encode in service
                .build();
    }

    // 🔹 Entity → Response DTO
    public static AuthResponse toResponse(User user) {
        return AuthResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}