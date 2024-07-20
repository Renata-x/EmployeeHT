package cn.xll.employmentanalysis.controller;


import cn.xll.employmentanalysis.pojo.Result;
import cn.xll.employmentanalysis.pojo.entity.BigdataDemandSalary;
import cn.xll.employmentanalysis.pojo.vo.BigdataDemandListVo;
import cn.xll.employmentanalysis.pojo.vo.ShanghaiJobCountListVo;
import cn.xll.employmentanalysis.service.BigdataDemandSalaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Tag(name = "BigdataDemand工资接口")
@RestController
@CrossOrigin
@RequestMapping("/BigdataDemandSalary")
@RequiredArgsConstructor
public class BigdataDemandSalaryController {
    private final BigdataDemandSalaryService bigdataDemandSalaryService;
    @GetMapping("/queryAll")
    public List<BigdataDemandSalary> queryAll(){
        return bigdataDemandSalaryService.queryAll();
    }

    @Operation(summary = "获取大数据的平均薪资")
    @GetMapping
    public Result getBigdataDemand() {
        log.info("获取上海工作数量排名");
//        ShanghaiJobCountListVo shanghaiJobCountList = jobCountService.getShangJobCount();
        BigdataDemandListVo bigdataDemandListVo = bigdataDemandSalaryService.getBigdataDemand();
        return Result.ok(bigdataDemandListVo);
    }
}
