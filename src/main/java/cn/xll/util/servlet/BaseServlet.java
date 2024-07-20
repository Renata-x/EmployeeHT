package cn.xll.util.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.Serial;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;


/**
 * HttpServlet 自定义子类
 *
 * @author 李昊哲
 * @version 1.0.0
 */
@Slf4j
public abstract class BaseServlet extends AbstractServlet {
  @Serial
  private static final long serialVersionUID = -458150483331140082L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    execute(req, resp);
  }


  @Override
  protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    execute(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    execute(req, resp);
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    execute(req, resp);
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    execute(req, resp);
  }

  @Override
  protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    execute(req, resp);
  }

  @Override
  protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    execute(req, resp);
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    execute(req, resp);
  }

  /**
   * 执行真实方法
   *
   * @param request  HttpServletRequest
   * @param response HttpServletResponse
   */
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 处理中文乱码
    // 处理post请求的中文乱码
    request.setCharacterEncoding("utf-8");
    // 处理响应的字符集中文乱码
    response.setCharacterEncoding("utf-8");
    // 处理浏览器字符集中文乱码
    response.setContentType("text/html;charset=utf-8");
    // log.info("请求方式：" + request.getMethod());
    // ajax 跨域
    // String origin = request.getHeader("Origin");
    // 动态 允许指定地址跨域访问
    // response.setHeader("Access-Control-Allow-Origin", origin);
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, PUT, PATCH , DELETE, POST");
    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    response.addHeader("Access-Control-Allow-Credentials", "true");
    String requestMethod = request.getMethod();
    if ("OPTIONS".equalsIgnoreCase(requestMethod)) {
      return;
    }
    // 获取执行的方法名称
    String methodName = request.getParameter("methodName");
    String contentType = request.getContentType();
    Class<? extends AbstractServlet> clazz = this.getClass();
    try {
      if (methodName.isEmpty()) {
        log.error("缺少参数 methodName");
        throw new ServletException("缺少参数 methodName");
      } else if (contentType != null && contentType.contains("application/json")) {
        // json格式数据的处理方式
        ServletInputStream inputStream = request.getInputStream();
//    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//    String json = bufferedReader.lines().collect(Collectors.joining());
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class, String.class);
        method.setAccessible(true);
        method.invoke(this, request, response, json);
      } else {
        // 普通表单的处理方式
        Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        method.setAccessible(true);
        method.invoke(this, request, response);
      }

    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }
}
