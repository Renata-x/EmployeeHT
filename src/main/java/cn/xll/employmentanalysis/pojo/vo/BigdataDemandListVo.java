package cn.xll.employmentanalysis.pojo.vo;


import cn.xll.employmentanalysis.pojo.dto.BigdataDemandDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class BigdataDemandListVo {
    private List<BigdataDemandDto> bigdataDemandDtos;

    public BigdataDemandListVo() {
        this.bigdataDemandDtos = new ArrayList<>();
    }

    public void add(BigdataDemandDto bigdataDemandDto) {
        this.bigdataDemandDtos.add(bigdataDemandDto);
    }
}
