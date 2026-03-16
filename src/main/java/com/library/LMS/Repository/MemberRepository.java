package com.library.LMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.LMS.Entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {

}
