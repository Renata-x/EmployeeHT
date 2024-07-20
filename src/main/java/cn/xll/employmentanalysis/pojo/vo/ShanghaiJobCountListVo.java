package cn.xll.employmentanalysis.pojo.vo;

import cn.xll.employmentanalysis.pojo.dto.ShanghaiJobCountDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShanghaiJobCountListVo {
    private List<ShanghaiJobCountDto> shanghaiJobCounts;

    public ShanghaiJobCountListVo() {
        this.shanghaiJobCounts = new ArrayList<>();
    }

    public void add(ShanghaiJobCountDto shanghaiJobCount) {
        this.shanghaiJobCounts.add(shanghaiJobCount);
    }
}
