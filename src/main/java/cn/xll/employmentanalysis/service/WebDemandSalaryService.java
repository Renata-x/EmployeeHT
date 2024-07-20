package cn.xll.employmentanalysis.service;

import cn.xll.employmentanalysis.pojo.entity.WebDemandSalary;
import cn.xll.employmentanalysis.pojo.vo.WebDemandListVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface WebDemandSalaryService extends IService<WebDemandSalary> {
    List<WebDemandSalary> queryAll();

    WebDemandListVo getWebDemand();
}
