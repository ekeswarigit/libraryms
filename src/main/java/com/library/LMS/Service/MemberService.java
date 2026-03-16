package com.library.LMS.Service;

import java.util.List;

import com.library.LMS.Dto.MemberRequest;
import com.library.LMS.Dto.MemberResponse;

public interface MemberService {

    public MemberResponse addMember(MemberRequest request);

    public List<MemberResponse> getAllMembers();
     public MemberResponse getMemberById(Long id);
     public MemberResponse updateMember(Long id, MemberRequest request);
      public void deleteMember(Long id);
}
