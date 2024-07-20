package cn.xll.employmentanalysis.controller;

import cn.xll.employmentanalysis.pojo.Result;
import cn.xll.employmentanalysis.pojo.vo.ChinaJobCountListVo;
import cn.xll.employmentanalysis.service.ChinaJobCountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "全国工作数量接口")
@RestController
@RequestMapping("/ChinaJobCount")
@RequiredArgsConstructor
@CrossOrigin
public class ChinaJobCountController {

    private final ChinaJobCountService chinajobCountService;

    @Operation(summary = "获取全国各地工作数量")
    @GetMapping
    public Result getChinaJobCount() {
        log.info("获取全国工作数量排名");
        ChinaJobCountListVo chinaJobCountListVo = chinajobCountService.getChinaJobCount();
        return Result.ok(chinaJobCountListVo);
    }

}
