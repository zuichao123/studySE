package cn.sunjian.exception;

/**
 * 自定义异常类
 * 
 * @author sunjian
 *
 */

@SuppressWarnings("serial")
class MyException extends Exception {//自定义异常类，继承Exception
	public  MyException(String msg){
		super(msg);//调用父类中的构造方法（一个参数的）
	}
}

public class CustomException {

	public static void main(String[] args) {
		try{
			throw new MyException("自定义异常。。");//抛出异常
		}catch(Exception e){
			System.out.println(e);//将捕获到的自定义异常打印出来
		}
	}

}
