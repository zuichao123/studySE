package cn.sunjian.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

import sun.misc.BASE64Encoder;

/**
 * MD5加密和解密
 * @author sunjian
 *
 */
public class MD5Util {
	
	/**
	 * md5 加密
	 * @param message 加密的字符串
	 * @return 加密后的字符串
	 */
	public static String encode(String message){
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] bs = md.digest(message.getBytes());
			return new BASE64Encoder().encode(bs);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 生成32位的MD5加密码
	 * @param message 加密的字符串
	 * @return 加密后的字符串
	 */
	public static String encrypt(String message){
		
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("md5");
			char[] charArray = message.toCharArray();
			byte[] byteArray = new byte[charArray.length];
			for(int i=0;i<charArray.length;i++){
				byteArray[i] = (byte) charArray[i];
			}
			byte[] md5Bytes = md5.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for(int i=0;i<md5Bytes.length;i++){
				int val = ((int)md5Bytes[i]) & 0xff;
				if (val < 16) {
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 推荐使用
	 * commons.codec.jar包中的
	 * 根据Apache工具类DigestUtils实现
	 * @param message 加密的字符串
	 * @return 加密后的字符串
	 */
	public static String encryptMD5(String message){
		return DigestUtils.md5Hex(message);
	}
	
	
	public static void main(String[] args) {
		String string = "1234qwer";

		System.out.println(MD5Util.encode(string));
		System.out.println(MD5Util.encrypt(string));
		System.out.println(MD5Util.encryptMD5(string));
	}
}
