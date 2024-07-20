package cn.xll.employmentanalysis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xll.employmentanalysis.pojo.entity.JobCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface JobCountMapper extends BaseMapper<JobCount> {
    List<JobCount> findJobCountByConditions(@Param("jobName") String jobName, @Param("companyLocal") String companyLocal, @Param("order") String order);
    Page<JobCount> findJobCountByConditions(Page<JobCount> page, @Param("jobName") String jobName, @Param("companyLocal") String companyLocal, @Param("order") String order);
}
