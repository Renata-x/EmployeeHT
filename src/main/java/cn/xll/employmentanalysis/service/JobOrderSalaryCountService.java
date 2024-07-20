package cn.xll.employmentanalysis.service;

import cn.xll.employmentanalysis.pojo.entity.JobOrderSalaryCount;
import cn.xll.employmentanalysis.pojo.vo.JavaOrderSalaryListVo;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

public interface JobOrderSalaryCountService extends IService<JobOrderSalaryCount> {
    List<JobOrderSalaryCount> queryAll();

    JavaOrderSalaryListVo getJavaOrderSalary();
}
