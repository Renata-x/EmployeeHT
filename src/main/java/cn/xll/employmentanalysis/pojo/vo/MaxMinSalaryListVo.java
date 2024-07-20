package cn.xll.employmentanalysis.pojo.vo;

import cn.xll.employmentanalysis.pojo.dto.JavaDemandDto;
import cn.xll.employmentanalysis.pojo.dto.MaxMinSalaryDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class MaxMinSalaryListVo {
    private List<MaxMinSalaryDto> maxMinSalaryDtos;

    public MaxMinSalaryListVo() {
        this.maxMinSalaryDtos = new ArrayList<>();
    }

    public void add(MaxMinSalaryDto maxMinSalaryDto) {
        this.maxMinSalaryDtos.add(maxMinSalaryDto);
    }
}
