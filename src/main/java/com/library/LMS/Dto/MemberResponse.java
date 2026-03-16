package com.library.LMS.Dto;

import java.time.LocalDate;
import com.library.LMS.Entity.Member.MembershipType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private MembershipType membershipType;
    private LocalDate joinDate;
    private LocalDate expiryDate;
    private boolean active;

}
