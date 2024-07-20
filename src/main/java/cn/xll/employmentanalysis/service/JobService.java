package cn.xll.employmentanalysis.service;

import cn.xll.employmentanalysis.pojo.entity.Job;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;
public interface JobService extends IService<Job> {
    int addJob(Job job);
    Page<Job> page(int pageNum, int pageSize, Job job);
    List<Job> queryAll();

    List<Job> findJobByConditions(String jobName, String workDemand, String demand,String companyName, String companyLocal);
    Page<Job> findPage(int pageNum, int pageSize, String jobName, String workDemand, String demand,String companyName, String companyLocal);

    int deleteById(String id);
    int updateJob(Job job);
}
