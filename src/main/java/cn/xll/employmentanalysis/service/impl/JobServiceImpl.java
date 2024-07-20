package cn.xll.employmentanalysis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xll.employmentanalysis.pojo.entity.Job;
import cn.xll.employmentanalysis.mapper.JobMapper;
import cn.xll.employmentanalysis.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {
    private final JobMapper jobMapper;

    @Override
    public int addJob(Job job) {
        return jobMapper.insert(job);
    }

    @Override
    public Page<Job> page(int pageNum, int pageSize, Job job) {
        Page<Job> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Job> queryWrapper = new QueryWrapper<>();
        return jobMapper.selectPage(page, queryWrapper);

    }

    @Override
    public List<Job> queryAll() {
        return jobMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public List<Job> findJobByConditions(String jobName, String workDemand, String demand,String companyName, String companyLocal) {


        return jobMapper.findJobByConditions(jobName, workDemand, demand, companyName, companyLocal);
    }

    @Override
    public Page<Job> findPage(int pageNum, int pageSize, String jobName, String workDemand, String demand, String companyName, String companyLocal) {
        Page<Job> page = new Page<>(pageNum, pageSize);
        Page<Job> jobPage = jobMapper.findJobByConditions(page, jobName,workDemand, demand, companyName, companyLocal);
        return jobPage;
    }

    @Override
    public int deleteById(String id) {
        return jobMapper.deleteById(id);
    }

    @Override
    public int updateJob(Job job) {
        return jobMapper.update(job);
    }

}
