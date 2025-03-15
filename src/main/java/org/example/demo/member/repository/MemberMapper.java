package org.example.demo.member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.demo.member.entity.MemberVO;

@Mapper
public interface MemberMapper {

    //회원 가입
    void save(MemberVO member);

    //회원 정보 단일 조회
    MemberVO findMember(@Param("id") String id);

    //아이디 중복 여부 확인
    MemberVO isIdAvailable(@Param("id") String id);
}
