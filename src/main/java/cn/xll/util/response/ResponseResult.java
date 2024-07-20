package cn.xll.util.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author 李昊哲
 * @version 1.0.0
 */
@Setter
@Getter
@ToString
public class ResponseResult<T> implements Serializable {
  @Serial
  private static final long serialVersionUID = 2877959539637934739L;
  /**
   * 状态码
   */
  private String code;
  /**
   * 返回消息
   */
  private String msg;
  /**
   * 重定向地址
   */
  private String location;
  /**
   * 令牌
   */
  private String token;
  /**
   * 操作是否成功
   */
  private boolean success;

  private long timestamp;
  /**
   * 返回数据
   */
  private T data;

  public ResponseResult() {
  }

  public ResponseResult(String code, String msg) {
    this.code = code;
    this.msg = msg;
    this.timestamp = System.currentTimeMillis();
  }

  public ResponseResult(String code, String msg, boolean success) {
    this.code = code;
    this.msg = msg;
    this.success = success;
    this.timestamp = System.currentTimeMillis();
  }

  public ResponseResult(T data, boolean success, String token, String location, String msg, String code) {
    this.data = data;
    this.success = success;
    this.token = token;
    this.location = location;
    this.msg = msg;
    this.code = code;
  }

  public ResponseResult(T data, long timestamp, boolean success, String token, String location, String msg, String code) {
    this.data = data;
    this.timestamp = timestamp;
    this.success = success;
    this.token = token;
    this.location = location;
    this.msg = msg;
    this.code = code;
  }
}
