package org.example.demo.board.dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class BoardResponseDTO {

    private Long boardId;
    private String title;
    private String content;
    private String writerId; // 닉네임
    private Date createdAt;
    private Long viewCount;

}
