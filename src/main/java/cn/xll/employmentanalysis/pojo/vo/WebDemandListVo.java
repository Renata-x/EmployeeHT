package cn.xll.employmentanalysis.pojo.vo;

import cn.xll.employmentanalysis.pojo.dto.JavaDemandDto;
import cn.xll.employmentanalysis.pojo.dto.WebDemandDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class WebDemandListVo {

    private List<WebDemandDto> webDemandDtos;

    public WebDemandListVo() {
        this.webDemandDtos = new ArrayList<>();
    }

    public void add(WebDemandDto webDemandDto) {
        this.webDemandDtos.add(webDemandDto);
    }
}
