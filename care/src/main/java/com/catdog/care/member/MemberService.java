package com.catdog.care.member;

import com.catdog.care.exception.ErrorCode;
import com.catdog.care.exception.MemberExcption;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member singleMemberSelect(String id) {
        Optional<Member> memberId = memberRepository.findById(id);

        if(memberId.isEmpty()) {
            throw new MemberExcption(ErrorCode.NOT_FOUND);
        }

        return memberId.get();
    }

    public Member signOut(String id) {
        Optional<Member> memberId = memberRepository.findById(id);

        if(memberId.isEmpty()) {
            throw new MemberExcption(ErrorCode.NOT_FOUND);
        }

        Member test = memberId.get();
        test.setName("탈퇴한 회원");
        test.setResign_yn("Y");

        Member db = memberRepository.save(test);

        return db;
    }

    public Member modify(Member member) {
        Optional<Member> memberId = memberRepository.findById(member.getId());

        if(memberId.isEmpty()) {
            throw new MemberExcption(ErrorCode.NOT_FOUND);
        }
        Member db = memberRepository.save(memberId.get());

        db.setName(member.getName());
        db.setPassword(member.getPassword());
        return db;
    }
}
