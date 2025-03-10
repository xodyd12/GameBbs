package org.example.demo.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.config.SecurityConfig;
import org.example.demo.member.dto.request.SignUpRequestDTO;
import org.example.demo.member.repository.MemberMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder encoder;

    //회원가입 처리
    public void save(SignUpRequestDTO signUpRequestDTO){

        memberMapper.save(signUpRequestDTO.toEntity(encoder));
    }
}
