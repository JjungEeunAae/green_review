package com.catdog.care.member;

import com.catdog.care.exception.ErrorCode;
import com.catdog.care.exception.MemberExcption;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("my")
@Tag(name = "Member-Controller", description = "유저 조회, 등록, 수정, 삭제")
public class MemberController {
    private final MemberService service;

    @GetMapping("{id}")
    public ResponseEntity<Member> singleMemberSelect(@PathVariable String id) {
        Member member = service.singleMemberSelect(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(member);
    }

    @PutMapping()
    public ResponseEntity<Member> modifyMember(@Valid @RequestBody MemberDTO memberDTO) {
        ModelMapper mapper = new ModelMapper();
        Member member = mapper.map(memberDTO, Member.class);

        Member db = service.modify(member);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(db);
    }

    @PutMapping("signOut")
    public ResponseEntity<Member> signOut(@Valid @RequestBody MemberDTO memberDTO) {
        ModelMapper mapper = new ModelMapper();
        Member member = mapper.map(memberDTO, Member.class);

        Member db = service.signOut(member.getId());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(db);
    }
}
