package cn.xll.employmentanalysis.controller;

import cn.xll.employmentanalysis.pojo.Result;
import cn.xll.employmentanalysis.pojo.entity.AvgSalary;
import cn.xll.employmentanalysis.pojo.vo.SalaryRankVo;
import cn.xll.employmentanalysis.pojo.vo.SalaryRankVoList;
import cn.xll.employmentanalysis.service.AvgSalaryService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "平均工资接口")
@RestController
@RequestMapping("/AvgSalary")
@CrossOrigin
@RequiredArgsConstructor
public class AvgSalaryController {

    private final AvgSalaryService avgSalaryService;

    @Operation(summary = "获取工资排名")
    @GetMapping
    public Result getSalaryRank() {
        log.info("获取工资排名");
        SalaryRankVoList avgSalaryRank = avgSalaryService.getSalaryRank();
        return Result.ok(avgSalaryRank);
    }

    @Operation(summary = "获取上海工资排名")
    @GetMapping("/shanghai")
    public Result getShangSalaryRank() {
        log.info("获取工资排名");
        SalaryRankVoList avgSalaryRank = avgSalaryService.getShangSalaryRank();
        return Result.ok(avgSalaryRank);
    }

    @Operation(summary = "条件获取平均工资")
    @GetMapping("/selectOption")
    public ResponseEntity<List<AvgSalary>> findAvgSalaryByConditions(@RequestParam(required = false) String jobName){
        List<AvgSalary> avgSalaryList = avgSalaryService.findAvgSalaryByConditions(jobName);
        return ResponseEntity.ok(avgSalaryList);
    }

    @GetMapping("/pageSelectOption")
    public Page<AvgSalary> findAvgByPage(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                         @RequestParam(value = "jobName",required = false) String jobName){
        Page<AvgSalary> avgSalary = avgSalaryService.page(pageNum, pageSize,jobName);
        return avgSalary;
    }
}
