package org.example.demo.member.dto.request;

import lombok.*;
import org.example.demo.config.SecurityConfig;
import org.example.demo.member.entity.MemberVO;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class SignUpRequestDTO {

    private String id;
    private String password;
    private String phoneNumber;
    private String email;
    private String nickName;
    //엔터티로 변환하는 유틸 메서드
    public MemberVO toEntity(PasswordEncoder encoder){
        return MemberVO.builder()
                .id(id)
                .password(encoder.encode(this.password))
                .phoneNumber(phoneNumber)
                .email(email)
                .nickName(nickName)
                .build();
    }
}
