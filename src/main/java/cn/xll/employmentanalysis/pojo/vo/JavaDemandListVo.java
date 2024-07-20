package cn.xll.employmentanalysis.pojo.vo;

import cn.xll.employmentanalysis.pojo.dto.JavaDemandDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class JavaDemandListVo {

    private List<JavaDemandDto> javaDemandDtos;

    public JavaDemandListVo() {
        this.javaDemandDtos = new ArrayList<>();
    }

    public void add(JavaDemandDto javaDemandDto) {
        this.javaDemandDtos.add(javaDemandDto);
    }
}
