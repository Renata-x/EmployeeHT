package cn.xll.util.string;

import java.lang.reflect.Field;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 字符串工具类
 *
 * @author 李昊哲
 * @version 1.0
 */
public class StringUtil {
  /**
   * 时间补零占位
   *
   * @param time 时间
   * @return 补零后的字符串
   */
  public static String zeroCompensation(int time) {
    if (time < 10) {
      return "0" + time;
    }
    return String.valueOf(time);
  }

  /**
   * 去除字符串左边的的空格
   *
   * @param string 原始字符串
   * @return 去除左边空格后的字符串
   */
  public static String ltrim(String string) {
    if (string == null) {
      throw new NullPointerException();
    } else {
      return string.replaceAll("^\\s+", "");
    }
  }

  /**
   * 去除字符串右边的的空格
   *
   * @param string 原始字符串
   * @return 去除右边空格后的字符串
   */
  public static String rtrim(String string) {
    if (string == null) {
      throw new NullPointerException();
    } else {
      return string.replaceAll("\\s+$", "");
    }
  }

  /**
   * 生成的UUID是带-的字符串，类似于：a5c8a5e8-df2b-4706-bea4-08d0939410e3
   *
   * @return 带-的字符串
   */
  public static String randomUUID() {
    return UUID.randomUUID().toString();
  }

  /**
   * 生成的是不带-的字符串，类似于：b17f24ff026d40949c85a24f4f375d42
   *
   * @return 不带-的字符串
   */
  public static String simpleUUID() {
    return randomUUID().replace("-", "");
  }

  /**
   * 随机字符串
   *
   * @param count 随机字符串长度
   * @return 随机字符串
   */
  public static String random(int count) {
    String codePool = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; i++) {
      sb.append(codePool.charAt(ThreadLocalRandom.current().nextInt(codePool.length())));
    }
    return sb.toString();
  }

  /**
   * 随机数字
   *
   * @param count 随机数字长度
   * @return 随机数字
   */
  public static String randomNumeric(int count) {
    String codePool = "0123456789";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; i++) {
      sb.append(codePool.charAt(ThreadLocalRandom.current().nextInt(codePool.length())));
    }
    return sb.toString();
  }

  /**
   * 判断字符串是否为空
   *
   * @param string 判断参数 string 是否为空
   * @return 参数为 null 或者 参数的长度为零 返回 true 其余情况返回 false
   */
  public static boolean isEmpty(String string) {
    return string == null || string.isEmpty();
  }

  /**
   * 判断字符串是否为空
   *
   * @param string 判断参数 string 是否为空
   * @return 参数为 null 或者 参数收尾两端去掉空格后的长度为零 返回 true 其余情况返回 false
   */
  public static boolean isBlank(String string) {
    return string == null || string.trim().isEmpty();
  }

  /**
   * 获取文件后缀名
   *
   * @param fileName 原始文件名
   * @return 文件后缀名
   */
  public static String getExtension(String fileName) {
    int index = fileName.lastIndexOf(".");
    if (index == -1) {
      return "";
    }
    return fileName.substring(index + 1);
  }

  /**
   * 对象转 csv文件格式字符串
   *
   * @param obj 被转换的对象
   * @return csv 文件格式字符串
   * @throws IllegalAccessException IllegalAccessException
   */
  public static String format2CSV(Object obj) throws IllegalAccessException {
    if (obj == null) {
      return null;
    }
    // 利用反射获取该对象的 类对象
    Class<?> aClass = obj.getClass();
    // 获取该类对象的是所有属性
    Field[] fields = aClass.getDeclaredFields();
    // 保存最终结果
    StringBuilder buffer = new StringBuilder();
    // 遍历属性
    for (Field field : fields) {
      // 设置私有属性可以访问权限
      field.setAccessible(true);
      // 将属性值全部转为字符串
      String string = String.valueOf(field.get(obj));
      // 将读取到的字符串内容 按照 csv 文件格式封装到 StringBuilder 对象 中
      buffer.append(string).append(",");
    }
    // 返回 最终结果 返回前 独钓字符串中最后一个逗号
    return buffer.substring(0, buffer.length() - 1);
  }
}
