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
@TableName("china_job_count")
public class ChinaJobCount extends Model<ChinaJobCount> {
    @TableId(value = "id", type = IdType.NONE)
    private long id;
    private String companyLocal;
    private Integer jobCount;

}
