package cn.xll.util.servlet;

import cn.xll.util.json.jackson.JacksonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李昊哲
 * @version 1.0.0
 */
@Slf4j
public abstract class AbstractServlet extends HttpServlet {
  @Serial
  private static final long serialVersionUID = 4730408376104791203L;

  /**
   * 将查询字符串解析为 Map 对象
   *
   * @param queryString 查询字符串
   * @return Map
   */
  public static Map<String, Object> parseQueryString(String queryString) {
    Map<String, Object> map = new HashMap<>();
    if (queryString != null && !queryString.isEmpty()) {
      String[] params = queryString.split("&");
      for (String param : params) {
        String[] kv = param.split("=");
        map.put(kv[0], kv[1]);
      }
    }
    return map;
  }

  /**
   * 向页面响应字符串
   *
   * @param response HttpServletResponse
   * @param Text     向页面响应的字符串
   * @throws IOException IOException
   */
  public static void printText(HttpServletResponse response, String Text) throws IOException {
    response.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = response.getWriter();
    writer.print(Text);
    writer.flush();
    writer.close();
  }

  /**
   * 向页面响应json字符串
   *
   * @param response HttpServletResponse
   * @param object   向页面响应的对象
   * @throws IOException IOException
   */
  public static void printJsonObject(HttpServletResponse response, Object object) throws IOException {
    response.setContentType("application/json;charset=utf-8");
    PrintWriter writer = response.getWriter();
    ObjectMapper objectMapper = new ObjectMapper();
    writer.print(objectMapper.writeValueAsString(object));
    writer.flush();
    writer.close();
  }

  /**
   * jsonp 向页面发送字符串
   *
   * @param request  HttpServletRequest
   * @param response HttpServletResponse
   * @param text     向页面发送的字符串
   * @throws IOException IOException
   */
  public void printText4Jsonp(HttpServletRequest request, HttpServletResponse response, String text) throws IOException {
    String method = request.getParameter("callback");
    String json = method + "(" + text + ")";
    response.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = response.getWriter();
    writer.println(json);
    writer.flush();
    writer.close();
  }


  /**
   * jsonp 向页面发送字符串
   *
   * @param request  HttpServletRequest
   * @param response HttpServletResponse
   * @param object   向页面发送的数据对象
   * @throws IOException IOException
   */
  public static void printJson4Jsonp(HttpServletRequest request, HttpServletResponse response, Object object) throws IOException {
    String method = request.getParameter("callback");
    String json = method + "(" + JacksonUtils.bean2json(object) + ")";
    response.setContentType("application/json;charset=utf-8");
    PrintWriter writer = response.getWriter();
    writer.println(json);
    writer.flush();
    writer.close();
  }

  /**
   * 请求转发
   *
   * @param request  HttpServletRequest
   * @param response HttpServletResponse
   * @param path     请求转发路径
   * @throws ServletException ServletException
   * @throws IOException      IOException
   */
  public static void forword(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
    request.getRequestDispatcher(path).forward(request, response);
  }

  /**
   * 请求转发 到 WEB-INF 目录
   *
   * @param request  HttpServletRequest
   * @param response HttpServletResponse
   * @param path     请求转发路径
   * @throws ServletException ServletException
   * @throws IOException      IOException
   */
  public static void forwordToWEB_INF(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
    forword(request, response, "/WEB-INF/" + path);
  }

  /**
   * 请求转发 访问 jsp 页面
   *
   * @param request  HttpServletRequest
   * @param response HttpServletResponse
   * @param path     请求转发 访问 jsp文件名（不包含.jsp）
   * @throws ServletException ServletException
   * @throws IOException      IOException
   */
  public static void forwordSuffixJSP(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
    forword(request, response, path + ".jsp");
  }

  /**
   * 请求转发 到 WEB-INF 目录 访问 jsp 页面
   *
   * @param request  HttpServletRequest
   * @param response HttpServletResponse
   * @param path     请求转发路径 访问 jsp文件名（不包含.jsp）
   * @throws ServletException ServletException
   * @throws IOException      IOException
   */
  public static void forwordToWEB_INF_SuffixJSP(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
    forword(request, response, "/WEB-INF/" + path + ".jsp");
  }

  /**
   * 网页重定向 访问 jsp 页面
   *
   * @param request  HttpServletRequest
   * @param response HttpServletResponse
   * @param path     网页重定向 访问 jsp 页面
   * @throws ServletException ServletException
   * @throws IOException      IOException
   */
  public static void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
    response.sendRedirect(request.getContextPath() + "/" + path);
  }

  /**
   * 网页重定向 访问 jsp 页面
   *
   * @param request  HttpServletRequest
   * @param response HttpServletResponse
   * @param path     网页重定向 访问 jsp文件名（不包含.jsp）
   * @throws ServletException ServletException
   * @throws IOException      IOException
   */
  public static void redirectSuffixJSP(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
    redirect(request, response, path + ".jsp");
  }
}
