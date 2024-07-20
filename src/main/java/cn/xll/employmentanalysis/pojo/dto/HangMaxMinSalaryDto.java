package cn.xll.employmentanalysis.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HangMaxMinSalaryDto {
    private Double max;
    private Double min;
    private String name;
}

