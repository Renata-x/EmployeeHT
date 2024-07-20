package cn.xll.employmentanalysis.pojo.vo;


import cn.xll.employmentanalysis.pojo.dto.JavaDemandDto;
import cn.xll.employmentanalysis.pojo.dto.JavaOrderSalaryDto;
import cn.xll.employmentanalysis.pojo.dto.MaxMinSalaryDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JavaOrderSalaryListVo {
    private List<JavaOrderSalaryDto> javaOrderSalaryDtos;

    public JavaOrderSalaryListVo() {
        this.javaOrderSalaryDtos = new ArrayList<>();
    }

    public void add(JavaOrderSalaryDto javaOrderSalaryDto) {
        this.javaOrderSalaryDtos.add(javaOrderSalaryDto);
    }
}
