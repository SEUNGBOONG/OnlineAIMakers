package com.example.study.member.application.member;

import com.example.study.member.domain.member.Member;
import com.example.study.member.infrastructure.member.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public String getMemberNickName(Long memberId) {
        Member member = memberJpaRepository.findById(memberId)
                .orElseThrow(RuntimeException::new);
        return member.getMemberNickName();
    }
}
