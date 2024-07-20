package cn.xll.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * 日期工具类
 *
 * @author 李昊哲
 * @version 1.0
 */
public class DateUtil {

  /**
   * 默认时区
   */
  private final static String timeZone = "Asia/Shanghai";
  /**
   * 默认时区为东 8 区
   */
  private final static ZoneOffset zoneOffset = ZoneOffset.of("+8");

  /**
   * 默认时间字符串模板
   */
  private final static String pattern = "yyyy-MM-dd HH:mm:ss";

  /**
   * 获取当前系统日期
   *
   * @return 当前系统日期
   */
  public static Date date() {
    return new Date();
  }

  /**
   * 获取当前系统日期日期字符串
   *
   * @return 当前系统日期字符串
   */
  public static String now() {
    return format(new Date());
  }

  /**
   * 获取当前系统日期日期字符串
   *
   * @param pattern 日期格式化字符串模板
   * @return 当前系统日期字符串
   */
  public static String now(String pattern) {
    return format(new Date(), pattern);
  }


  /**
   * 日期对象格式化为字符串
   *
   * @param date Date对象
   * @return Date对象格式化后的日期字符串
   */
  public static String format(Date date) {
    return format(date, pattern);
  }

  /**
   * 日期对象格式化为字符串
   *
   * @param date    Date对象
   * @param pattern 日期格式化字符串模板
   * @return Date对象格式化后的日期字符串
   */
  public static String format(Date date, String pattern) {
    if (date == null) {
      return null;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    return dateFormat.format(date);
  }

  /**
   * 日期对象格式化为字符串
   *
   * @param date     Date对象
   * @param pattern  日期格式化字符串模板
   * @param timeZone 时区
   * @return Date对象格式化后的日期字符串
   */
  public static String format(Date date, String pattern, String timeZone) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
    return dateFormat.format(date);
  }

  /**
   * 获取根据时间毫秒数获取日期
   *
   * @param time 时间毫秒数
   * @return 日期
   */
  public static Date parse(long time) {
    return new Date(time);
  }

  /**
   * 将日期字符串解析为日期对象
   *
   * @param src 日期字符串
   * @return 日期字符串解析后日期对象
   * @throws ParseException 日期解析异常
   */
  public static Date parse(String src) throws ParseException {
    return parse(src, pattern);
  }

  /**
   * 将日期字符串解析为日期对象
   *
   * @param src     日期字符串
   * @param pattern 日期格式化字符串模板
   * @return 日期字符串解析后日期对象
   * @throws ParseException 日期解析异常
   */
  public static Date parse(String src, String pattern) throws ParseException {
    return new SimpleDateFormat(pattern).parse(src);
  }

  /**
   * 将日期字符串解析为日期对象
   *
   * @param src      日期字符串
   * @param pattern  日期格式化字符串模板
   * @param timeZone 时区
   * @return 日期字符串解析后日期对象
   * @throws ParseException 日期解析异常
   */
  public static Date parse(String src, String pattern, String timeZone) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
    return dateFormat.parse(src);
  }

  /**
   * 获取系统当前日期时间毫秒数
   *
   * @return 当前时间毫秒数
   */
  public static long getTime() {
    return getTime(new Date());
  }

  /**
   * 获取日期时间毫秒数
   *
   * @param date 日期
   * @return 时间毫秒数
   */
  public static long getTime(Date date) {
    return date.getTime();
  }

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
   * 生成范围的随机时间，位于[start,end)范围内 时间倒序排列
   *
   * @param start 开始时间格式字符串
   * @param end   结束时间格式字符串
   * @param count 生成时间数量
   * @return 随机时间的集合
   */
  public static List<Date> random(String start, String end, int count) throws ParseException {
    return random(parse(start), parse(end), count);
  }

  /**
   * 生成范围的随机时间，位于[start,end)范围内 时间倒序排列
   *
   * @param start 开始时间
   * @param end   结束时间
   * @param count 生成时间数量
   * @return 随机时间的集合
   */
  public static List<Date> random(Date start, Date end, int count) {
    return ThreadLocalRandom.current()
        .longs(count, start.getTime(), end.getTime())
        .mapToObj(Date::new).sorted(Date::compareTo).collect(Collectors.toList());
  }

  /**
   * 生成范围的随机时间，位于[start,end)范围内 时间倒序排列
   *
   * @param start 开始时间
   * @param end   结束时间
   * @param count 生成时间数量
   * @return 随机时间的集合
   */
  public static List<LocalDate> random(LocalDate start, LocalDate end, int count) {
    List<Date> dateList = ThreadLocalRandom.current()
        .longs(count, LocalDateUtil.getMilliSeconds(start), LocalDateUtil.getMilliSeconds(end))
        .mapToObj(Date::new).sorted(Date::compareTo).toList();
    return dateList.stream().map(DateUtil::toLocalDate).collect(Collectors.toList());
  }

  /**
   * 生成范围的随机时间，位于[start,end)范围内 时间倒序排列
   *
   * @param start 开始时间
   * @param end   结束时间
   * @param count 生成时间数量
   * @return 随机时间的集合
   */
  public static List<LocalDateTime> random(LocalDateTime start, LocalDateTime end, int count) {
    List<Date> dateList = ThreadLocalRandom.current()
        .longs(count, LocalDateTimeUtil.getTime(start), LocalDateTimeUtil.getTime(end))
        .mapToObj(Date::new).sorted(Date::compareTo).toList();

    return dateList.stream().map(DateUtil::toLocalDateTime).collect(Collectors.toList());
  }

  /**
   * LocalDate 转 Date
   *
   * @param localDate LocalDate对象
   * @return Date对象
   */
  public static Date from(LocalDate localDate) {
    return from(localDate, zoneOffset);
  }

  /**
   * LocalDate 转 Date
   *
   * @param localDate LocalDate对象
   * @param zoneId    zoneId
   * @return Date对象
   */
  public static Date from(LocalDate localDate, String zoneId) {
    return from(localDate, ZoneOffset.of(zoneId));
  }

  /**
   * LocalDate 转 Date
   *
   * @param localDate  LocalDate对象
   * @param zoneOffset 时区
   * @return Date对象
   */

  public static Date from(LocalDate localDate, ZoneOffset zoneOffset) {
    return Date.from(localDate.atStartOfDay(zoneOffset).toInstant());
  }

  /**
   * LocalDateTime 转 Date
   *
   * @param localDateTime LocalDateTime对象
   * @return Date对象
   */
  public static Date from(LocalDateTime localDateTime) {
    return from(localDateTime, zoneOffset);
  }


  /**
   * LocalDateTime 转 Date
   *
   * @param localDateTime LocalDateTime
   * @param zoneId        zoneId
   * @return Date对象
   */
  public static Date from(LocalDateTime localDateTime, String zoneId) {
    return from(localDateTime, ZoneOffset.of(zoneId));
  }

  /**
   * LocalDateTime 转 Date
   *
   * @param localDateTime LocalDateTime对象
   * @param zoneOffset    时区
   * @return Date对象
   */

  private static Date from(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
    return Date.from(localDateTime.toInstant(zoneOffset));
  }

  /**
   * Date 转 LocalDate
   *
   * @param date Date对象
   * @return LocalDateTime对象
   */
  public static LocalDate toLocalDate(Date date) {
    return toLocalDate(date, zoneOffset);
  }

  /**
   * Date 转 LocalDate
   *
   * @param date   Date对象
   * @param zoneId 时区ID
   * @return LocalDateTime对象
   */
  public static LocalDate toLocalDate(Date date, String zoneId) {
    return toLocalDate(date, ZoneOffset.of(zoneId));
  }

  /**
   * Date 转 LocalDate
   *
   * @param date       Date对象
   * @param zoneOffset 时区
   * @return LocalDate对象
   */
  public static LocalDate toLocalDate(Date date, ZoneOffset zoneOffset) {
    return date.toInstant().atOffset(zoneOffset).toLocalDate();
  }

  /**
   * Date 转 LocalDate
   *
   * @param date Date对象
   * @return Date对象
   */
  public static LocalDateTime toLocalDateTime(Date date) {
    return toLocalDateTime(date, zoneOffset);
  }


  /**
   * Date 转 LocalDate
   *
   * @param date   Date对象
   * @param zoneId 时区ID
   * @return LocalDateTime对象
   */
  public static LocalDateTime toLocalDateTime(Date date, String zoneId) {
    return toLocalDateTime(date, ZoneOffset.of(zoneId));
  }

  /**
   * Date 转 LocalDateTime
   *
   * @param date       Date对象
   * @param zoneOffset 时区
   * @return LocalDateTime对象
   */
  public static LocalDateTime toLocalDateTime(Date date, ZoneOffset zoneOffset) {
    return date.toInstant().atOffset(zoneOffset).toLocalDateTime();
  }

  /**
   * 获取某日期所在年份的第一天的日期
   *
   * @param date 日期
   * @return 所在年份的第一天的日期
   * @throws ParseException ParseException
   */
  public static Date firstDateOfYear(Date date) throws ParseException {
    return parse(format(date, "yyyy"), "yyyy");
  }

  /**
   * 获取某日期所在年份的最后一天的日期
   *
   * @param date 日期
   * @return 所在年份的最后一天的日期
   * @throws ParseException ParseException
   */
  public static Date lastDateOfYear(Date date) throws ParseException {
    return parse(format(date, "yyyy") + "-12-31 23:59:59", pattern);
  }

  /**
   * 获取某日期所在月份的第一天的日期
   *
   * @param date 日期
   * @return 所在月份的第一天的日期
   * @throws ParseException ParseException
   */
  public static Date firstDateOfMonth(Date date) throws ParseException {
    return parse(format(date, "yyyy-MM") + "-01", "yyyy-MM-dd");
  }

  /**
   * 获取某日期所在月份的最后一天的日期
   *
   * @param date 日期
   * @return 所在月份的最后一天的日期
   * @throws ParseException ParseException
   */
  public static Date lastDateOfMonth(Date date) throws ParseException {
    return from(toLocalDateTime(date).with(TemporalAdjusters.lastDayOfMonth()));
  }
}
