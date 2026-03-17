package com.library.LMS.Entity;

import java.time.LocalDateTime;
import com.library.LMS.Entity.Member.MembershipType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    // @Enumerated(EnumType.STRING)
    // @Column(nullable = false)
    // private MembershipType role = MembershipType.STUDENT;

    private boolean deleted = false;

    private LocalDateTime createdAt= LocalDateTime.now();
    private LocalDateTime updatedAt= LocalDateTime.now();
}
