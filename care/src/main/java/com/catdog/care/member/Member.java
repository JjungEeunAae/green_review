package com.catdog.care.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;


@Data
@Entity
@Schema(description = "Member Table에 대한 내용입니다.")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Member {
    //@JsonFormat(pattern = "yyyy/MM/dd")
    @Id
    @Column(length = 50, nullable = false)
    @Schema(title = "유저 아이디", description = "유저의 고유한 아이디입니다.")
    private String id;

    @Column(length = 100)
    @Schema(title = "유저 패스워드", description = "유저 아이디에 대한 패스워드입니다.")
    private String password;

    @Column(length = 50, nullable = false)
    @Schema(title = "유저 닉네임", description = "유저 닉네임입니다.")
    private String nickname;

    @Column(length = 50)
    @Schema(title = "유저 이름", description = "유저 이름입니다.")
    private String name;

    @Column(length = 10)
    @Schema(title = "유저 이름", description = "유저 이름입니다.")
    private String resign_yn;
}
