package cn.xll.employmentanalysis.controller;

import cn.xll.employmentanalysis.pojo.Result;
import cn.xll.employmentanalysis.pojo.entity.ShangDemand;
import cn.xll.employmentanalysis.pojo.vo.ShangDemandVo;
import cn.xll.employmentanalysis.service.DemandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/demand")
@Tag(name = "学位接口")
public class DemandController {

    private final DemandService demandService;

    @Operation(summary = "获取全部学位数据")
    @GetMapping
    public Result get() {
        List<ShangDemandVo> shangDemands = demandService.get();
        return Result.ok(shangDemands);
    }
}
