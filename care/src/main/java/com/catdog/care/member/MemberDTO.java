package com.catdog.care.member;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    @NotBlank(message = "필수 입력 값")
    @Size(min = 2, max = 50, message = "아이디는 최소 2글자 이상 ~ 50글자 이하로 입력해야합니다.")
    private String id;

    @Size(max = 100)
    private String password;

    @Size(max = 50)
    private String nickname;

    @Size(max = 50)
    private String name;

    @Size(max = 10)
    private String resign_yn;
}
//    @Pattern(regexp="^[a-zA-Z]+$", message="영어만 사용이 가능합니다.")
//    @Min(0) // 양수확인
//    private Integer mgr;
//    @JsonFormat(pattern = "yyyy/MM/dd")
//    private Date hiredate;
