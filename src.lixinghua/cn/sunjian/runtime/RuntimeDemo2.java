package cn.sunjian.runtime;

/**
 * Runtime类练习：
 * 		Runtime类和Process类结合使用
 * 
 * 		打开一个记事本，5秒后，自动关闭
 * 
 * @author jack
 *
 */
public class RuntimeDemo2 {

	public static void main(String[] args) {

		Runtime run = Runtime.getRuntime();//通过Runtime类中的静态方法getRuntime()进行实例化对象操作
		Process p = null;//定义进程变量
		
		try {
			p = run.exec("notepad.exe");//打开本机的notepad记事本程序
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(5000);//休眠5秒
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		p.destroy();//结束进程
		
	}

}
