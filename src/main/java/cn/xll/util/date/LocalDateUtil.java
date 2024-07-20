package cn.xll.util.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * LocalDate 工具类
 *
 * @author 李昊哲
 * @version 1.0
 */
public class LocalDateUtil {
  /**
   * 日期格式化模板字符串
   */
  private static final String formatter = "yyyy-MM-dd";

  /**
   * 默认时区为东 8 区
   */
  private final static ZoneOffset zoneOffset = ZoneOffset.of("+8");

  /**
   * 将LocalDate格式化为默认的日期格式字符串 例如：1983-11-22
   *
   * @param localDate 欲被格式化的日期
   * @return 根据日期格式字符串模板格式化的时间字符串
   */
  public static String format(LocalDate localDate) {
    return format(localDate, formatter);
  }

  /**
   * 将LocalDate格式化为指定的日期格式字符串
   *
   * @param localDate 欲被格式化的日期
   * @param formatter 日期字符串模板
   * @return 根据日期格式字符串模板格式化的时间字符串
   */
  public static String format(LocalDate localDate, String formatter) {
    if (localDate == null) {
      return null;
    }
    return DateTimeFormatter.ofPattern(formatter).format(localDate);
    // return localDate.format(DateTimeFormatter.ofPattern(formatter));
  }

  /**
   * 根据默认日期字符串模板将日期格式字符串解析为LocalDate
   * 默认日期字符串模板 yyyy-MM-dd
   *
   * @param text 日期格式字符串
   * @return LocalDate
   */
  public static LocalDate parse(String text) {
    return parse(text, formatter);
  }

  /**
   * 根据日期字符串模板将日期格式字符串解析为LocalDate
   *
   * @param text      日期格式字符串
   * @param formatter 日期格式字符串模板
   * @return LocalDate
   */
  public static LocalDate parse(String text, String formatter) {
    return LocalDate.parse(text, DateTimeFormatter.ofPattern(formatter));
  }

  /**
   * Date类型的时间转为LocalDateTime类型的时间
   *
   * @param date Date
   * @return LocalDate
   */
  public static LocalDate from(Date date) {
    return from(date, zoneOffset);
  }

  /**
   * Date类型的时间转为LocalDateTime类型的时间
   *
   * @param date   Date
   * @param zoneId 时区ID
   * @return LocalDate
   */
  public static LocalDate from(Date date, String zoneId) {
    return from(date, ZoneOffset.of(zoneId));
  }

  /**
   * Date类型的时间转为LocalDateTime类型的时间
   *
   * @param date Date
   * @param zone 时区
   * @return LocalDate
   */
  public static LocalDate from(Date date, ZoneId zone) {
    return date.toInstant().atZone(zone).toLocalDate();
  }

  /**
   * Date类型的时间转为LocalDateTime类型的时间
   *
   * @param date       Date
   * @param zoneOffset 时区
   * @return LocalDate
   */
  public static LocalDate from(Date date, ZoneOffset zoneOffset) {
    return date.toInstant().atOffset(zoneOffset).toLocalDate();
  }

  /**
   * LocalDate 转 Date
   *
   * @param localDate LocalDate对象
   * @return Date对象
   */
  public static Date toDate(LocalDate localDate) {
    return toDate(localDate, zoneOffset);
  }

  /**
   * LocalDate 转 Date
   *
   * @param localDate LocalDate对象
   * @param zoneId    zoneId
   * @return Date对象
   */
  public static Date toDate(LocalDate localDate, String zoneId) {
    return toDate(localDate, ZoneOffset.of(zoneId));
  }

  /**
   * LocalDate 转 Date
   *
   * @param localDate  LocalDate对象
   * @param zoneOffset 时区
   * @return Date对象
   */

  public static Date toDate(LocalDate localDate, ZoneOffset zoneOffset) {
    return Date.from(localDate.atStartOfDay(zoneOffset).toInstant());
  }

  /**
   * LocalDateTime 转 LocalDateTime
   *
   * @param localDate LocalDate对象
   * @return LocalDateTime对象
   */
  public static LocalDateTime toLocalDateTime(LocalDate localDate) {
    return toLocalDateTime(localDate, zoneOffset);
  }

  /**
   * LocalDateTime 转 LocalDateTime
   *
   * @param localDate LocalDate对象
   * @param zoneId    时区ID
   * @return LocalDateTime对象
   */
  public static LocalDateTime toLocalDateTime(LocalDate localDate, String zoneId) {
    return toLocalDateTime(localDate, ZoneOffset.of(zoneId));
  }

  /**
   * LocalDateTime 转 LocalDateTime
   *
   * @param localDate  LocalDate对象
   * @param zoneOffset 时区
   * @return LocalDateTime对象
   */
  public static LocalDateTime toLocalDateTime(LocalDate localDate, ZoneOffset zoneOffset) {
    return localDate.atStartOfDay(zoneOffset).toLocalDateTime();
  }

  /**
   * 获取时间毫秒数
   *
   * @return 时间毫秒数
   */
  public static long getMilliSeconds() {
    return getMilliSeconds(LocalDate.now());
  }

  /**
   * 获取时间毫秒数
   *
   * @param localDate LocalDate对象
   * @return 时间毫秒数
   */
  public static long getMilliSeconds(LocalDate localDate) {
    return getMilliSeconds(localDate, zoneOffset);
  }

  /**
   * 获取时间毫秒数
   *
   * @param localDate LocalDate对象
   * @param zoneId    时区ID
   * @return 时间毫秒数
   */
  public static long getMilliSeconds(LocalDate localDate, String zoneId) {
    return getMilliSeconds(localDate, ZoneOffset.of(zoneId));
  }

  /**
   * 获取时间毫秒数
   *
   * @param localDate  LocalDate对象
   * @param zoneOffset 时区
   * @return 时间毫秒数
   */
  public static long getMilliSeconds(LocalDate localDate, ZoneOffset zoneOffset) {
    return toLocalDateTime(localDate, zoneOffset).toInstant(zoneOffset).toEpochMilli();
  }

  /**
   * 时间毫秒数转LocalDate 使用系统默认时区
   *
   * @param milliSeconds 时间毫秒数
   * @return LocalDate
   */
  public static LocalDate parseMilliSeconds(Long milliSeconds) {
    return parseMilliSeconds(milliSeconds, ZoneId.systemDefault());
  }

  /**
   * 时间毫秒数转LocalDate
   *
   * @param milliSeconds 时间毫秒数
   * @param zoneId       时区
   * @return LocalDate
   */
  public static LocalDate parseMilliSeconds(Long milliSeconds, ZoneId zoneId) {
    return Instant.ofEpochMilli(milliSeconds).atZone(zoneId).toLocalDate();
  }

  /**
   * 随机生成 LocalDate 集合
   *
   * @param start 开始日期字符串 日期字符串格式 yyyy-MM-dd
   * @param end   结束日期字符串 日期字符串格式 yyyy-MM-dd
   * @param count 随机数量
   * @return LocalDate LocalDate集合
   */
  public static List<LocalDate> random(String start, String end, int count) {
    return random(start, end, count, formatter);
  }

  /**
   * 随机生成 LocalDate 集合
   *
   * @param start     开始日期字符串
   * @param end       结束日期字符串
   * @param count     随机数量
   * @param formatter 日期字符串模板
   * @return LocalDate LocalDate集合
   */
  public static List<LocalDate> random(String start, String end, int count, String formatter) {
    return random(parse(start, formatter), parse(end, formatter), count);
  }

  /**
   * 随机生成 LocalDate 集合
   *
   * @param start 开始日期
   * @param end   结束日期
   * @param count 随机数量
   * @return LocalDate LocalDate集合
   */
  public static List<LocalDate> random(LocalDate start, LocalDate end, int count) {
    List<LocalDate> list = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      list.add(parseMilliSeconds(ThreadLocalRandom.current().nextLong(getMilliSeconds(start), getMilliSeconds(end))));
    }
    if (!list.isEmpty()) {
      list.sort(LocalDate::compareTo);
    }
    return list;
  }
}
