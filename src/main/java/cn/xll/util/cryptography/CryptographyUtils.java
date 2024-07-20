package cn.xll.util.cryptography;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 加密解密
 *
 * @author 李昊哲
 * @version 1.0
 */
public class CryptographyUtils {
  /**
   * Base64 加密字符串
   *
   * @param string 原始字符串
   * @return Base64字符串
   */
  public static String base64Encode(String string) {
    return Base64.getEncoder().encodeToString(string.getBytes());
  }

  /**
   * Base64 解密字符串
   *
   * @param string Base64字符串
   * @return 原始字符串
   */
  public static String base64Decode(String string) {
    return new String(Base64.getDecoder().decode(string));
  }

  /**
   * 将字符串使用ase算法加密并返回加密后字符串的十六进制字符串
   *
   * @param src 欲被加密的字符串
   * @param key 秘钥 注意:要求秘钥为长度为十六个字符的字符串
   * @return 加密后字符串的十六进制字符串
   */
  public static String aesEncodeHexString(String src, String key) {
    return new SymmetricCrypto(SymmetricAlgorithm.AES, new String(key).getBytes()).encryptHex(src);
  }

  /**
   * 将使用ase算法加密后生产的十六进制字符串解密
   *
   * @param encryptHex 加密后生产的十六进制字符串解密
   * @param key        秘钥 注意:秘钥为长度为十六个字符的远秘钥字符串
   * @return 将加密后的字符串解密回来
   */
  public static String aesDecodeHexString(String encryptHex, String key) {
    return new SymmetricCrypto(SymmetricAlgorithm.AES, new String(key).getBytes()).decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
  }

  /**
   * 将字符串使用des算法加密并返回加密后字符串的十六进制字符串
   *
   * @param src 欲被加密的字符串
   * @param key 秘钥
   * @return 加密后字符串的十六进制字符串
   */
  public static String desEncodeHexString(String src, String key) {
    return new SymmetricCrypto(SymmetricAlgorithm.DESede, new String(key).getBytes()).encryptHex(src);
  }

  /**
   * 将使用des算法加密后生产的十六进制字符串解密
   *
   * @param encryptHex 加密后生产的十六进制字符串解密
   * @param key        原秘钥
   * @return 将加密后的字符串解密回来
   */
  public static String desDecodeHexString(String encryptHex, String key) {
    return new SymmetricCrypto(SymmetricAlgorithm.DESede, new String(key).getBytes()).decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
  }

  public static String md5(String src) throws NoSuchAlgorithmException {
    // 获取MD5算法的MessageDigest实例
    MessageDigest md5 = null;
    md5 = MessageDigest.getInstance("MD5");
    // 计算哈希值
    byte[] hash = md5.digest(src.getBytes());
    // 将哈希值转换为十六进制字符串
    StringBuilder sb = new StringBuilder();
    for (byte b : hash) {
      sb.append(String.format("%02x", b));
    }
    // e10adc3949ba59abbe56e057f20f883e
    return sb.toString();
  }

}
