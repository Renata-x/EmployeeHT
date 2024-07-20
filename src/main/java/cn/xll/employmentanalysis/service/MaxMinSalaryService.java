package cn.xll.employmentanalysis.service;

import cn.xll.employmentanalysis.pojo.entity.MaxMinSalary;
import cn.xll.employmentanalysis.pojo.vo.MaxMinSalaryListVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

public interface MaxMinSalaryService extends IService<MaxMinSalary> {
    List<MaxMinSalary> findMaxMinSalaryByConditions(String jobName, String companyLocal);

    Page<MaxMinSalary> findPage(int pageNum, int pageSize, String jobName, String companyLocal);

    MaxMinSalaryListVo getJobMaxMin();
}
