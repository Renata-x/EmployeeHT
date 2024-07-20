package cn.xll.util.factory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 李昊哲
 * @version 1.0.0
 */
public class BeanFactory {
  // 存储单例对象
  private final Map<String, Object> beanList = new ConcurrentHashMap<>();
  private final Properties properties = new Properties();
  private static final BeanFactory beanFactory = new BeanFactory();

  private BeanFactory() {
    try {
      properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("ioc/application.yml"));
      Enumeration<Object> keys = properties.keys();
      while (keys.hasMoreElements()) {
        String beanName = keys.nextElement().toString();
        getBean(beanName);
      }
    } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException |
             IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }

  }

  public static BeanFactory build() {
    return beanFactory;
  }

  public Object getBean(String beanName) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
    if (!beanList.containsKey(beanName)) {
      String className = properties.getProperty(beanName);
      Class<?> aClass = Class.forName(className);
      Constructor<?> constructor = aClass.getConstructor();
      Object instance = constructor.newInstance();
      beanList.put(beanName, instance);
    }
    return beanList.get(beanName);
  }
}
