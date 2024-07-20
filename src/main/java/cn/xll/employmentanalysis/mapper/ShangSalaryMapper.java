package cn.xll.employmentanalysis.mapper;

import cn.xll.employmentanalysis.pojo.entity.ShangAvgSalary;
import cn.xll.employmentanalysis.pojo.entity.ShangSalary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xll.employmentanalysis.pojo.entity.AvgSalary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShangSalaryMapper extends BaseMapper<ShangSalary> {

}
