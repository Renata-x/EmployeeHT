package cn.xll.util.json.gson;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 李昊哲
 * @version 1.0
 */
public class DateAdapter implements JsonDeserializer<Date>, JsonSerializer<Date> {
  private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
