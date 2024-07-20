package cn.xll.employmentanalysis.service.impl;

import cn.xll.employmentanalysis.mapper.ChengJobCountMapper;
import cn.xll.employmentanalysis.mapper.GuangJobCountMapper;
import cn.xll.employmentanalysis.pojo.dto.ChengJobCountDto;
import cn.xll.employmentanalysis.pojo.dto.GuangJobCountDto;
import cn.xll.employmentanalysis.pojo.dto.ShanghaiJobCountDto;
import cn.xll.employmentanalysis.pojo.entity.ChengJobCount;
import cn.xll.employmentanalysis.pojo.entity.GuangJobCount;
import cn.xll.employmentanalysis.pojo.vo.ChengJobCountListVo;
import cn.xll.employmentanalysis.pojo.vo.GuangJobCountListVo;
import cn.xll.employmentanalysis.pojo.vo.ShanghaiJobCountListVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xll.employmentanalysis.pojo.entity.JobCount;
import cn.xll.employmentanalysis.mapper.JobCountMapper;
import cn.xll.employmentanalysis.service.JobCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobCountServiceImpl extends ServiceImpl<JobCountMapper, JobCount>  implements JobCountService {
    private final JobCountMapper jobCountMapper;
    private final GuangJobCountMapper guangJobCountMapper;
    private final ChengJobCountMapper chengJobCountMapper;

    @Override
    public List<JobCount> findJobCountByConditions(String jobName, String companyLocal, String order) {
        return jobCountMapper.findJobCountByConditions(jobName, companyLocal, order);
    }

    @Override
    public Page<JobCount> findPage(int pageNum, int pageSize, String jobName, String companyLocal, String order) {
        Page<JobCount> page = new Page<>(pageNum, pageSize);
        Page<JobCount> jobCountPage = jobCountMapper.findJobCountByConditions(page, jobName, companyLocal, order);
        return jobCountPage;
    }

    public ShanghaiJobCountListVo getShangJobCount() {
        LambdaQueryWrapper<JobCount> lqw = new LambdaQueryWrapper<>();

        List<JobCount> jobCounts = jobCountMapper.selectList(lqw);

        ShanghaiJobCountListVo shanghaiJobCountList = new ShanghaiJobCountListVo();

        for (JobCount jobCount: jobCounts) {
            ShanghaiJobCountDto shanghaiJobCount = new ShanghaiJobCountDto();

            shanghaiJobCount.setName(jobCount.getJobName());
            shanghaiJobCount.setValue((int) jobCount.getJobCount());

            shanghaiJobCountList.add(shanghaiJobCount);
        }

        return shanghaiJobCountList;
    }

    @Override
    public GuangJobCountListVo getGuangJobCount() {

        LambdaQueryWrapper<GuangJobCount> lqw = new LambdaQueryWrapper<>();

        List<GuangJobCount> guangJobCounts = guangJobCountMapper.selectList(lqw);

        GuangJobCountListVo guangJobCountListVo = new GuangJobCountListVo();

        for (GuangJobCount guangJobCount:guangJobCounts) {
            GuangJobCountDto guangJobCountDto = new GuangJobCountDto();
            guangJobCountDto.setName(guangJobCount.getJobName());
            guangJobCountDto.setValue((int) guangJobCount.getJobCount());

            guangJobCountListVo.add(guangJobCountDto);
        }

        return guangJobCountListVo;
    }

    @Override
    public ChengJobCountListVo getChengJobCount() {
        LambdaQueryWrapper<ChengJobCount> lqw = new LambdaQueryWrapper<>();

        List<ChengJobCount> chengJobCounts = chengJobCountMapper.selectList(lqw);

        ChengJobCountListVo chengJobCountListVo = new ChengJobCountListVo();

        for (ChengJobCount chengJobCount:chengJobCounts) {
            ChengJobCountDto chengJobCountDto = new ChengJobCountDto();
            chengJobCountDto.setName(chengJobCount.getJobName());
            chengJobCountDto.setValue((int) chengJobCount.getJobCount());


            chengJobCountListVo.add(chengJobCountDto);
        }

        return chengJobCountListVo;
    }

}

