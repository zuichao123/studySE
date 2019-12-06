package cn.sunjian.system;

/**
 * System类练习：
 * 		
 * 		取得操作所用的时间		
 * 
 * @author jack
 *
 */
public class SystemDemo {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();//开始时间
		@SuppressWarnings("unused")
		int sum = 0;//声明变量
		
		for(int i=0;i<700000000;i++){
			sum+=i;
		}
		
		long endTime = System.currentTimeMillis();//结束时间
		
		System.out.println("所用时间："+(endTime-startTime)+"毫秒");
		
	}

}
