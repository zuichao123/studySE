package cn.sunjian.generic;
/**
 * 泛型数组的练习
 * 	
 * @author sunjian
 *
 */

public class GenericsArrayDemo {

	public static void main(String[] args) {
		Integer i[] = fun1(1,2,3,4);//返回泛型数组
		
		fun2(i);
		
	}
	
	public static <T> T[] fun1(@SuppressWarnings("unchecked") T...arg){//接收可变参数
		return arg;					//返回泛型数组
	}
	
	public static <T> void fun2(T param[]){//输出方法
		System.out.println("接收泛型数组:");
		
		for(T t:param){
			System.out.print(t+"、");
		}
	}

}
