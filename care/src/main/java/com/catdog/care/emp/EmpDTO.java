package com.catdog.care.emp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class EmpDTO {
    //@Pattern(regexp="\\d{2,4}", message="사원번호는 2자에서 4자 사이의 숫자여야 합니다.")
    private Integer empno;

    @NotBlank(message = "사원명은 필수 입력값입니다.")
    @Size(min = 2, max = 10, message = "사원명은 최소 2글자 이상 ~ 10글자 이상 입력해야합니다.")
    private String ename;

    @Size(max = 9)
    @Pattern(regexp="^[a-zA-Z]+$", message="영어만 사용이 가능합니다.")
    private String job;

    @Min(0) // 양수확인
    private Integer mgr;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date hiredate;

    @Min(0)
    private Double sal;

    @Min(0)
    private Double comm;

    @Min(0)
    private Integer deptno;
}
