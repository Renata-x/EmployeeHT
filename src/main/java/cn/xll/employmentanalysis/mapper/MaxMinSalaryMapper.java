package cn.xll.employmentanalysis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xll.employmentanalysis.pojo.entity.MaxMinSalary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MaxMinSalaryMapper extends BaseMapper<MaxMinSalary> {
    List<MaxMinSalary> findMaxMinSalaryByConditions(@Param("jobName") String jobName, @Param("companyLocal") String companyLocal);
    Page<MaxMinSalary> findMaxMinSalaryByConditions(Page<MaxMinSalary> page, @Param("jobName") String jobName, @Param("companyLocal") String companyLocal);

}
