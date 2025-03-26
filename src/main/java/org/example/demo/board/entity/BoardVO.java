package org.example.demo.board.entity;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BoardVO {
    private Long boardId;
    private String title;
    private String content;
    private String writerId;
    private Date createdAt;
    private int viewCount;
}
