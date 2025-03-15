package org.example.demo.member.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.member.dto.request.SignUpRequestDTO;
import org.example.demo.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 로그인 페이지 이동
    @GetMapping("/login")
    public String loginPage() {
        return "loginPage/login"; // WEB-INF/views/login.jsp
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(
            @RequestParam("id") String id,
            @RequestParam("password") String password,
            HttpServletRequest request,
            Model model) {

        log.info("로그인 시도: {}", id);

        boolean isAuthenticated = memberService.authenticate(id, password);

        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", id); // 세션에 사용자 ID 저장
            return "redirect:/home"; // 로그인 성공 시 홈 페이지로 이동
        } else {
            model.addAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "loginPage/login"; // 로그인 실패 시 다시 로그인 페이지
        }
    }

    // 홈 페이지 (로그인 후 이동)
    @GetMapping("/home")
    public String homePage(HttpSession session, Model model) {
        String loginUser = (String) session.getAttribute("loginUser");

        if (loginUser == null) {
            return "redirect:loginPage/login"; // 로그인되지 않았다면 로그인 페이지로 이동
        }

        model.addAttribute("loginUser", loginUser);
        return "home"; // WEB-INF/views/home.jsp
    }

    // 회원가입 페이지 반환 (JSP)
    @GetMapping("login/sign-up")
    public String signUpForm() {
        return "loginPage/signUp"; // WEB-INF/views/signUp.jsp
    }

    // 회원가입 처리
    @PostMapping("login/sign-up")
    public String signUp(@ModelAttribute SignUpRequestDTO dto) {
        log.info("회원가입 요청: {}", dto.getId());
        memberService.save(dto);
        return "redirect:loginPage/login"; // 회원가입 후 로그인 페이지로 이동
    }

    // AJAX로 아이디 중복 여부 처리
    @GetMapping("/checkId")
    @ResponseBody
    public String checkId(@RequestParam("id") String id) {
        boolean isAvailable = memberService.isIdAvailable(id);
        return isAvailable ? "available" : "unavailable";
    }

    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화(로그아웃)
        log.info("로그아웃 성공!");
        return "redirect:loginPage/login"; // 로그인 페이지로 이동
    }

    // 아이디 찾기 페이지 이동
    @GetMapping("/find-id")
    public String findIdPage() {
        return "findId";
    }

    //아이디 찾기 페이지 이동
    @PostMapping("find-id")
    public List<String> findId(@RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber, Model model){
        List<String> findId = memberService.findIdByEmailAndPhoneNumber(email, phoneNumber);

        if(findId != null){
            model.addAttribute("findId", findId);
        }else{
            model.addAttribute("errorMessage", "해당 이메일 또는 휴대폰 번호로 등록된 아이디가 없습니다.");
        }
        return findId;
    }
}
