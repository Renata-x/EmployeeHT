package cn.xll.util.factory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author 李昊哲
 * @version 1.0.0
 */
public class MultipleBeanFactory {
  private static final MultipleBeanFactory instance = new MultipleBeanFactory();

  private MultipleBeanFactory() {
  }

  public static MultipleBeanFactory build() {
    return instance;
  }

  @SuppressWarnings("unchecked")
  public <T> T newInstance(String className) {
    try {
      return (T) Class.forName(className).getDeclaredConstructor().newInstance();
    } catch (ClassNotFoundException | SecurityException | InstantiationException | IllegalAccessException
             | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
      return null;
    }
  }
}
