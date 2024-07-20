package cn.xll.employmentanalysis.service.impl;

import cn.xll.employmentanalysis.mapper.AvgSalaryMapper;
import cn.xll.employmentanalysis.mapper.ShangAvgSalaryMapper;
import cn.xll.employmentanalysis.pojo.entity.ShangAvgSalary;
import cn.xll.employmentanalysis.pojo.vo.SalaryRankVo;
import cn.xll.employmentanalysis.pojo.vo.SalaryRankVoList;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xll.employmentanalysis.pojo.entity.AvgSalary;
import cn.xll.employmentanalysis.service.AvgSalaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.phoenix.shaded.org.apache.commons.collections.list.SynchronizedList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvgSalaryServiceImpl extends ServiceImpl<AvgSalaryMapper, AvgSalary> implements AvgSalaryService {

    private final AvgSalaryMapper avgSalaryMapper;
    private final ShangAvgSalaryMapper shangAvgSalaryMapper;
    @Override
    public List<AvgSalary> findAvgSalaryByConditions(String jobName) {
        return avgSalaryMapper.findAvgSalaryByConditions(jobName);
    }

    @Override
    public Page<AvgSalary> page(int pageNum, int pageSize, String jobName) {
        Page<AvgSalary> avgSalaryPage = new Page<>(pageNum, pageSize);
        Page<AvgSalary> avgSalaryList = avgSalaryMapper.findAvgSalaryByConditions(avgSalaryPage, jobName);
        return avgSalaryList;
    }

    @Override
    public List<AvgSalary> getAll() {
        LambdaQueryWrapper<AvgSalary> lqw = new LambdaQueryWrapper<>();

        return avgSalaryMapper.selectList(lqw);
    }

    @Override
    public SalaryRankVoList getSalaryRank() {

        LambdaQueryWrapper<AvgSalary> lqw = new LambdaQueryWrapper<>();

        List<AvgSalary> avgSalaries = avgSalaryMapper.selectList(lqw);
        SalaryRankVoList salaryRankVoList = new SalaryRankVoList();


        for (AvgSalary avgSalary: avgSalaries) {
            SalaryRankVo salaryRankVo = new SalaryRankVo();
            salaryRankVo.setName(avgSalary.getJobName());
            Double averageJobSalary = avgSalary.getAverageJobSalary();
//            int i = averageJobSalary.intValue();
            salaryRankVo.setValue(averageJobSalary);

            salaryRankVoList.add(salaryRankVo);
        }

        return salaryRankVoList;
    }



    @Override
    public SalaryRankVoList getShangSalaryRank() {

        LambdaQueryWrapper<ShangAvgSalary> lqw = new LambdaQueryWrapper<>();

        List<ShangAvgSalary> avgSalaries = shangAvgSalaryMapper.selectList(lqw);
        SalaryRankVoList salaryRankVoList = new SalaryRankVoList();


        for (ShangAvgSalary shangAvgSalary : avgSalaries) {
            SalaryRankVo salaryRankVo = new SalaryRankVo();
            salaryRankVo.setName(shangAvgSalary.getJobName());
            Double averageJobSalary = shangAvgSalary.getAverageJobSalary();
            //            int i = averageJobSalary.intValue();
            salaryRankVo.setValue(averageJobSalary);

            salaryRankVoList.add(salaryRankVo);
        }

        return salaryRankVoList;
    }

}
