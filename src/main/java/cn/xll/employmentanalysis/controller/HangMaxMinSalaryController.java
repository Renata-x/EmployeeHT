package cn.xll.employmentanalysis.controller;

import cn.xll.employmentanalysis.pojo.Result;
import cn.xll.employmentanalysis.pojo.vo.HangMaxMinSalaryListVo;
import cn.xll.employmentanalysis.service.HangMaxMinSalaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Tag(name = "杭州最高最低工资接口")
@CrossOrigin
@RestController
@RequestMapping("/HangMaxMinSalary")
@RequiredArgsConstructor
public class HangMaxMinSalaryController {
    final HangMaxMinSalaryService hangMaxMinSalaryService;

    @Operation(summary = "获取杭州最低最高工资数据")
    @GetMapping
    public Result getHangJobMaxMin() {
        log.info("获取max_min_salary数据");
        HangMaxMinSalaryListVo hangMaxMinSalaryListVo = hangMaxMinSalaryService.getHangJobMaxMin();
        return Result.ok(hangMaxMinSalaryListVo);
    }
}
