package cn.xll.employmentanalysis.controller;

import cn.xll.employmentanalysis.pojo.Result;
import cn.xll.employmentanalysis.pojo.vo.JavaDemandListVo;
import cn.xll.employmentanalysis.pojo.vo.MaxMinSalaryListVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xll.employmentanalysis.pojo.entity.MaxMinSalary;
import cn.xll.employmentanalysis.service.MaxMinSalaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "上海最高最低工资接口")
@CrossOrigin
@RestController
@RequestMapping("/MaxMinSalary")
@RequiredArgsConstructor
public class MaxMinSalaryController {
    final MaxMinSalaryService minSalaryService;
    @GetMapping("/selectOption")
    public ResponseEntity<List<MaxMinSalary>> findMaxMinSalaryByConditions(@RequestParam( value = "jobName",required = false) String jobName,
                                                                           @RequestParam( value = "companyLocal",required = false) String companyLocal){
        List<MaxMinSalary> maxMinSalaryList = minSalaryService.findMaxMinSalaryByConditions(jobName, companyLocal);
        return ResponseEntity.ok(maxMinSalaryList);
    }
    @GetMapping("/pageSelectOption")
    public Page<MaxMinSalary> findMaxMinByPage(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                               @RequestParam(value = "jobName",required = false) String jobName,
                                               @RequestParam( value = "companyLocal",required = false) String companyLocal){
        Page<MaxMinSalary> maxMinSalaryPage = minSalaryService.findPage(pageNum, pageSize, jobName, companyLocal);
        return maxMinSalaryPage;

    }


    @Operation(summary = "获取上海最低最高工资数据")
    @GetMapping
    public Result getJobMaxMin() {
        log.info("获取max_min_salary数据");
//        JavaDemandListVo javaDemandListVo = javaDemandSalaryService.getJavaDemand();
        MaxMinSalaryListVo maxMinSalaryListVo = minSalaryService.getJobMaxMin();
        return Result.ok(maxMinSalaryListVo);
    }
}
