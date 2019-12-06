package cn.sunjian.runtime;

/**
 * Runtime类练习：
 * 		
 * @author jack
 *
 */
public class RuntimeDemo {

	public static void main(String[] args) {

		Runtime run = Runtime.getRuntime();//通过Runtime类中的静态方法getRuntime()进行实例化对象操作
		
		System.out.println("jvm最大内存量："+run.maxMemory());//观察最大的内存
		
		System.out.println("jvm空闲内存量："+run.freeMemory());//取得程序运行的空闲内存
		
		String str = "Hello" + "world!" + "\t" + "Welcome"+"To" + "China";
		
		System.out.println(str);
		
		for(int x=0;x<100;x++){
			str+=x;//循环修改内存，产生多个垃圾
		}
		
		System.out.println("操作String之后的jvm空闲内存量："+run.freeMemory());
		
		run.gc();//垃圾回收，释放空间
		
		System.out.println("垃圾回收之后的jvm空闲内存量："+run.freeMemory());
	}

}
