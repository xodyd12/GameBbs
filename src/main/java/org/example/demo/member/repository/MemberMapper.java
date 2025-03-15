package org.example.demo.member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.demo.member.entity.MemberVO;

import java.util.List;

@Mapper
public interface MemberMapper {

    //회원 가입
    void save(MemberVO member);

    //회원 정보 단일 조회
    MemberVO findById(@Param("id") String id);

    //아이디 중복 여부 확인
    MemberVO isIdAvailable(@Param("id") String id);

    //이메일, 휴대폰 번호로 아이디 찾기
    List<String> findIdByEmailAndPhoneNumber(@Param("email")String email, @Param("phoneNumber")String phoneNumber);

    //아이디, 이메일, 휴대폰 번호로 비밀번호 찾기
    String findPassword(@Param("id")String id, @Param("email") String email, @Param("phoneNumber")String phoneNumber);
}
