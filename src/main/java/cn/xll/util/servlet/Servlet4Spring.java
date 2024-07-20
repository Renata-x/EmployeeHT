package cn.xll.util.servlet;

import cn.xll.util.json.jackson.JacksonUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 李昊哲
 * @version 1.0.0
 */
public class Servlet4Spring {
  /**
   * 向页面发送字符串
   *
   * @param response HttpServletResponse
   * @param text     发送字符串
   * @throws IOException IOException
   */
  public void printText(HttpServletResponse response, String text) throws IOException {
    response.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = response.getWriter();
    writer.println(text);
    writer.flush();
    writer.close();
  }

  /**
   * 向页面发送JSON格式字符串
   *
   * @param response HttpServletResponse
   * @param object   对象
   * @throws IOException IOException
   */
  public void printJson(HttpServletResponse response, Object object) throws IOException {
    response.setContentType("application/json;charset=utf-8");
    PrintWriter writer = response.getWriter();
    writer.println(JacksonUtils.bean2json(object));
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
  public void printJson4Jsonp(HttpServletRequest request, HttpServletResponse response, Object object) throws IOException {
    String method = request.getParameter("callback");
    String json = method + "(" + JacksonUtils.bean2json(object) + ")";
    response.setContentType("application/json;charset=utf-8");
    PrintWriter writer = response.getWriter();
    writer.println(json);
    writer.flush();
    writer.close();
  }
}
