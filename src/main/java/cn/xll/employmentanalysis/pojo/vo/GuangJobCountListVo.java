package cn.xll.employmentanalysis.pojo.vo;

import cn.xll.employmentanalysis.pojo.dto.GuangJobCountDto;
import cn.xll.employmentanalysis.pojo.dto.ShanghaiJobCountDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GuangJobCountListVo {
    private List<GuangJobCountDto> guangJobCounts;

    public GuangJobCountListVo() {
        this.guangJobCounts = new ArrayList<>();
    }

    public void add(GuangJobCountDto guangJobCountDto) {
        this.guangJobCounts.add(guangJobCountDto);
    }
}
