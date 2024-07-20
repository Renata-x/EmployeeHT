package cn.xll.employmentanalysis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xll.employmentanalysis.pojo.entity.Job;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JobMapper extends BaseMapper<Job> {
    int insert(Job job);
    int update(Job job);
    List<Job> findJobByConditions(@Param("jobName") String jobName, @Param("workDemand") String workDemand,
                                  @Param("demand") String demand, @Param("companyName") String companyName,
                                  @Param("companyLocal") String companyLocal);

    Page<Job> findJobByConditions(Page<Job> page, @Param("jobName") String jobName, @Param("workDemand") String workDemand,
                                  @Param("demand") String demand, @Param("companyName") String companyName,
                                  @Param("companyLocal") String companyLocal);
}
