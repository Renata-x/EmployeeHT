package cn.xll.util.json.gson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author 李昊哲
 * @version 1.0
 */
// @Configuration
public class GsonConfig {

  // @Bean
  public Gson gson() {
    return new GsonBuilder()
        .setDateFormat("yyyy-MM-dd HH:mm:ss") // 设置日期格式
        .registerTypeAdapter(Date.class, new DateAdapter()) // 注册Date类型的适配器
        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()) // 注册LocalDate类型的适配器
        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()) // 注册LocalDateTime类型的适配器
        .create();
  }

  static class DateAdapter implements JsonDeserializer<Date>, JsonSerializer<Date> {
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
      return new JsonPrimitive(dateFormat.format(src));
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      try {
        return dateFormat.parse(json.getAsString());
      } catch (Exception e) {
        throw new JsonParseException(e);
      }
    }
  }

  static class LocalDateAdapter implements JsonDeserializer<LocalDate>, JsonSerializer<LocalDate> {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
      return new JsonPrimitive(dateTimeFormatter.format(src));
    }

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      try {
        return LocalDate.parse(json.getAsString(), dateTimeFormatter);
      } catch (Exception e) {
        throw new JsonParseException(e);
      }
    }
  }

  static class LocalDateTimeAdapter implements JsonDeserializer<LocalDateTime>, JsonSerializer<LocalDateTime> {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
      return new JsonPrimitive(dateTimeFormatter.format(src));
    }

    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      try {
        return LocalDateTime.parse(json.getAsString(), dateTimeFormatter);
      } catch (Exception e) {
        throw new JsonParseException(e);
      }
    }
  }
}
