package cn.xll.employmentanalysis.pojo.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SalaryRankVoList {
    private List<SalaryRankVo> salaryRankVos;

    public SalaryRankVoList() {
        this.salaryRankVos = new ArrayList<>(); // 初始化列表
    }
    public void add(SalaryRankVo salaryRankVo) {
        salaryRankVos.add(salaryRankVo);
    }
}
