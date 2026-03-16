package com.library.LMS.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.LMS.Dto.ApiResponse;
import com.library.LMS.Dto.MemberRequest;
import com.library.LMS.Dto.MemberResponse;
import com.library.LMS.Payload.Status;
import com.library.LMS.Service.MemberService;

    
    @RestController
    @RequestMapping("/members")
   // @RequiredArgsConstructor
    public class MemberController {
    
        @Autowired
        private MemberService memberService;
    
        // ✅ Add Member
        @PostMapping
        public ApiResponse<MemberResponse> addMember(@RequestBody MemberRequest request) {
    
            MemberResponse member = memberService.addMember(request);
    
            return new ApiResponse<>( LocalDateTime.now(),  Status.CREATED, Status.CREATED.getCode(),
                    null,  "Member added successfully",  member
            );
        }
    
        // ✅ Get All Members
        @GetMapping
        public ApiResponse<List<MemberResponse>> getAllMembers() {
    
            List<MemberResponse> members = memberService.getAllMembers();
    
            return new ApiResponse<>(
                    LocalDateTime.now(), Status.SUCCESS, Status.SUCCESS.getCode(),
                    null,  "Members fetched successfully",  members
            );
        }
    
        // ✅ Get Member By ID
        @GetMapping("/{id}")
        public ApiResponse<MemberResponse> getMemberById(@PathVariable Long id) {
    
            MemberResponse member = memberService.getMemberById(id);
    
            return new ApiResponse<>(
                    LocalDateTime.now(),   Status.SUCCESS, Status.SUCCESS.getCode(),
                    null,   "Member fetched successfully",  member
            );
        }
    
        // ✅ Update Member
        @PutMapping("/{id}")
        public ApiResponse<MemberResponse> updateMember(@PathVariable Long id, @RequestBody MemberRequest request) {
    
            MemberResponse member = memberService.updateMember(id, request);
    
            return new ApiResponse<>(
                    LocalDateTime.now(),  Status.SUCCESS,  Status.SUCCESS.getCode(),
                    null,    "Member updated successfully",  member
            );
        }
    
        // ✅ Delete Member
        @DeleteMapping("/{id}")
        public ApiResponse<String> deleteMember(@PathVariable Long id) {
    
            memberService.deleteMember(id);
    
            return new ApiResponse<>(
                    LocalDateTime.now(),    Status.SUCCESS,  Status.SUCCESS.getCode(),
                    null,  "Member deleted successfully",  "Deleted"
            );
        }
    }

