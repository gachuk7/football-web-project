package com.example.footballwebproject.user.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
public class SignupRequestDto {
    @Size(max = 10, min = 4, message = "최소 4자 이상, 10자 이하이어야 합니다.")
    @Pattern(regexp="^[a-z\\d]*$",message = "알파벳 소문자(a~z), 숫자(0~9)로 구성되어야합니다.")
    private String username;

    @Size(max = 15, min = 8, message = "최소 8자 이상, 15자 이하여야 합니다.")
    @Pattern(regexp="^[a-zA-Z\\d@$!%*#?&]*$",message = "비밀번호는 알파벳 대소문자, 숫자, 특수문자로 구성되어야합니다.")
    private String password;
}