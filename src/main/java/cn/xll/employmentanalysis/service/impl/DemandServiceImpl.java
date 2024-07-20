package cn.xll.employmentanalysis.service.impl;

import cn.xll.employmentanalysis.mapper.ChinaJobCountMapper;
import cn.xll.employmentanalysis.mapper.DemandMapper;
import cn.xll.employmentanalysis.pojo.entity.ChinaJobCount;
import cn.xll.employmentanalysis.pojo.entity.ShangDemand;
import cn.xll.employmentanalysis.pojo.vo.ShangDemandVo;
import cn.xll.employmentanalysis.service.DemandService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class DemandServiceImpl  extends ServiceImpl<DemandMapper, ShangDemand> implements DemandService {
    private final DemandMapper demandMapper;
    @Override
    public List<ShangDemandVo> get() {
        LambdaQueryWrapper<ShangDemand> lqw = new LambdaQueryWrapper<>();
        List<ShangDemand> shangDemands = demandMapper.selectList(lqw);
        List<ShangDemandVo> shangDemandVos = new ArrayList<>();

        for (ShangDemand shangDemand: shangDemands) {
            ShangDemandVo shangDemandVo = new ShangDemandVo();

            shangDemandVo.setName(shangDemand.getDemand());
            shangDemandVo.setMax(shangDemand.getJobCount());

            shangDemandVos.add(shangDemandVo);
        }

        return shangDemandVos;
    }
}
