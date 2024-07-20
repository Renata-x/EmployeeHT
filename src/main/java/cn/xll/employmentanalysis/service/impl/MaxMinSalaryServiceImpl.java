package cn.xll.employmentanalysis.service.impl;

import cn.xll.employmentanalysis.pojo.dto.MaxMinSalaryDto;
import cn.xll.employmentanalysis.pojo.dto.ShanghaiJobCountDto;
import cn.xll.employmentanalysis.pojo.entity.JobCount;
import cn.xll.employmentanalysis.pojo.vo.MaxMinSalaryListVo;
import cn.xll.employmentanalysis.pojo.vo.ShanghaiJobCountListVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xll.employmentanalysis.pojo.entity.MaxMinSalary;
import cn.xll.employmentanalysis.mapper.MaxMinSalaryMapper;
import cn.xll.employmentanalysis.service.MaxMinSalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaxMinSalaryServiceImpl extends ServiceImpl<MaxMinSalaryMapper, MaxMinSalary> implements MaxMinSalaryService {
    private  final MaxMinSalaryMapper maxMinSalaryMapper;
    @Override
    public List<MaxMinSalary> findMaxMinSalaryByConditions(String jobName, String companyLocal) {

        return maxMinSalaryMapper.findMaxMinSalaryByConditions(jobName, companyLocal);
    }

    @Override
    public Page<MaxMinSalary> findPage(int pageNum, int pageSize, String jobName, String companyLocal) {
        Page<MaxMinSalary> page =  new Page<>(pageNum, pageSize);
        Page<MaxMinSalary> maxMinSalaryPage = maxMinSalaryMapper.findMaxMinSalaryByConditions(page, jobName, companyLocal);
        return maxMinSalaryPage;
    }

    @Override
    public MaxMinSalaryListVo getJobMaxMin() {
        LambdaQueryWrapper<MaxMinSalary> lqw = new LambdaQueryWrapper<>();

        List<MaxMinSalary> maxMinSalaries = maxMinSalaryMapper.selectList(lqw);

        MaxMinSalaryListVo maxMinSalaryListVo = new MaxMinSalaryListVo();

        for (MaxMinSalary maxMinSalary:maxMinSalaries) {
            MaxMinSalaryDto maxMinSalaryDto = new MaxMinSalaryDto();

            maxMinSalaryDto.setName(maxMinSalary.getJobName());
            maxMinSalaryDto.setMax(maxMinSalary.getMaxSalary());
            maxMinSalaryDto.setMin(maxMinSalary.getMinSalary());
            maxMinSalaryListVo.add(maxMinSalaryDto);
        }

        return maxMinSalaryListVo;

    }
}
