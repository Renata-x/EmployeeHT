package cn.xll.employmentanalysis.service;

import cn.xll.employmentanalysis.pojo.entity.BigdataDemandSalary;
import cn.xll.employmentanalysis.pojo.vo.BigdataDemandListVo;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

public interface BigdataDemandSalaryService extends IService<BigdataDemandSalary> {
    List<BigdataDemandSalary> queryAll();

    BigdataDemandListVo getBigdataDemand();
}
