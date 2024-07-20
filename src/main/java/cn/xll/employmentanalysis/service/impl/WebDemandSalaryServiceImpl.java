package cn.xll.employmentanalysis.service.impl;

import cn.xll.employmentanalysis.pojo.dto.JavaDemandDto;
import cn.xll.employmentanalysis.pojo.dto.WebDemandDto;
import cn.xll.employmentanalysis.pojo.entity.JavaDemandSalary;
import cn.xll.employmentanalysis.pojo.vo.JavaDemandListVo;
import cn.xll.employmentanalysis.pojo.vo.WebDemandListVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xll.employmentanalysis.pojo.entity.WebDemandSalary;
import cn.xll.employmentanalysis.mapper.WebDemandSalaryMapper;
import cn.xll.employmentanalysis.service.WebDemandSalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class WebDemandSalaryServiceImpl extends ServiceImpl<WebDemandSalaryMapper, WebDemandSalary> implements WebDemandSalaryService {
    private final WebDemandSalaryMapper webDemandSalaryMapper;
    @Override
    public List<WebDemandSalary> queryAll() {
        return webDemandSalaryMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public WebDemandListVo getWebDemand() {
        LambdaQueryWrapper<WebDemandSalary> lqw = new LambdaQueryWrapper<>();

        List<WebDemandSalary> webDemandSalaries = webDemandSalaryMapper.selectList(lqw);

        WebDemandListVo webDemandListVo = new WebDemandListVo();


        for (WebDemandSalary webDemandSalary:webDemandSalaries) {
            WebDemandDto webDemandDto = new WebDemandDto();
            webDemandDto.setName(webDemandSalary.getDemand());
            webDemandDto.setValue(webDemandSalary.getAverageSalary());
            webDemandListVo.add(webDemandDto);
        }

        return webDemandListVo;
    }
}
