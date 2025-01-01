package com.example.study.member.application.auth;

import com.example.study.member.domain.member.StudyMember;
import com.example.study.member.exception.exceptions.auth.DuplicateEmailException;
import com.example.study.member.exception.exceptions.auth.DuplicateNickNameException;
import com.example.study.member.exception.exceptions.auth.InvalidEmailFormatException;
import com.example.study.member.exception.exceptions.auth.InvalidLoginRequestException;
import com.example.study.member.exception.exceptions.auth.InvalidPasswordFormatException;
import com.example.study.member.exception.exceptions.auth.InvalidSignUpRequestException;
import com.example.study.member.exception.exceptions.auth.NotFoundMemberByEmailException;
import com.example.study.member.infrastructure.auth.JwtTokenProvider;
import com.example.study.member.infrastructure.member.MemberJpaRepository;
import com.example.study.member.mapper.auth.AuthMapper;
import com.example.study.member.ui.auth.dto.LoginRequest;
import com.example.study.member.ui.auth.dto.LoginResponse;
import com.example.study.member.ui.auth.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberJpaRepository memberJpaRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");


    @Transactional
    public StudyMember signUp(SignUpRequest signUpRequest) {
        validateSignupRequestFormat(signUpRequest);
        validateEmailFormat(signUpRequest.memberEmail());
        checkPasswordLength(signUpRequest.memberPassword());
        StudyMember studyMember = AuthMapper.toMember(signUpRequest);
        checkDuplicateMemberNickName(studyMember.getMemberNickName());
        checkDuplicateMemberEmail(studyMember.getMemberEmail());

        return memberJpaRepository.save(studyMember);
    }

    private void validateSignupRequestFormat(SignUpRequest signUpRequest) {
        if (signUpRequest == null ||
                isEmpty(signUpRequest.memberEmail()) ||
                isEmpty(signUpRequest.memberName()) ||
                isEmpty(signUpRequest.annualIncome()) ||
                isEmpty(signUpRequest.memberPassword()) ||
                isEmpty(signUpRequest.memberNickName())) {
            throw new InvalidSignUpRequestException();
        }
    }

    private void validateEmailFormat(String email) {
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new InvalidEmailFormatException();
        }
    }

    private void checkDuplicateMemberNickName(String nickName) {
        if (memberJpaRepository.existsByMemberNickName(nickName)) {
            throw new DuplicateNickNameException();
        }
    }

    private void checkDuplicateMemberEmail(String email) {
        if (memberJpaRepository.existsByMemberEmail(email)) {
            throw new DuplicateEmailException();
        }
    }

    private void checkPasswordLength(String password) {
        if (password.length() <= 7) {
            throw new InvalidPasswordFormatException();
        }
    }

    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest loginRequest) {
        validateLoginRequestFormat(loginRequest);
        StudyMember studyMember = findMemberByEmail(loginRequest.memberEmail());
        studyMember.checkPassword(loginRequest.memberPassword());
        String token = jwtTokenProvider.createToken(studyMember.getId());

        return new LoginResponse(token, studyMember.getId(), studyMember.getMemberName(), studyMember.getMemberNickName());
    }

    private void validateLoginRequestFormat(LoginRequest loginRequest) {
        if (loginRequest == null ||
                isEmpty(loginRequest.memberEmail()) ||
                isEmpty(loginRequest.memberPassword())) {
            throw new InvalidLoginRequestException();
        }
    }

    private StudyMember findMemberByEmail(String email) {
        return memberJpaRepository.findMemberByMemberEmail(email)
                .orElseThrow(NotFoundMemberByEmailException::new);
    }
}
