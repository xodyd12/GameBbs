package org.example.demo.board.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.board.dto.request.BoardRequestDTO;
import org.example.demo.board.dto.response.BoardResponseDTO;
import org.example.demo.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mainPage") // URL prefix 설정
public class BoardController {

    private final BoardService boardService;

    // 글 저장 처리 (POST)
    @PostMapping("/write")
    public String saveBoard(@ModelAttribute BoardRequestDTO dto, HttpSession session) {
        String writerId = (String) session.getAttribute("loginUser"); // 로그인된 사용자 ID 가져오기

        if (writerId == null) {
            // 로그인 안 되어 있으면 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }
        boardService.saveBoard(dto, writerId);
        return "redirect:/mainPage/list"; // 저장 후 목록 페이지로 이동
    }

    @GetMapping("/list")
    @ResponseBody // ✅ JSON 형태로 응답
    public List<BoardResponseDTO> getBoardList() {
        return boardService.findAll();
    }

}
