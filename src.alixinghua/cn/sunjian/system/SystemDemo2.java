package cn.sunjian.system;

/**
 * System类练习：
 * 		
 * 		取得操作系统的属性	
 * 
 * @author jack
 *
 */
public class SystemDemo2 {

	public static void main(String[] args) {

//		System.getProperties().list(System.out);//列出系统的全部属性
		
		System.out.println("======================");
		
		System.out.println("系统版本："+System.getProperty("os.name") + System.getProperty("os.version") + System.getProperty("os.arch"));//系统版本
		
		System.out.println("系统用户："+System.getProperty("user.name"));//系统用户
		
		System.out.println("当前用户目录："+System.getProperty("user.home"));//当前用户目录
		
		System.out.println("当前用户工作目录："+System.getProperty("user.dir"));//当前用户工作目录
		
	}

}
