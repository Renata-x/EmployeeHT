package cn.xll.util.response;

/**
 * @author 李昊哲
 * @version 1.0.0
 */
public enum ResultCode {
   /**
   * 操作成功 请求成功
   */
  SUCCESS("200", "操作成功", "请求成功"),

  /**
   * 重定向 重定向
   */
  LOCATION("302", "重定向", "重定向"),

  /**
   * 用户未认证
   */
  UNAUTHORIZED("401", "用户未认证,禁止访问", "服务器拒绝了你的地址请求，账号或者密码错误"),

  /**
   * 用户未授权
   */
  FORBIDDEN("403", "用户未授权,禁止访问", "服务器拒绝了你的地址请求，很有可能是您没权限访问"),
  /**
   * 账号不能为空 账号不能为空
   */
  ACCOUNT_ISNULL("601", "账号不能为空", "账号不能为空"),
  /**
   * 密码不能为空 密码不能为空
   */
  PASSWORD_ISNULL("602", "密码不能为空", "密码不能为空"),

  /**
   * 确认密码不能为空 确认密码不能为空
   */
  REPASSWORD_ISNULL("603", "确认密码不能为空", "确认密码不能为空"),

  /**
   * 原始密码不能为空
   */
  OPASSWORD_ISNULL("604", "原始密码不能为空", "原始密码不能为空"),

  /**
   * 新密码与原始密码一致
   */
  PASSWORD_NOCHANGE("605", "新密码与原始密码一致，无需修改", "新密码与原始密码一致，无需修改"),

  /**
   * 新密码与确认密码不一致
   */
  INCONSISTENT_PASSWORDS("606", "新密码与确认密码不一致", "新密码与确认密码不一致"),

  /**
   * 密码错误
   */
  PASSWORD_ERROR("607", "密码错误", "密码错误"),

  /**
   * 数据已被删除
   */
  ISDELETED("608", "数据已被删除", "数据已被删除"),

  /**
   * 操作失败 执行失败
   */
  FAILED("10086", "执行失败", "执行失败"),

  /**
   * 参数错误 参数为空或格式不正确
   */
  PARAM_ERROR("10001", "参数错误", "参数为空或格式不正确"),

  /**
   * 登录失败
   */
  LOGIN_FAILED("10002", "登录失败", "登录失败"),

  /**
   * 账号锁定
   */
  LOGIN_LOCKED("10003", "账号锁定", "账号锁定"),


  /**
   * appKey异常 appKey被冻结
   */
  APPKEY_ERROR("10005", "appKey异常", "appKey被冻结"),

  /**
   * 验证码失效 redis中key失效
   */
  TIMEOUT("10006", "验证码失效，请重新发送", "redis中key失效"),

  /**
   * 短信一发送，单位时间内，不会重新发送
   */
  NO_TIMEOUT("10007", "短信已发送，请等待", "短信已发送，单位时间内，不会重新发送"),

  /**
   * 验证码错误
   */
  CODE_ERROR("10008", "验证码错误，请重新输入", "客户端获取的验证码与redis中存储的验证码不一致"),

  /**
   * 短信一发送，单位时间内，不会重新发送
   */
  NO_LOGIN("10009", "未登录状态", "未登录状态"),

  /**
   * 未知系统异常
   */
  EXCEPTION("10010", "未知系统异常", "未知系统异常"),

  /**
   * 这是在主机名解析时通常出现的暂时错误，它意味着本地服务器没有从权威服务器上收到响应。
   */
  UNKNOWN_HOST("10011", " 这是在主机名解析时通常出现的暂时错误，它意味着本地服务器没有从权威服务器上收到响应。", "这是在主机名解析时通常出现的暂时错误，它意味着本地服务器没有从权威服务器上收到响应。"),

  /**
   * 签名不一致
   */
  INCONSISTENT_SIGNATURE("10012", "签名不一致", "签名不一致"),

  /**
   * 算法不匹配
   */
  ALGORITHM_MISMATCH("10013", "算法不匹配", "算法不匹配"),

  /**
   * token过期失效
   */
  TOKEN_EXPIRATION("10014", "token过期失效", "token过期失效"),

  /**
   * payload失效
   */
  PALLOAD_INVALID("10015", "payload失效", "payload失效"),

  /**
   * 上传失败
   */
  UPLOAD_FAILED("10016", "上传失败", "上传失败"),

  /**
   * appKey不存在 确认appKey是否正确
   */
  APPKEY_NOTHINGNESS("10017", "appKey不存在", "确认appKey是否正确"),

  /**
   * 验证码不能为空
   */
  CODE_ISNULL("10018", "验证码不能为空", "验证码不能为空"),
  /**
   * appkey和appSecret不匹配
   */
  APPKEY_MISMATCHING("10030", "appkey和appSecret不匹配", "appkey和appSecret不匹配"),

  /**
   * 数据异常 接口调用异常
   */
  DATA_ERROR("49999", "接口调用异常", "接口调用异常"),

  /**
   * 数据异常 接口调用异常
   */
  DATA_EMPTY("50000", "未查询到数据", "未查询到数据"),

  /**
   * 手机号已经存在
   */
  MOBILE_EXISTS("50001", "手机号已经存在", "手机号已经存在"),

  /**
   * 手机号不存在
   */
  MOBILE_NOT_EXISTS("50002", "手机号不存在", "手机号不存在"),

  /**
   * 手机号格式错误
   */
  MOBILE_INCORRECT("50003", "请输入正确手机号", "手机号格式不正确"),

  /**
   * 账号已经存在
   */
  ACCOUNT_EXISTS("50011", "账号已经存在", "账号已经存在"),
  /**
   * 账号不存在
   */
  ACCOUNT_NOT_EXISTS("50012", "账号不存在", "账号不存在");


  /**
   * 状态码
   */
  private final String code;
  /**
   * 返回消息
   */
  private final String msg;

  /**
   * 状态码描述
   */
  private final String desc;

  ResultCode(String code, String msg, String desc) {
    this.code = code;
    this.msg = msg;
    this.desc = desc;
  }

  public String getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

  public String getDesc() {
    return desc;
  }
}
