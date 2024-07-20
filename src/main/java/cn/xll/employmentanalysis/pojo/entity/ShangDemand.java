package cn.xll.employmentanalysis.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("shang_demand")
public class ShangDemand {
    private String demand;
    private Integer jobCount;
}
