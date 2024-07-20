package cn.xll.employmentanalysis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xll.employmentanalysis.pojo.entity.AvgSalary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AvgSalaryMapper extends BaseMapper<AvgSalary> {
    List<AvgSalary> findAvgSalaryByConditions(@Param("jobName") String jobName);
    Page<AvgSalary> findAvgSalaryByConditions(Page<AvgSalary> page,@Param("jobName") String jobName);

}
