package cn.sunjian.regex.demo;

/*
 * 正则表达式
 */
public class RegexDemo {

	public static void main(String[] args) {

		String qq = "12346l4567";
//		checkQQ(qq);
		
		String regex = "[1-9][0-9]{4,14}";//正则表达式
//		boolean b = qq.matches(regex);
		
//		System.out.println(qq+":"+b);
		
//		String str = "aoooob";
//		String  reg = "ao{2,3}b";
//		boolean b = str.matches(reg);
//		System.out.println(str+":"+b);
		
	}

	/*
	 * 需求：
	 * 	定义一个功能对QQ号进行校验。
	 * 需求：
	 * 	长度5-15，只能是数字，0不能开头
	 */
	
	public static void checkQQ(String qq){
		int len = qq.length();
		
		if (len>=5 && len<=15) {
			
			if (!qq.startsWith("0")) {
				
				try{
					
					long l = Long.parseLong(qq);
				
				}catch (NumberFormatException e) {
					System.out.println(qq+"含义非法字符！");
				}
				
			}else {
			System.out.println(qq+"不能0开头！");
			}
		}else {
			System.out.println(qq+"长度错误！");
		}
	}
}
