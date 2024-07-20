package cn.xll.util.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


/**
 * LocalDateTime 工具类
 *
 * @author 李昊哲
 * @version 1.0
 */
public class LocalDateTimeUtil {
  /**
   * 时间格式化模板字符串
   */
  private static final String formatter = "yyyy-MM-dd HH:mm:ss";
  /**
   * 默认时区为东 8 区
   */
  private static final ZoneOffset zoneOffset = ZoneOffset.of("+8");

  /**
   * 获取当前时间格式字符串 yyyy-MM-dd HH:mm:ss
   *
   * @return 当前时间格式字符串 yyyy-MM-dd HH:mm:ss
   */
  public static String nowString() {
    return format(LocalDateTime.now(zoneOffset));
  }

  /**
   * 将LocalDateTime格式化为时间指定的时间格式字符串
   *
   * @param localDateTime 欲被格式化的时间
   * @return 根据时间格式字符串模板格式化的时间字符串
   */
  public static String format(LocalDateTime localDateTime) {
    return format(localDateTime, formatter);
  }

  /**
   * 将LocalDateTime格式化为时间指定的时间格式字符串
   *
   * @param localDateTime 欲被格式化的时间
   * @param formatter     时间字符串模板
   * @return 根据时间格式字符串模板格式化的时间字符串
   */
  public static String format(LocalDateTime localDateTime, String formatter) {
    if (localDateTime == null) {
      return null;
    }
    return DateTimeFormatter.ofPattern(formatter).format(localDateTime);
    // return localDateTime.format(DateTimeFormatter.ofPattern(formatter));
  }

  /**
   * 根据时间字符串模板将时间格式字符串解析为LocalDateTime
   *
   * @param text 时间字符串
   * @return LocalDateTime
   */
  public static LocalDateTime parse(String text) {
    return parse(text, formatter);
  }

  /**
   * 根据时间字符串模板将时间格式字符串解析为LocalDateTime
   *
   * @param text      时间字符串
   * @param formatter 时间字符串模板
   * @return LocalDateTime
   */
  public static LocalDateTime parse(String text, String formatter) {
    return LocalDateTime.parse(text, DateTimeFormatter.ofPattern(formatter));
  }

  /**
   * Date类型的时间转为LocalDateTime类型的时间
   *
   * @param date Date
   * @return LocalDate
   */
  public static LocalDateTime from(Date date) {
    return from(date, zoneOffset);
  }

  /**
   * Date类型的时间转为LocalDateTime类型的时间
   *
   * @param date   Date
   * @param zoneId 时区ID
   * @return LocalDate
   */
  public static LocalDateTime from(Date date, String zoneId) {
    return from(date, ZoneOffset.of(zoneId));
  }

  /**
   * Date类型的时间转为LocalDateTime类型的时间
   *
   * @param date Date
   * @param zone 时区
   * @return LocalDate
   */
  public static LocalDateTime from(Date date, ZoneId zone) {
    return date.toInstant().atZone(zone).toLocalDateTime();
  }

  /**
   * Date类型的时间转为LocalDateTime类型的时间
   *
   * @param date       Date
   * @param zoneOffset 时区
   * @return LocalDateTime
   */
  public static LocalDateTime from(Date date, ZoneOffset zoneOffset) {
    return date.toInstant().atOffset(zoneOffset).toLocalDateTime();
  }

  /**
   * LocalDate 转 Date
   *
   * @param localDateTime LocalDateTime对象
   * @return Date对象
   */
  public static Date toDate(LocalDateTime localDateTime) {
    return toDate(localDateTime, zoneOffset);
  }

  /**
   * LocalDate 转 Date
   *
   * @param localDateTime LocalDateTime对象
   * @param zoneId        zoneId
   * @return Date对象
   */
  public static Date toDate(LocalDateTime localDateTime, String zoneId) {
    return toDate(localDateTime, ZoneOffset.of(zoneId));
  }

  /**
   * LocalDate 转 Date
   *
   * @param localDateTime LocalDateTime对象
   * @param zoneOffset    时区
   * @return Date对象
   */

  public static Date toDate(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
    return Date.from(localDateTime.toInstant(zoneOffset));
  }

  /**
   * 获取当前时间毫秒数
   *
   * @return 当前时间毫秒数
   */
  public static long getTime() {
    return LocalDateTime.now(ZoneOffset.of("+8")).toInstant(ZoneOffset.of("+8")).toEpochMilli();
  }

  /**
   * 获取时间毫秒数
   *
   * @param localDateTime 日期时间
   * @return 当前时间毫秒数
   */
  public static long getTime(LocalDateTime localDateTime) {
    return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
  }

  /**
   * 时间毫秒数转LocalDateTime
   *
   * @param milliseconds 时间毫秒数
   * @return LocalDateTime
   */
  public static LocalDateTime parseMilliSeconds(Long milliseconds) {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(milliseconds), ZoneId.systemDefault());
  }

  /**
   * 时间毫秒数转LocalDateTime
   *
   * @param milliseconds 时间毫秒数
   * @param zoneId       ZoneId
   * @return LocalDateTime
   */
  public static LocalDateTime parseMilliSeconds(Long milliseconds, ZoneId zoneId) {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(milliseconds), zoneId);
  }

  /**
   * 随机生成 LocalDate 集合
   *
   * @param start 开始时间字符串 时间字符串格式 yyyy-MM-dd HH:mm:ss
   * @param end   结束时间字符串 时间字符串格式 yyyy-MM-dd HH:mm:ss
   * @param count 随机数量
   * @return LocalDateTime 集合
   */
  public static List<LocalDateTime> random(String start, String end, int count) {
    return random(start, end, count, formatter);
  }

  /**
   * 随机生成 LocalDateTime 集合
   *
   * @param start     开始时间字符串
   * @param end       结束时间字符串
   * @param count     随机数量
   * @param formatter 时间字符串模板
   * @return LocalDateTime LocalDateTime集合
   */
  public static List<LocalDateTime> random(String start, String end, int count, String formatter) {
    return random(parse(start, formatter), parse(end, formatter), count);
  }

  /**
   * 随机生成 LocalDateTime 集合
   *
   * @param start 开始时间
   * @param end   结束时间
   * @param count 随机数量
   * @return LocalDateTime 集合
   */
  public static List<LocalDateTime> random(LocalDateTime start, LocalDateTime end, int count) {
    List<LocalDateTime> list = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      list.add(parseMilliSeconds(ThreadLocalRandom.current().nextLong(getTime(start), getTime(end))));
    }
    if (!list.isEmpty()) {
      list.sort(LocalDateTime::compareTo);
    }
    return list;
  }
}
