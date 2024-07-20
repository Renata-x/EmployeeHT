package cn.xll.util.json.gson;



import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * @author 李昊哲
 * @version 1.0
 */
public class LocalDateAdapter implements JsonDeserializer<LocalDate>, JsonSerializer<LocalDate> {
  private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
