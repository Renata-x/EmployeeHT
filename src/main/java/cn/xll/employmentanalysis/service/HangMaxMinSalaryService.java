package cn.xll.employmentanalysis.service;

import cn.xll.employmentanalysis.pojo.entity.HangMaxMinSalary;
import cn.xll.employmentanalysis.pojo.vo.HangMaxMinSalaryListVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface HangMaxMinSalaryService extends IService<HangMaxMinSalary> {


    HangMaxMinSalaryListVo getHangJobMaxMin();
}
