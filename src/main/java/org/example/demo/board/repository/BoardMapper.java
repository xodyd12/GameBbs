package org.example.demo.board.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.demo.board.entity.BoardVO;

import java.util.List;

@Mapper
public interface BoardMapper {

    //게시물 등록
    void saveBoard (BoardVO board);

    //게시물 조회
    List<BoardVO> findAll();

}
