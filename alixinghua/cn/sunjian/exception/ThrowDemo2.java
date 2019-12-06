package cn.sunjian.exception;

/**
 * throw 和 throws的应用，范例
 * 
 * 在一般的开发中try catch finally throw throws联合使用的情况是最多的，
 * 例如：现在要设计一个相除的方法：
 * 	但是在进行操作之前必须打印“计算开始”的信息、结束之后打开“异常结束”的信息
 * 	如果有异常的话，则应该把异常交给被调用处处理，面对这样的要求，就必须使用以上的全部操作。
 * 
 * @author sunjian
 *
 */

class Math{
	public int div(int i,int j)throws Exception{
		System.out.println("计算开始。。");
		int temp = 0;
		try{
			temp = i/j;
		}catch(Exception e){
			throw e;
		}finally {			
			System.out.println("计算结束。。");
		}
		return temp;
	}
}

public class ThrowDemo2 {

	public static void main(String[] args) {
		Math m = new Math();
		try{			
			System.out.println("计算结果："+m.div(10, 0));
		}catch(Exception e){
			System.out.println("异常产生："+e);
		}
	}

}
