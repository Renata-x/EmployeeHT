package cn.xll.employmentanalysis.service.impl;

import cn.xll.employmentanalysis.pojo.dto.JavaDemandDto;
import cn.xll.employmentanalysis.pojo.vo.JavaDemandListVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xll.employmentanalysis.pojo.entity.JavaDemandSalary;
import cn.xll.employmentanalysis.mapper.JavaDemandSalaryMapper;
import cn.xll.employmentanalysis.service.JavaDemandSalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class JavaDemandServiceImpl extends ServiceImpl<JavaDemandSalaryMapper, JavaDemandSalary> implements JavaDemandSalaryService {
    private final JavaDemandSalaryMapper javaDemandSalaryMapper;
    @Override
    public List<JavaDemandSalary> queryAll() {
        return javaDemandSalaryMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public JavaDemandListVo getJavaDemand() {
        LambdaQueryWrapper<JavaDemandSalary> lqw = new LambdaQueryWrapper<>();

        List<JavaDemandSalary> javaDemandSalaries = javaDemandSalaryMapper.selectList(lqw);


        JavaDemandListVo javaDemandListVo = new JavaDemandListVo();

        for (JavaDemandSalary javaDemandSalary: javaDemandSalaries) {

            JavaDemandDto javaDemandDto = new JavaDemandDto();

            javaDemandDto.setName(javaDemandSalary.getDemand());

            javaDemandDto.setValue((int) javaDemandSalary.getAverageSalary());

            javaDemandListVo.add(javaDemandDto);
        }

        return javaDemandListVo;
    }
}
