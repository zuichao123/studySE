package cn.sunjian.news;
/**
 * 函数可变参数--练习
 * 函数的可变参数：其实就是一个数组，但是接收的是数组的元素；
 * 自动将这些元素封装成数组，简化了调用者的书写。
 * 
 * 注意：可变参数类型，必须定义在参数列表的结尾。
 * @author sunjian
 *
 */
public class ParameterDemo {

	public static void main(String[] args) {
		
		int sum = newAdd(4,6,7,8,0,554,236,57);
		System.out.println(sum);
	}
	
	public static int newAdd(int... arr){
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum +=arr[i];
		}
		return sum;
	}

}
