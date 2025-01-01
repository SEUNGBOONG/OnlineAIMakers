package com.example.study.member.application.member;

import com.example.study.member.domain.member.StudyMember;
import com.example.study.member.infrastructure.member.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public String getMemberNickName(Long memberId) {
        StudyMember studyMember = memberJpaRepository.findById(memberId)
                .orElseThrow(RuntimeException::new);
        return studyMember.getMemberNickName();
    }
}
