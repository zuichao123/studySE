package cn.sunjian.internationalization;

/**
 * 国际化操作练习：
 * 		
 * 		java新特性：输入可变参数
 * 
 * 
 * @author jack
 *
 */
public class InterDemo4 {

	public static void main(String[] args) {

		System.out.print("第一次运行：");
		Object[] arg1 = {"65r4e","sdfsd","erger","按时发生","爱的色放"};
		fun(arg1);
		System.out.print("\n第二次运行：");
		Object[] arg2 = {"123","456","789"};
		fun(arg2);
		System.out.print("\n第三次运行：");
		Object[] arg3 = {"12asdf水电费水电费"};
		fun(arg3);
	}

	private static void fun(Object... args) {//固定语法，输入任意多个数据，使用数字表示

		for(int x=0;x<args.length;x++){
			System.out.print(args[x]+"、");
		}
	}

}
