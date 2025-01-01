package com.example.study.member.mapper.auth;


import com.example.study.member.domain.member.StudyMember;
import com.example.study.member.ui.auth.dto.SignUpRequest;
import com.example.study.member.ui.auth.dto.SignUpResponse;

public class AuthMapper {

    public static StudyMember toMember(SignUpRequest signUpRequest) {
        return new StudyMember(
                signUpRequest.memberEmail(),
                signUpRequest.memberName(),
                signUpRequest.memberPassword(),
                signUpRequest.memberNickName()
        );
    }

    public static SignUpResponse toSignUpResponse(StudyMember studyMember) {
        return new SignUpResponse(studyMember.getId(), studyMember.getMemberName(), studyMember.getMemberEmail(),
                studyMember.getMemberPassword(), studyMember.getMemberNickName());
    }
}
