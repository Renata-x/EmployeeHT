package cn.xll.employmentanalysis.config;


import cn.xll.util.servlet.Servlet4Spring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李昊哲
 * @version 1.0.0
 */
@Configuration
public class BeanConfig {
  @Bean
  public Servlet4Spring servlet4Spring() {
    return new Servlet4Spring();
  }
}
