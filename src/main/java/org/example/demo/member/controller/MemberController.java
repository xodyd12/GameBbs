package org.example.demo.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.member.dto.request.SignUpRequestDTO;
import org.example.demo.member.entity.MemberVO;
import org.example.demo.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login")
public class MemberController {

    private final MemberService memberService;

    // 회원가입 페이지를 반환 (JSP)
    @GetMapping("/sign-up")
    public String signUpForm() {
        return "signUp";  // register.jsp 파일을 렌더링
    }

    //회원가입 처리
    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute SignUpRequestDTO dto){
        System.out.println("memberDTO :"+ dto.getId());
        log.info("login/sign-up POST ~");
        log.debug("parameter : {}", dto);
        memberService.save(dto);
        return "signUp";
    }

    //AJAX로 아이디 중복 여부 처리
    @GetMapping("/checkId")
    @ResponseBody
    public String checkId(@RequestParam("id") String id){
        boolean isAvailable = memberService.isIdAvailable(id);
        return isAvailable ? "available" : "unavailable";
    }
}
