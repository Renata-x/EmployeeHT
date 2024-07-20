package cn.xll.employmentanalysis.pojo.vo;

import cn.xll.employmentanalysis.pojo.dto.ChengJobCountDto;
import cn.xll.employmentanalysis.pojo.dto.ChinaJobCountDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChengJobCountListVo {
    private List<ChengJobCountDto> chengJobCountDtos;

    public ChengJobCountListVo() {
        this.chengJobCountDtos = new ArrayList<>();
    }

    public void add(ChengJobCountDto chengJobCountDto) {
        this.chengJobCountDtos.add(chengJobCountDto);
    }
}
