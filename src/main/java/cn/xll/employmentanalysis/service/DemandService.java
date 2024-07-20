package cn.xll.employmentanalysis.service;

import cn.xll.employmentanalysis.pojo.entity.ChinaJobCount;
import cn.xll.employmentanalysis.pojo.entity.ShangDemand;
import cn.xll.employmentanalysis.pojo.vo.ShangDemandVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface DemandService extends IService<ShangDemand> {
    List<ShangDemandVo> get();
}
