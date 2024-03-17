package com.catdog.care.emp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;


@Data
@Entity
@Schema(description = "Emp Table에 대한 내용입니다.")
public class Emp {
    @Id
    @Column(nullable = false)
    @Schema(title = "사원번호", description = "사원번호는 정수 타입입니다.")
    private Integer empno;

    @Column(length = 10)
    @Schema(title = "사원이름", description = "사원이름은 문자 타입입니다.")
    private String ename;

    @Schema(title = "부서", description = "부서는 문자 타입입니다.")
    private String job;

    @Schema(title = "매니저 사원번호", description = "매니저 사원번호는 정수 타입입니다.")
    private Integer mgr;

    @Schema(title = "입사날짜", description = "yyyy/MM/dd 형식입니다.")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date hiredate;

    @Schema(title = "연봉", description = "연봉은 실수 타입입니다.")
    private Double sal;

    @Schema(title = "보너스", description = "보너스는 실수 타입입니다.")
    private Double comm;

    @Schema(title = "부서번호", description = "부서번호는 정수 타입입니다.")
    private Integer deptno;
}
