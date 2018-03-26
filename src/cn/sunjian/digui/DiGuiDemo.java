package cn.sunjian.digui;

public class DiGuiDemo {

	public static void main(String[] args) {

		
		/**
		 * 递归：函数自身直接诶或者间接的掉偶那个了自身
		 * 
		 * 什么时候用？
		 * 一个功能在呗重复使用，并每次使用时，参与运算的结果和上一次调用有关，这时可以用递归来解决问题
		 * 
		 * 注意：； 
		 * 1.递归：一定要明确条件，否则容易栈溢出
		 * 2.注意递归的次数
		 * 3.光进不出，等到达到条件后才结束
		 */
		
		
//		show();
//		toBin(6);
		
		
		int sum = getSum(9000);
		System.out.println(sum);
	}
	
	//递归求和
	public static int getSum(int num){
		
		if(num == 1)
			return 1;
			
		return num+getSum(num-1);
		
	}
	
	//递归取模
	public static void toBin(int num){
		
		if(num>0){
			toBin(num/2);
			System.out.println(num%2);
//			num = num/2;
			
		}
	}

	
	/*public static void show(){
		
		method();
	}
	
	public static void method(){
		
		show();
	}*/
	
	
}
