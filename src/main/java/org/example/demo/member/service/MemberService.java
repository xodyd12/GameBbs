package org.example.demo.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.member.dto.request.SignUpRequestDTO;
import org.example.demo.member.entity.MemberVO;
import org.example.demo.member.repository.MemberMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder encoder;

    //로그인 처리
    public boolean authenticate(String id, String password){
        MemberVO member = memberMapper.findById(id);

        if(member == null){
            return false;
        }
        return encoder.matches(password, member.getPassword());
    }
    //회원가입 처리
    public void save(SignUpRequestDTO signUpRequestDTO){
        //아이디 중복 체크
        if(!isIdAvailable(signUpRequestDTO.getId())){
            throw new IllegalArgumentException("이미 사용중인 아이디 입니다.");
        }
        memberMapper.save(signUpRequestDTO.toEntity(encoder));
    }

    //아이디 중복 여부 검사
    public boolean isIdAvailable(String id){
        return memberMapper.isIdAvailable(id) == null;
    }

    //아이디 찾기
    public List<String> findIdByEmailAndPhoneNumber(String email, String phoneNumber){
        return memberMapper.findIdByEmailAndPhoneNumber(email, phoneNumber);
    }
    //비번 찾기
    public String findPassword(String id, String email, String phoneNumber){
        return memberMapper.findPassword(id, email, phoneNumber);
    }
}
