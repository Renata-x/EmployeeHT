package cn.xll.employmentanalysis.service;

import cn.xll.employmentanalysis.pojo.vo.JavaDemandListVo;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.xll.employmentanalysis.pojo.entity.JavaDemandSalary;

import java.util.List;

public interface JavaDemandSalaryService extends IService<JavaDemandSalary> {
    List<JavaDemandSalary> queryAll();

    JavaDemandListVo getJavaDemand();
}
