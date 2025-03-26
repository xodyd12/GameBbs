package org.example.demo.companyProfile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mainPage") // URL prefix 설정
public class ComPanyProfileController {

    // 회사 소개 페이지로 이동
    @GetMapping("/companyProfile")
    public String loginPage() {
        return "companyProfile/companyProfile"; // WEB-INF/views/mainPage/CompanyProfile.jsp
    }
}
