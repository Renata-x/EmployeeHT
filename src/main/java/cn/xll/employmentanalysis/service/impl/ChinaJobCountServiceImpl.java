package cn.xll.employmentanalysis.service.impl;

import cn.xll.employmentanalysis.mapper.ChinaJobCountMapper;
import cn.xll.employmentanalysis.pojo.dto.ChinaJobCountDto;
import cn.xll.employmentanalysis.pojo.entity.ChinaJobCount;
import cn.xll.employmentanalysis.pojo.vo.ChinaJobCountListVo;
import cn.xll.employmentanalysis.service.ChinaJobCountService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChinaJobCountServiceImpl extends ServiceImpl<ChinaJobCountMapper, ChinaJobCount>  implements ChinaJobCountService {
    private final ChinaJobCountMapper chinajobCountMapper;


    @Override
    public ChinaJobCountListVo getChinaJobCount() {
        LambdaQueryWrapper<ChinaJobCount> lqw = new LambdaQueryWrapper<>();

        List<ChinaJobCount> chinaJobCounts = chinajobCountMapper.selectList(lqw);

       ChinaJobCountListVo chinaJobCountListVo = new ChinaJobCountListVo();

        for (ChinaJobCount chinajobCount: chinaJobCounts) {
            ChinaJobCountDto chinaJobCountDto = new ChinaJobCountDto();
            chinaJobCountDto.setName(chinajobCount.getCompanyLocal());
            chinaJobCountDto.setValue(chinajobCount.getJobCount());

            chinaJobCountListVo.add(chinaJobCountDto);
        }

        return chinaJobCountListVo;
    }
}

