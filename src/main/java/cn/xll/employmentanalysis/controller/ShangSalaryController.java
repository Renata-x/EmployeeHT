package cn.xll.employmentanalysis.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/shangSalary")
@Tag(name = "上海各行接口")
public class ShangSalaryController {

//    private final ShangSalaryService shangSalaryService;
//    @Operation(summary = "获取全部岗位工资数据")
//    @GetMapping
////    public Result getShangSalary() {
////        List<ShangDemandVo> shangDemands = demandService.get();
////        return Result.ok(shangDemands);
//    }
}
