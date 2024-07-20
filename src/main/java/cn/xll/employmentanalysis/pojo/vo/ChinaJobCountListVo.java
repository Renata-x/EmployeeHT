package cn.xll.employmentanalysis.pojo.vo;

import cn.xll.employmentanalysis.pojo.dto.ChinaJobCountDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChinaJobCountListVo {
    private List<ChinaJobCountDto> chinaJobCountDtos;

    public ChinaJobCountListVo() {
        this.chinaJobCountDtos = new ArrayList<>();
    }

    public void add(ChinaJobCountDto chinaJobCountDto) {
        this.chinaJobCountDtos.add(chinaJobCountDto);
    }
}
