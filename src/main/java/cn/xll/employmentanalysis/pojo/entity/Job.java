package cn.xll.employmentanalysis.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;


@Setter
@Getter
@ToString
@RequiredArgsConstructor
@TableName("job")
public class Job extends Model<Job> implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.NONE)
    private String id;
    private String jobName;
    private String workDemand;
    private String companyLocal;
    private String companyName;
    private String guimo;
    private Double jobSalary;
    private String isJobSalaryFifteenK;
    private String demand;
}
