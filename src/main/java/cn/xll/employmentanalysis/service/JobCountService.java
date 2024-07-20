package cn.xll.employmentanalysis.service;

import cn.xll.employmentanalysis.pojo.entity.JobCount;
import cn.xll.employmentanalysis.pojo.vo.ChengJobCountListVo;
import cn.xll.employmentanalysis.pojo.vo.GuangJobCountListVo;
import cn.xll.employmentanalysis.pojo.vo.ShanghaiJobCountListVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

public interface JobCountService extends IService<JobCount> {
    List<JobCount> findJobCountByConditions(String jobName, String companyLocal, String order);
    Page<JobCount> findPage(int pageNum, int pageSize, String jobName, String companyLocal, String order);
    ShanghaiJobCountListVo getShangJobCount();

    GuangJobCountListVo getGuangJobCount();

    ChengJobCountListVo getChengJobCount();
}
