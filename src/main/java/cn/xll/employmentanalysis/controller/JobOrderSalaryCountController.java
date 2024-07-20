package cn.xll.employmentanalysis.controller;

import cn.xll.employmentanalysis.pojo.Result;
import cn.xll.employmentanalysis.pojo.entity.JobOrderSalaryCount;
import cn.xll.employmentanalysis.pojo.vo.JavaOrderSalaryListVo;
import cn.xll.employmentanalysis.pojo.vo.MaxMinSalaryListVo;
import cn.xll.employmentanalysis.service.JobOrderSalaryCountService;
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
@Tag(name = "java工资接口")
@CrossOrigin
@RestController
@RequestMapping("/JobOrderSalaryCount")
@RequiredArgsConstructor
public class JobOrderSalaryCountController {
    private final JobOrderSalaryCountService jobOrderSalaryCountService;
    @GetMapping("/queryAll")
    public List<JobOrderSalaryCount> queryAll(){
        return jobOrderSalaryCountService.queryAll();
    }


    @Operation(summary = "获取java工资数据")
    @GetMapping
    public Result getJavaOrderSalary() {
        log.info("获取java数据");
//        MaxMinSalaryListVo maxMinSalaryListVo = minSalaryService.getJobMaxMin();
        JavaOrderSalaryListVo javaOrderSalaryListVo = jobOrderSalaryCountService.getJavaOrderSalary();
        return Result.ok(javaOrderSalaryListVo);
    }
}
