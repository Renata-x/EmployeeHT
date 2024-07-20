package cn.xll.employmentanalysis.service.impl;

import cn.xll.employmentanalysis.pojo.dto.JavaOrderSalaryDto;
import cn.xll.employmentanalysis.pojo.dto.MaxMinSalaryDto;
import cn.xll.employmentanalysis.pojo.entity.MaxMinSalary;
import cn.xll.employmentanalysis.pojo.vo.JavaOrderSalaryListVo;
import cn.xll.employmentanalysis.pojo.vo.MaxMinSalaryListVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xll.employmentanalysis.pojo.entity.JobOrderSalaryCount;
import cn.xll.employmentanalysis.mapper.JobOrderSalaryCountMapper;
import cn.xll.employmentanalysis.service.JobOrderSalaryCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class JobOrderSalaryCountServiceImpl extends ServiceImpl<JobOrderSalaryCountMapper, JobOrderSalaryCount> implements JobOrderSalaryCountService {
    private final JobOrderSalaryCountMapper jobOrderSalaryCountMapper;

    @Override
    public List<JobOrderSalaryCount> queryAll() {
        return jobOrderSalaryCountMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public JavaOrderSalaryListVo getJavaOrderSalary() {
        LambdaQueryWrapper<JobOrderSalaryCount> lqw = new LambdaQueryWrapper<>();

        List<JobOrderSalaryCount> jobOrderSalaryCounts = jobOrderSalaryCountMapper.selectList(lqw);

        JavaOrderSalaryListVo javaOrderSalaryListVo = new JavaOrderSalaryListVo();

        for (JobOrderSalaryCount jobOrderSalaryCount:jobOrderSalaryCounts) {
            JavaOrderSalaryDto javaOrderSalaryDto = new JavaOrderSalaryDto();
            javaOrderSalaryDto.setSalary(jobOrderSalaryCount.getJobSalary());
            javaOrderSalaryDto.setValue(jobOrderSalaryCount.getJobSalaryCount());
            javaOrderSalaryListVo.add(javaOrderSalaryDto);
        }

        return javaOrderSalaryListVo;
    }
}
