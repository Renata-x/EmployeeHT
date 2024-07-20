package cn.xll.util.response;

import java.io.Serial;

/**
 * @author 李昊哲
 * @version 1.0.0
 */
public class ResponseController<T> extends ResponseResult<T> {
  @Serial
  private static final long serialVersionUID = -7521216106154495137L;

  /**
   * 方法执行成功
   *
   * @return ResponseResult
   */
  public static ResponseResult success() {
    return new ResponseResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), true);
  }

  /**
   * 方法执行失败
   *
   * @return ResponseResult
   */
  public static ResponseResult failed() {
    return new ResponseResult<>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMsg());
  }

  /**
   * 未查询到数据
   *
   * @return ResponseResult
   */
  public static ResponseResult dataEmpty() {
    return new ResponseResult<>(ResultCode.DATA_EMPTY.getCode(), ResultCode.DATA_EMPTY.getMsg());
  }

  /**
   * 登录失败
   *
   * @return ResponseResult
   */
  public static ResponseResult loginFailed() {
    return new ResponseResult<>(ResultCode.LOGIN_FAILED.getCode(), ResultCode.LOGIN_FAILED.getMsg());
  }

  /**
   * 用户未认证,禁止访问
   *
   * @return ResponseResult
   */
  public static ResponseResult unAuthorized() {
    return new ResponseResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMsg());
  }

  /**
   * 用户未认证,禁止访问
   *
   * @return ResponseResult
   */
  public static ResponseResult forbidden() {
    return new ResponseResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMsg());
  }

  /**
   * 账号不能为空
   *
   * @return ResponseResult
   */
  public static ResponseResult accountIsNull() {
    return new ResponseResult<>(ResultCode.ACCOUNT_ISNULL.getCode(), ResultCode.ACCOUNT_ISNULL.getMsg());
  }

  /**
   * 参数错误
   *
   * @return ResponseResult
   */
  public static ResponseResult paramError() {
    return new ResponseResult<>(ResultCode.PARAM_ERROR.getCode(), ResultCode.PARAM_ERROR.getMsg());
  }

  /**
   * 密码不能为空
   *
   * @return ResponseResult
   */
  public static ResponseResult passwordIsNull() {
    return new ResponseResult<>(ResultCode.PASSWORD_ISNULL.getCode(), ResultCode.PASSWORD_ISNULL.getMsg());
  }

  /**
   * 确认密码不能为空
   *
   * @return ResponseResult
   */
  public static ResponseResult rePasswordIsNull() {
    return new ResponseResult<>(ResultCode.REPASSWORD_ISNULL.getCode(), ResultCode.REPASSWORD_ISNULL.getMsg());
  }

  /**
   * 原始密码不能为空
   *
   * @return ResponseResult
   */
  public static ResponseResult oPasswordIsNull() {
    return new ResponseResult<>(ResultCode.OPASSWORD_ISNULL.getCode(), ResultCode.OPASSWORD_ISNULL.getMsg());
  }

  /**
   * 新密码与确认密码不一致
   *
   * @return ResponseResult
   */
  public static ResponseResult inconsistentPasswords() {
    return new ResponseResult<>(ResultCode.INCONSISTENT_PASSWORDS.getCode(), ResultCode.INCONSISTENT_PASSWORDS.getMsg());
  }

  /**
   * 新密码与原始密码一致
   *
   * @return ResponseResult
   */
  public static ResponseResult passwordNoChange() {
    return new ResponseResult<>(ResultCode.PASSWORD_NOCHANGE.getCode(), ResultCode.PASSWORD_NOCHANGE.getMsg());
  }

  /**
   * 密码不能为空
   *
   * @return ResponseResult
   */
  public static ResponseResult passwordIsError() {
    return new ResponseResult<>(ResultCode.PASSWORD_ERROR.getCode(), ResultCode.PASSWORD_ERROR.getMsg());
  }
}
