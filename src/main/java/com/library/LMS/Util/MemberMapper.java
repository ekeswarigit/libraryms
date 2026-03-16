package com.library.LMS.Util;

import com.library.LMS.Dto.MemberRequest;
import com.library.LMS.Dto.MemberResponse;
import com.library.LMS.Entity.Member;

public class MemberMapper {

     public static Member toEntity(MemberRequest request) {

        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .membershipType(request.getMembershipType())
                .build();
    }

    public static MemberResponse toResponse(Member member) {

        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .membershipType(member.getMembershipType())
                .joinDate(member.getJoinDate())
                .expiryDate(member.getExpiryDate())
                .active(member.isActive())
                .build();
    }
}
