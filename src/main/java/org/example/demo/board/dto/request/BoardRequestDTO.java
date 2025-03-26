package org.example.demo.board.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class BoardRequestDTO {
    private String title;
    private String content;
    private String writerId;
}
