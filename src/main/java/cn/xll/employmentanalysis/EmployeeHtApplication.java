package cn.xll.employmentanalysis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.xll.employmentanalysis.mapper")
@SpringBootApplication
public class EmployeeHtApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmployeeHtApplication.class, args);
  }

}
