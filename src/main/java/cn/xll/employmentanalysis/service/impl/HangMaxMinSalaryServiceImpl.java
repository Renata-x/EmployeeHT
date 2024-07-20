package cn.xll.employmentanalysis.service.impl;

import cn.xll.employmentanalysis.mapper.HangMaxMinSalaryMapper;
import cn.xll.employmentanalysis.pojo.dto.HangMaxMinSalaryDto;
import cn.xll.employmentanalysis.pojo.dto.MaxMinSalaryDto;
import cn.xll.employmentanalysis.pojo.dto.ShanghaiJobCountDto;
import cn.xll.employmentanalysis.pojo.entity.HangMaxMinSalary;
import cn.xll.employmentanalysis.pojo.entity.JobCount;
import cn.xll.employmentanalysis.pojo.vo.HangMaxMinSalaryListVo;
import cn.xll.employmentanalysis.pojo.vo.MaxMinSalaryListVo;
import cn.xll.employmentanalysis.pojo.vo.ShanghaiJobCountListVo;
import cn.xll.employmentanalysis.service.HangMaxMinSalaryService;
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
public class HangMaxMinSalaryServiceImpl extends ServiceImpl<HangMaxMinSalaryMapper, HangMaxMinSalary> implements HangMaxMinSalaryService {
    private  final HangMaxMinSalaryMapper hangMaxMinSalaryMapper;


    @Override
    public HangMaxMinSalaryListVo getHangJobMaxMin() {
        LambdaQueryWrapper<HangMaxMinSalary> lqw = new LambdaQueryWrapper<>();

        List<HangMaxMinSalary> hangMaxMinSalarys = hangMaxMinSalaryMapper.selectList(lqw);

        HangMaxMinSalaryListVo hangMaxMinSalaryListVo = new HangMaxMinSalaryListVo();

        for (HangMaxMinSalary hangMaxMinSalary:hangMaxMinSalarys) {
            HangMaxMinSalaryDto hangMaxMinSalaryDto = new HangMaxMinSalaryDto();

            hangMaxMinSalaryDto.setName(hangMaxMinSalary.getJobName());
            hangMaxMinSalaryDto.setMax(hangMaxMinSalary.getMaxSalary());
            hangMaxMinSalaryDto.setMin(hangMaxMinSalary.getMinSalary());
            hangMaxMinSalaryListVo.add(hangMaxMinSalaryDto);
        }

        return hangMaxMinSalaryListVo;

    }
}
