package com.catdog.care.emp;

import com.catdog.care.exception.EmpExcption;
import com.catdog.care.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpService {
    private final EmpRepository empRepository;

    public List<Emp> empAllList() {
        List<Emp> list = empRepository.findAll();
        System.out.println(list);
        return list;
    }

    public Optional<Emp> empDetail(int empno) {
        Optional<Emp> emp = empRepository.findById(empno);

        if(emp.isEmpty()) {
            throw new EmpExcption(ErrorCode.NOT_FOUND);
        }

        return emp;
    }

    public Emp addEmp(Emp reqEmp) {
        Optional<Emp> emp = empRepository.findById(reqEmp.getEmpno());
        if(!emp.isEmpty()) {
            throw new EmpExcption(ErrorCode.DUPLICATE);
        }
        Emp dbemp = empRepository.save(reqEmp);
        return dbemp;
    }
}
