package cn.sunjian.otherapi;

import java.io.IOException;

/**
 * Runtime:没有构造方法摘要，说明该类不可以创建对象。
 * 又发现还有非静态的方法。说明该类应该提供静态的返回该类对象的方法。
 * 而且只有一个，说明Runtime类使用单例设计模式。
 * 
 * @author sunjian
 *
 */
public class RuntimeDemo {

	public static void main(String[] args) throws IOException, InterruptedException {

		Runtime r = Runtime.getRuntime();
		
//		r.exec("notepad.exe");
//		r.exec("./QQ.exe");
		
		//使用notepad打开c盘下的中科虹霸简介.txt文件
//		r.exec("notepad.exe c:\\中科虹霸简介.txt");
		
		Process p = r.exec("notepad.exe");
		Thread.sleep(3000);
		//杀掉进程
		p.destroy();
	}

}
