package com.weishengming.commom.json;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class MD5
{
  private static final Md5PasswordEncoder md5 = new Md5PasswordEncoder();

  public static String getMD5(String arg)
  {
    byte[] source = arg.getBytes();
    String str = null;
    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(source);
      byte[] tmp = md.digest();
      char[] chars = new char[32];
      int k = 0;
      for (int i = 0; i < 16; ++i)
      {
        byte byte0 = tmp[i];
        chars[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
        chars[(k++)] = hexDigits[(byte0 & 0xF)];
      }
      str = new String(chars);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return str;
  }

  public static String encodePassword(String password, Object stat) {
    return md5.encodePassword(password, stat);
  }
}
