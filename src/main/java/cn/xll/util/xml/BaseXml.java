package cn.xll.util.xml;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Iterator;

/**
 * @author 李昊哲
 * @version 1.0.0
 */
public abstract class BaseXml {
  /**
   * 读取默认xml文件的名字为ApplicationContext.xml
   */
  private final static String config = "applicationContext.xml";

  /**
   * 获取类路径下自定义的xml文件的Document对象
   *
   * @return Document
   * @throws DocumentException DocumentException
   */
  public static Document getDocument() throws DocumentException {
    return getDocument(config);
  }

  /**
   * 获取类路径下自定义的xml文件的Document对象
   *
   * @param config 类路径下自定义xml文件
   * @return Document
   * @throws DocumentException DocumentException
   */
  public static Document getDocument(String config) throws DocumentException {
    return new SAXReader().read(BaseXml.class.getClassLoader().getResource(config));
  }

  /**
   * 获取类路径下自定义的xml文件的Document对象
   *
   * @param url xml文件URL
   * @return Document
   * @throws DocumentException DocumentException
   */
  public static Document getDocument(URL url) throws DocumentException {
    return new SAXReader().read(url);
  }

  /**
   * 获取类路径下自定义的xml文件的Document对象
   *
   * @param reader xml文件的Reader
   * @return Document
   * @throws DocumentException DocumentException
   */
  public static Document getDocument(Reader reader) throws DocumentException {
    return new SAXReader().read(reader);
  }

  /**
   * 获取类路径下自定义的xml文件的Document对象
   *
   * @param inputStream xml文件InputStream
   * @return Document
   * @throws DocumentException DocumentException
   */
  public static Document getDocument(InputStream inputStream) throws DocumentException {
    return new SAXReader().read(inputStream);
  }

  /**
   * 获取xml文件的根元素
   *
   * @return 根元素
   * @throws DocumentException DocumentException
   */
  public static Element getRootElement() throws DocumentException {
    return getDocument(config).getRootElement();
  }

  /**
   * 获取xml文件的根元素
   *
   * @param config 自定义类路径下xml文件
   * @return 根元素
   * @throws DocumentException DocumentException
   */
  public static Element getRootElement(String config) throws DocumentException {
    return getDocument(config).getRootElement();
  }

  /**
   * 获取xml文件的根元素
   *
   * @param url URL
   * @return 根元素
   * @throws DocumentException DocumentException
   */
  public static Element getRootElement(URL url) throws DocumentException {
    return getDocument(url).getRootElement();
  }

  /**
   * 获取xml文件的根元素
   *
   * @param reader Reader对象
   * @return 根元素
   * @throws DocumentException DocumentException
   */
  public static Element getRootElement(Reader reader) throws DocumentException {
    return getDocument(reader).getRootElement();
  }

  /**
   * 获取xml文件的根元素
   *
   * @param inputStream InputStream
   * @return 根元素
   * @throws DocumentException DocumentException
   */
  public static Element getRootElement(InputStream inputStream) throws DocumentException {
    return getDocument(inputStream).getRootElement();
  }

  /**
   * 获取xml文件的根元素
   *
   * @param document Document对象
   * @return 根元素
   * @throws DocumentException DocumentException
   */
  public static Element getRootElement(Document document) throws DocumentException {
    return document.getRootElement();
  }

  /**
   * 输出元素的所有子元素的详细信息
   *
   * @param element xml元素
   */
  public static void printElements(Element element) {
    System.out.println("获取当前名称:" + element.getName());
    // 获取属性信息
    Iterator<Attribute> attributes = element.attributeIterator();
    while (attributes.hasNext()) {
      Attribute attribute = attributes.next();
      System.out.println("属性:" + attribute.getName() + "---" + attribute.getText());
    }
    // 获取属性value
    if (!StringUtils.isEmpty(element.getTextTrim())) {
      System.out.println("value:" + element.getTextTrim());
    }
    // 使用迭代器遍历,继续遍历子元素
    Iterator<Element> elementIterator = element.elementIterator();
    while (elementIterator.hasNext()) {
      Element next = elementIterator.next();
      // 递归调用
      printElements(next);
    }
  }

  /**
   * 输出元素的所有子元素的详细信息
   *
   * @param config 类路径下xml文件
   */
  public static void printElements(String config) throws DocumentException {
    printElements(getRootElement(config));
  }

  /**
   * 类路径下默认xml文件ApplicationContext.xml输出元素的所有子元素的详细信息
   */
  public static void printElements() throws DocumentException {
    printElements(getRootElement(config));
  }
}
