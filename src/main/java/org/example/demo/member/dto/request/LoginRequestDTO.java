package org.example.demo.member.dto.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class LoginRequestDTO {

    private String id;
    private String password;

}
