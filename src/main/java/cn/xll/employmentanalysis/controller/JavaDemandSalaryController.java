package cn.xll.employmentanalysis.controller;


import cn.xll.employmentanalysis.pojo.Result;
import cn.xll.employmentanalysis.pojo.entity.JavaDemandSalary;
import cn.xll.employmentanalysis.pojo.vo.JavaDemandListVo;
import cn.xll.employmentanalysis.pojo.vo.SalaryRankVoList;
import cn.xll.employmentanalysis.service.JavaDemandSalaryService;
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
@Tag(name = "JavaDemand工资接口")
@CrossOrigin
@RestController
@RequestMapping("/JavaDemandSalary")
@RequiredArgsConstructor
public class JavaDemandSalaryController {
    private final JavaDemandSalaryService javaDemandSalaryService;
    @GetMapping("/queryAll")
    public List<JavaDemandSalary> queryAll(){
        return javaDemandSalaryService.queryAll();
    }



    @Operation(summary = "获取java_demand数据")
    @GetMapping
    public Result getJavaDemand() {
        log.info("获取java_demand数据");
        JavaDemandListVo javaDemandListVo = javaDemandSalaryService.getJavaDemand();
        return Result.ok(javaDemandListVo);
    }
}
