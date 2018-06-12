package cn.sunjian.systemlogin;

/**
 * 练习系统登录操作
 * 
 * @author sunjian
 *
 */

/*
 * 检查用户名、密码信息
 * 完成具体的验证操作
 */
class CheckInfo{
	public boolean validate(String name,String password){
		if (name.equals("sunjian")&&password.equals("123456")) {
			return true;
		}else {
			return false;
		}
	}
}

/*
 * 用户登录操作
 * 调用具体的验证操作
 */
class Operator{
	private String[] info;//定义一个数组属性，用于接收输入的参数信息
	public Operator(String[] info){
		this.info = info;//通过构造方法，来获取全部的输入参数
	}
	
	public String login(){//登录操作
		CheckInfo check = new CheckInfo();
		this.isExit();

		String str = null;
		String name = this.info[0];
		String password = this.info[1];
		
		if (check.validate(name, password)) {
			str = "欢迎"+name+"光临！";
		}else {
			str = "您输入的用户名或密码错误，请重新输入！";
		}
		return str;
	}
	
	public void isExit(){
		if (this.info.length!=2) {
			System.out.println("输入的参数不正确");
			System.out.println("格式为：\n用户名\n密码");
			System.exit(1);
		}
	}
	
}


public class LoginDemo2 {

	public static void main(String[] args) {
		
		Operator operator = new Operator(args);
		System.out.println(operator.login());
	}

}
