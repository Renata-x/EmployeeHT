package cn.xll.employmentanalysis.service;

import cn.xll.employmentanalysis.pojo.entity.AvgSalary;
import cn.xll.employmentanalysis.pojo.vo.SalaryRankVo;
import cn.xll.employmentanalysis.pojo.vo.SalaryRankVoList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

public interface AvgSalaryService extends IService<AvgSalary> {
    List<AvgSalary> findAvgSalaryByConditions(String jobName);
    Page<AvgSalary> page(int pageNum, int pageSize,String jobName);

    List<AvgSalary> getAll();

    SalaryRankVoList getSalaryRank();

    SalaryRankVoList getShangSalaryRank();
}
