package cn.xll.util.spring;

import cn.xll.util.factory.MultipleBeanFactory;
import cn.xll.util.factory.SingleBeanFactory;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.util.List;

import static cn.xll.util.xml.BaseXml.getRootElement;

/**
 * @author 李昊哲
 * @version 1.0.0
 */
public class ClassPathXmlApplicationContext {
  /**
   * 默认配置文件
   */
  private static final String applicationContextConfig = "ApplicationContext.xml";
  /**
   * 自定义配置文件类路径位置
   */
  private final String config;
  /**
   * 是否单利模式初始值
   */
  private boolean multiple;

  /**
   * 读取默认配置文件，默认为单例模式
   */
  public ClassPathXmlApplicationContext() {
    this(applicationContextConfig);
  }

  /**
   * 读取自定义类路径下的配置文件，默认为单例模式
   *
   * @param config 自定义类路径下的配置文件
   */
  public ClassPathXmlApplicationContext(String config) {
    this.config = config;
  }

  /**
   * 读取默认配置文件，是否为单例模式可配置
   *
   * @param multiple true为多例模式 false为单例模式
   */
  public ClassPathXmlApplicationContext(boolean multiple) {
    this(applicationContextConfig, multiple);
  }

  /**
   * 读取自定义类路径下的配置文件，是否为单例模式可配置
   *
   * @param config   自定义类路径下的配置文件
   * @param multiple true为多例模式 false为单例模式
   */
  public ClassPathXmlApplicationContext(String config, boolean multiple) {
    this.config = config;
    this.multiple = multiple;
  }

  /**
   * @param beanId 对象标识
   * @return 返回单例对象
   * @throws Exception Exception
   */
  public Object getBean(String beanId) throws Exception {
    // 1. 读取配置文件
    List<Element> elements = readerXml();
    if (elements == null) {
      throw new Exception("该配置文件没有子元素");
    }
    // 2. 使用beanId查找对应的class地址
    String beanClass = findXmlByIDClass(elements, beanId);
    if (beanClass.isEmpty()) {
      throw new Exception("未找到对应的class地址");
    }
    // 3. 使用反射机制初始化，对象
    // multiple为true实例化对象为多例，
    // multiple为false实例化对象为单例，默认为false
    if (multiple) {
      return MultipleBeanFactory.build().newInstance(beanClass);
    }
    return SingleBeanFactory.build().newInstance(beanId, beanClass);
  }

  /**
   * 读取配置文件信息
   *
   * @return 元素集合
   * @throws DocumentException DocumentException
   */
  public List<Element> readerXml() throws DocumentException {
    if (config.isEmpty()) {
      throw new DocumentException("xml路径为空...");
    }
    // 获取根节点信息
    Element rootElement = getRootElement(config);
    // 获取子节点
    List<Element> elements = rootElement.elements();
    if (elements == null || elements.isEmpty()) {
      return null;
    }
    return elements;
  }

  /**
   * 使用 beanId 查找该 Class 地址
   *
   * @param elements 元素集合
   * @param beanId   对象标识
   * @return 完整类名称
   * @throws Exception Exception
   */
  public String findXmlByIDClass(List<Element> elements, String beanId) throws Exception {
    for (Element element : elements) {
      // 读取节点上是否有value
      String beanIdValue = element.attributeValue("id");
      if (beanIdValue == null) {
        throw new Exception("使用该beanId为查找到元素");
      }
      if (!beanIdValue.equals(beanId)) {
        continue;
      }
      // 获取Class地址属性
      String classPath = element.attributeValue("class");
      if (!classPath.isEmpty()) {
        return classPath;
      }
    }
    return null;
  }
}
