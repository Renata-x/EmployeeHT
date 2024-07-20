package cn.xll.employmentanalysis.pojo.vo;


import cn.xll.employmentanalysis.pojo.dto.HangMaxMinSalaryDto;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class HangMaxMinSalaryListVo {
    private List<HangMaxMinSalaryDto> hangMaxMinSalaryDtos;

    public HangMaxMinSalaryListVo() {
        this.hangMaxMinSalaryDtos = new ArrayList<>();
    }

    public void add(HangMaxMinSalaryDto hangMaxMinSalaryDto) {
        this.hangMaxMinSalaryDtos.add(hangMaxMinSalaryDto);
    }
}
