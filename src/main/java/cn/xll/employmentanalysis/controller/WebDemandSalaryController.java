package cn.xll.employmentanalysis.controller;

import cn.xll.employmentanalysis.pojo.Result;
import cn.xll.employmentanalysis.pojo.entity.WebDemandSalary;
import cn.xll.employmentanalysis.pojo.vo.BigdataDemandListVo;
import cn.xll.employmentanalysis.pojo.vo.WebDemandListVo;
import cn.xll.employmentanalysis.service.WebDemandSalaryService;
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
@Tag(name = "WebDemand工资接口")
@CrossOrigin
@RestController
@RequestMapping("/WebDemandSalary")
@RequiredArgsConstructor
public class WebDemandSalaryController {
    private final WebDemandSalaryService webDemandSalaryService;
    @GetMapping("/queryAll")
    public List<WebDemandSalary> queryAll(){
        return webDemandSalaryService.queryAll();
    }

    @Operation(summary = "获取web的平均薪资")
    @GetMapping
    public Result getWebDemand() {
        log.info("获取web不同学历薪资");
        WebDemandListVo webDemandListVo = webDemandSalaryService.getWebDemand();
        return Result.ok(webDemandListVo);
    }
}
