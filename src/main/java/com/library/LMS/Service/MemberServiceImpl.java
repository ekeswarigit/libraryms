package com.library.LMS.Service;

// public class MemberServiceImpl implements memberService {

// }
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.LMS.Dto.MemberRequest;
import com.library.LMS.Dto.MemberResponse;
import com.library.LMS.Entity.Member;
import com.library.LMS.Repository.MemberRepository;
import com.library.LMS.Util.MemberMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @Autowired
    private  MemberRepository memberRepository;

   
    public MemberResponse addMember(MemberRequest request) {

        Member member = MemberMapper.toEntity(request);
        member.setJoinDate(LocalDate.now());
        member.setActive(true);

        Member savedMember = memberRepository.save(member);

        return MemberMapper.toResponse(savedMember);
    }

   
    public List<MemberResponse> getAllMembers() {

        return memberRepository.findAll()
                .stream()
                .map(MemberMapper::toResponse)
                .collect(Collectors.toList());
    }

    
    public MemberResponse getMemberById(Long id) {

        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));

        return MemberMapper.toResponse(member);
    }

    
    public MemberResponse updateMember(Long id, MemberRequest request) {

        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));

        existingMember.setName(request.getName());
        existingMember.setEmail(request.getEmail());
        existingMember.setPhone(request.getPhone());
        existingMember.setMembershipType(request.getMembershipType());

        Member updatedMember = memberRepository.save(existingMember);

        return MemberMapper.toResponse(updatedMember);
    }

    public void deleteMember(Long id) {

        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));

        memberRepository.delete(member);
    }
}