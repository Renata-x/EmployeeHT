package cn.xll.util.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 李昊哲
 * @version 1.0.0
 */
public class SingleBeanFactory {
  private static final SingleBeanFactory instance = new SingleBeanFactory();

  private final Map<String, Object> map = new ConcurrentHashMap<String, Object>();

  private SingleBeanFactory() {

  }

  public static SingleBeanFactory build() {
    return instance;
  }

  public Object newInstance(String beanId, String beanClass) {
    if (map.containsKey(beanId)) {
      return map.get(beanId);
    }
    try {
      Object value = Class.forName(beanClass).getDeclaredConstructor().newInstance();
      map.put(beanId, value);
      return value;
    } catch (ClassNotFoundException | SecurityException | InstantiationException | IllegalAccessException
             | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
      return null;
    }
  }
}
