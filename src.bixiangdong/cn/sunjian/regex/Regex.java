package cn.sunjian.regex;

/*
 * ������ʽ
 */
public class Regex {

	public static void main(String[] args) {

		String qq = "12346l4567";
		checkQQ(qq);
		
		String regex = "[1-9][0-9]{4,14}";//������ʽ
		boolean b = qq.matches(regex);
		
		System.out.println(qq+":"+b);
		
		String str = "aoooob";
		String  reg = "ao{2,3}b";
		boolean b2 = str.matches(reg);
		System.out.println(str+":"+b2);
		
	}

	/*
	 * ����
	 * 	����һ�����ܶ�QQ�Ž���У�顣
	 * ����
	 * 	����5-15��ֻ�������֣�0���ܿ�ͷ
	 */
	
	public static void checkQQ(String qq){
		int len = qq.length();
		long l = 0;
		if (len>=5 && len<=15) {
			
			if (!qq.startsWith("0")) {
				
				try{
					
					l = Long.parseLong(qq);
				
				}catch (NumberFormatException e) {
					System.out.println(qq+"����Ƿ��ַ���");
				}
				
			}else {
			System.out.println(qq+"����0��ͷ��");
			}
		}else {
			System.out.println(qq+"���ȴ���");
		}
		
		System.out.println("Long.parseLong(qq) ="+l);
	}
}
