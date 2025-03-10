package org.example.demo.member.entity;

import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberVO {

    private String id; //유저 ID
    private String password; //유저 패스워드
    private String phoneNumber; //유저 폰 번호
    private String email; // 유저 이메일
    private LocalDateTime createdAt; //유저 생성 일자

}
