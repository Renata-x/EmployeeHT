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
@TableName("max_min_salary")
public class MaxMinSalary extends Model<MaxMinSalary> {
    @TableId(value = "id", type = IdType.NONE)
    private long id;
    private String companyLocal;
    private String jobName;
    private Double maxSalary;
    private Double minSalary;

}
