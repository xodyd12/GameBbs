package org.example.demo.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.board.dto.request.BoardRequestDTO;
import org.example.demo.board.dto.response.BoardResponseDTO;
import org.example.demo.board.entity.BoardVO;
import org.example.demo.board.repository.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    //글 저장
    public void saveBoard(BoardRequestDTO dto, String writerId){
        BoardVO boardVO = BoardVO.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writerId(writerId)
                .build();

        boardMapper.saveBoard(boardVO);

    }

    //글 조회
    public List<BoardResponseDTO> findAll(){
        List<BoardVO> boardList = boardMapper.findAll();
        return boardList.stream()
                .map(vo -> BoardResponseDTO.builder()
                        .boardId(vo.getBoardId())
                        .title(vo.getTitle())
                        .content(vo.getContent())
                        .writerId(vo.getWriterId()) // 여기에는 닉네임이 들어있음
                        .createdAt(vo.getCreatedAt())
                        .viewCount((long) vo.getViewCount())
                        .build())
                .collect(Collectors.toList());
    }

}
