package org.example.demo.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.member.dto.request.SignUpRequestDTO;
import org.example.demo.member.entity.MemberVO;
import org.example.demo.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login")
public class MemberController {

    private final MemberService memberService;

    //회원가입 처리
    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequestDTO dto){
        System.out.println("memberDTO :"+ dto.getId());
        log.info("login/sign-up POST ~");
        log.debug("parameter : {}", dto);
        memberService.save(dto);
        return ResponseEntity.ok("회원가입 성공!");
    }

}
