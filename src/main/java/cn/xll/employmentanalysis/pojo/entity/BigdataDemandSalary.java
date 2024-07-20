package cn.xll.employmentanalysis.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@TableName("bigdata_demand_salary")
public class BigdataDemandSalary extends Model<BigdataDemandSalary> {
    @TableId(value = "id", type = IdType.NONE)
    private long id;
    private String demand;
    private int averageSalary;
}
