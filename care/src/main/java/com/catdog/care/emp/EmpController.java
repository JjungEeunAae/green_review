package com.catdog.care.emp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("emp")
@Tag(name = "Emp-Controller", description = "사원 조회, 등록, 수정, 삭제")
public class EmpController {
    private final EmpService service;

    @Operation(summary = "사원 전체 목록 조회"
            , description = "사원 전체 정보를 확인할 수 있습니다.")
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "정상적으로 실행된 코드"),
                    @ApiResponse(responseCode = "404", description = "사원 정보가 없을 때 나오는 코드")
            }
    )
    @GetMapping()
    public List<Emp> allEMP() {
        return service.empAllList();
    }

    @Operation(summary = "사원 단건 조회"
            , description = "사원 정보를 확인할 수 있습니다.")
    @Parameters(
            @Parameter(
                    description = "사원번호를 입력해주세요",
                    name = "empno",
                    required = true
            )
    )
    @GetMapping("{empno}")
    public Optional<Emp> getUserById(@Valid @PathVariable int empno) {
	    return service.empDetail(empno);
    }

    @PostMapping()
    public Emp addEmp(@Valid @RequestBody EmpDTO empDTO) {
        Date currentDate = new Date();
        ModelMapper mapper = new ModelMapper();
        Emp emp = mapper.map(empDTO, Emp.class);
        emp.setHiredate(currentDate);

        Emp dbEmp = service.addEmp(emp);

        return dbEmp;
    }
}
