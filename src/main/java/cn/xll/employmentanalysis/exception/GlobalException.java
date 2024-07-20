package cn.xll.employmentanalysis.exception;

import cn.xll.util.response.ResponseResult;
import cn.xll.util.response.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author 李昊哲
 * @version 1.0.0
 */
@ControllerAdvice
@RestControllerAdvice
public class GlobalException {
  @ExceptionHandler(Exception.class)
  public ResponseResult<String> defaultErrorHandler(Exception e) {
    return new ResponseResult<>(ResultCode.EXCEPTION.getCode(), e.getMessage());
  }

}
