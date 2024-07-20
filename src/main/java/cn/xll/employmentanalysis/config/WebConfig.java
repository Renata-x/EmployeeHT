package cn.xll.employmentanalysis.config;

//import cn.xll.employmentanalysis.intercepter.CorsIntercepter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
/*


@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
  private final CorsIntercepter corsIntercepter;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // WebMvcConfigurer.super.addInterceptors(registry);
    List<String> corsExcludePaths = new ArrayList<>();
    corsExcludePaths.add("/assets/**");
    corsExcludePaths.add("/lib/**");
    corsExcludePaths.add("/html/**");
    corsExcludePaths.add("/css/**");
    corsExcludePaths.add("/images/**");
    corsExcludePaths.add("/img/**");
    corsExcludePaths.add("/js/**");
    corsExcludePaths.add("/*.html");
    // 注册拦截器
    // addPathPatterns 用于添加拦截规则, 这里假设拦截 /url 后面的全部链接
    // excludePathPatterns 用户排除拦截
    registry.addInterceptor(corsIntercepter)
        .addPathPatterns("/**")
        .excludePathPatterns(corsExcludePaths);
  }
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("http://localhost:63342") // 允许来自这个源的请求
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD")
            .allowCredentials(true)
            .allowedHeaders("*")
            .exposedHeaders("Authorization");
  }
}
*/
