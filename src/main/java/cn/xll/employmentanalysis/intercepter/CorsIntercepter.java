package cn.xll.employmentanalysis.intercepter;



//import cn.xll.employmentanalysis.config.CorsConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 李昊哲
 * @version 1.0.0
 */
//@Configuration
//@RequiredArgsConstructor
//public class CorsIntercepter implements HandlerInterceptor {
//  private final CorsConfig corsConfig;
//  @Override
//  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // ajax跨域
//    response.setHeader("Cache-Control", "no-cache");
//    response.setHeader("Access-Control-Allow-Methods", corsConfig.getAccessControlAllowMethods());
//    response.setHeader("Access-Control-Max-Age", corsConfig.getAccessControlAllowMaxAge());
//    response.setHeader("Access-Control-Allow-Headers", corsConfig.getAccessControlAllowHeaders());
    // response.setHeader("Access-Control-Allow-Origin", "http://192.168.18.65:5500");
//    String allowOrigin = request.getHeader("Origin");
//    if (!corsConfig.getAccessControlAllowOrigin().isEmpty() && !"Origin".equalsIgnoreCase(corsConfig.getAccessControlAllowOrigin())) {
//      allowOrigin = corsConfig.getAccessControlAllowOrigin();
//    }
//    response.setHeader("Access-Control-Allow-Origin", allowOrigin);
//    response.setHeader("Access-Control-Allow-Credentials", corsConfig.getAccessControlAllowCredentials());
//    response.setHeader("XDomainRequestAllowed", "1");
//    String requestMethod = request.getMethod();
//    if ("OPTIONS".equalsIgnoreCase(requestMethod)) {
//      return false;
//    }
//    return HandlerInterceptor.super.preHandle(request, response, handler);
//  }

//  @Override
//  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//  }
//
//  @Override
//  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//  }
//}
