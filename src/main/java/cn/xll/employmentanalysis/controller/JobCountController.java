package cn.xll.employmentanalysis.controller;

import cn.xll.employmentanalysis.pojo.Result;
import cn.xll.employmentanalysis.pojo.vo.ChengJobCountListVo;
import cn.xll.employmentanalysis.pojo.vo.GuangJobCountListVo;
import cn.xll.employmentanalysis.pojo.vo.ShanghaiJobCountListVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xll.employmentanalysis.pojo.entity.JobCount;
import cn.xll.employmentanalysis.service.JobCountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "工作数量接口")
@RestController
@RequestMapping("/JobCount")
@RequiredArgsConstructor
@CrossOrigin
public class JobCountController {
    final JobCountService jobCountService;
    @GetMapping("/selectOption")
    public ResponseEntity<List<JobCount>> findJobCountByConditions(@RequestParam( value = "jobName",required = false) String jobName,
                                                                   @RequestParam( value = "companyLocal",required = false) String companyLocal,
                                                                   @RequestParam( value = "order",defaultValue = "DESC") String order){
        List<JobCount> jobCountList = jobCountService.findJobCountByConditions(jobName, companyLocal, order);
        return ResponseEntity.ok(jobCountList);
    }

    @Operation(summary = "获取上海工作数量")
    @GetMapping
    public Result getJobCount() {
        log.info("获取上海工作数量排名");
        ShanghaiJobCountListVo shanghaiJobCountList = jobCountService.getShangJobCount();
        return Result.ok(shanghaiJobCountList);
    }

    @Operation(summary = "获取广州工作数量")
    @GetMapping("/guangzhou")
    public Result getGuangJobCount() {
        log.info("获取广州工作数量排名");
        GuangJobCountListVo guangJobCountListVo= jobCountService.getGuangJobCount();
        return Result.ok(guangJobCountListVo);
    }

    @Operation(summary = "获取成都工作数量")
    @GetMapping("/chengdu")
    public Result getChengJobCount() {
        log.info("获取广州工作数量排名");
        ChengJobCountListVo chengJobCountListVo= jobCountService.getChengJobCount();
        return Result.ok(chengJobCountListVo);
    }


    @GetMapping("/pageSelectOption")
    public Page<JobCount> findJobCountPage(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                           @RequestParam(value = "jobName",required = false) String jobName,
                                           @RequestParam( value = "companyLocal",required = false) String companyLocal,
                                           @RequestParam( value = "order",defaultValue = "DESC") String order){
        Page<JobCount> jobCountPage = jobCountService.findPage(pageNum, pageSize, jobName, companyLocal, order);
        return jobCountPage;
    }
}
