package cn.sunjian.io_charset;
/**
 * 字符编码：练习
 * 	
 * 		获取系统编码格式
 * 
 * @author jack
 *
 */
public class CharSetDemo {

	public static void main(String[] args) {

		System.out.println("系统默认编码："+
		
				System.getProperty("file.encoding"));
	}

}
