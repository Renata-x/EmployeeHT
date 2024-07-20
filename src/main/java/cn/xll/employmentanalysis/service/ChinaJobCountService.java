package cn.xll.employmentanalysis.service;

import cn.xll.employmentanalysis.pojo.entity.ChinaJobCount;
import cn.xll.employmentanalysis.pojo.vo.ChinaJobCountListVo;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

public interface ChinaJobCountService extends IService<ChinaJobCount> {

    ChinaJobCountListVo getChinaJobCount();
}
