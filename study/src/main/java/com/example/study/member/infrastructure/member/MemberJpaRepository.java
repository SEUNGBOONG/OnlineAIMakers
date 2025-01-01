package com.example.study.member.infrastructure.member;


import com.example.study.member.domain.member.StudyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberJpaRepository extends JpaRepository<StudyMember, Long> {

    boolean existsByMemberNickName(String memberNickName);

    boolean existsByMemberEmail(String memberEmail);

    Optional<StudyMember> findMemberByMemberEmail(String memberEmail);

    Optional<StudyMember> findById(Long memberId);
}
