package cn.xll.employmentanalysis.service.impl;

import cn.xll.employmentanalysis.mapper.AvgSalaryMapper;
import cn.xll.employmentanalysis.mapper.ShangAvgSalaryMapper;
import cn.xll.employmentanalysis.mapper.ShangSalaryMapper;
import cn.xll.employmentanalysis.pojo.entity.ShangAvgSalary;
import cn.xll.employmentanalysis.pojo.entity.ShangSalary;
import cn.xll.employmentanalysis.pojo.vo.SalaryRankVo;
import cn.xll.employmentanalysis.pojo.vo.SalaryRankVoList;
import cn.xll.employmentanalysis.service.ShangSalaryService;
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
public class ShangSalaryServiceImpl extends ServiceImpl<ShangSalaryMapper, ShangSalary> implements ShangSalaryService {
    ShangSalaryMapper shangSalaryMapper;
}


