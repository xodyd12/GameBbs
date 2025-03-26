package org.example.demo.mainPage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainPageController {

    // 메인 페이지로 이동
    @GetMapping("/mainPage")
    public String loginPage() {
        return "mainPage/mainPage"; // WEB-INF/views/mainPage/mainPage.jsp
    }
}
