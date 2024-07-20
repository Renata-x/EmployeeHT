package cn.xll.employmentanalysis.service.impl;

import cn.xll.employmentanalysis.pojo.dto.BigdataDemandDto;
import cn.xll.employmentanalysis.pojo.vo.BigdataDemandListVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xll.employmentanalysis.pojo.entity.BigdataDemandSalary;
import cn.xll.employmentanalysis.mapper.BigdataDemandSalaryMapper;
import cn.xll.employmentanalysis.service.BigdataDemandSalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BigdataDemandSalaryServiceImpl extends ServiceImpl<BigdataDemandSalaryMapper, BigdataDemandSalary> implements BigdataDemandSalaryService {
    private final BigdataDemandSalaryMapper bigdataDemandSalaryMapper;
    @Override
    public List<BigdataDemandSalary> queryAll() {
        return bigdataDemandSalaryMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public BigdataDemandListVo getBigdataDemand() {
        LambdaQueryWrapper<BigdataDemandSalary> lqw = new LambdaQueryWrapper<>();

        List<BigdataDemandSalary> bigdataDemandSalaries = bigdataDemandSalaryMapper.selectList(lqw);

        BigdataDemandListVo bigdataDemandListVo = new BigdataDemandListVo();

        for(BigdataDemandSalary bigdataDemandSalary:bigdataDemandSalaries){
            BigdataDemandDto bigdataDemandDto = new BigdataDemandDto();
            bigdataDemandDto.setName(bigdataDemandSalary.getDemand());
            bigdataDemandDto.setValue(bigdataDemandSalary.getAverageSalary());

            bigdataDemandListVo.add(bigdataDemandDto);
        }
        return bigdataDemandListVo;
    }
}
