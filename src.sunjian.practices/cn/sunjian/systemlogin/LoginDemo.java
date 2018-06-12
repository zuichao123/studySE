package cn.sunjian.systemlogin;

public class LoginDemo {

	public static void main(String[] args) {
		if (args.length!=2) {
			System.out.println("您输入的格式不正确！");
			System.out.println("格式为：\n用户名  \n密码");
			System.exit(1);
		}
		System.out.println(args[0]);//取出用户名
		System.out.println(args[1]);//取出密码
		
		if (args[0].equals("sunjian") && args[1].equals("123456")) {
			System.out.println("欢迎"+args[0]+"光临！");
		}else {
			System.out.println("用户名或密码错误！");
		}
	}
}
