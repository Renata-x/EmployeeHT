package cn.xll.employmentanalysis.mapper;

import cn.xll.employmentanalysis.pojo.entity.ChengJobCount;
import cn.xll.employmentanalysis.pojo.entity.ShangDemand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemandMapper  extends BaseMapper<ShangDemand> {
}
