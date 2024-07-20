package cn.xll.employmentanalysis.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xll.employmentanalysis.pojo.entity.Job;
import cn.xll.employmentanalysis.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;
    @GetMapping("/queryAll")
    public List<Job> queryAll() {
        return jobService.queryAll();
    }
    @GetMapping("/selectOption")
    public ResponseEntity<List<Job>> findJobByConditions(@RequestParam(required = false) String jobName,
                                                         @RequestParam(required = false) String workDemand,
                                                         @RequestParam(required = false) String demand,
                                                         @RequestParam(required = false) String companyName,
                                                         @RequestParam(required = false) String companyLocal) {


        List<Job> jobList = jobService.findJobByConditions(jobName, workDemand, demand, companyName, companyLocal);
        return ResponseEntity.ok(jobList);
    }
    @GetMapping("/pageSelectOption")
    public Page<Job> findJobByPage(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                   @RequestParam(value = "jobName",required = false) String jobName,
                                   @RequestParam(value = "workDemand",required = false) String workDemand,
                                   @RequestParam(value = "demand",required = false) String demand,
                                   @RequestParam(value = "companyName",required = false) String companyName,
                                   @RequestParam( value = "companyLocal",required = false) String companyLocal){
        Page<Job> jobPage = jobService.findPage(pageNum, pageSize, jobName, workDemand, demand, companyName, companyLocal);
        return  jobPage;
    }
    @PostMapping("/add")
    public String addJob(@RequestBody Job job){
        int result = jobService.addJob(job);
        if(result > 0){
            return "Job added successfully";
        }else{
            return "Failed to add job";
        }
    }
    @DeleteMapping("/delete/{id}")
    public String deleteJob(@PathVariable("id") String id){
        int result = jobService.deleteById(id);
        if(result > 0){
            return "Job deleted successfully";
        }else{
            return "Failed to delete job";
        }
    }
    @PostMapping("/update")
    public String updateJob(@RequestBody Job job){
        int result = jobService.addJob(job);
        if(result > 0){
            return "Job updated successfully";
        }else{
            return "Failed to update job";
        }
    }



}
