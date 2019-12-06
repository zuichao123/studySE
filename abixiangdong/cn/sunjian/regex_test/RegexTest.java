package cn.sunjian.regex_test;

import java.util.TreeSet;

public class RegexTest {

	public static void main(String[] args) {

		/*
		 * 1.治疗口吃：我我我...我我我...我要要.要.....要要要...要要学...学学学....学学....学学编编....编编....编...编编编...程程程...程程程
		 * 2.对ip地址排序。
		 * 3.对邮件地址校验。
		 *
		 */
		test_1();
		test_2();
		test_3();
	}


	/*
	 * 对邮件地址校验
	 */
	public static void test_3() {
		
		System.out.println("######################练习3");
		String mail = "abc1@sina.com.cn";
		
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{1,3})+";

		boolean b = mail.matches(regex);
		
		System.out.println(mail+":"+b);
		
	}


	/*
	 * 治疗口吃
	 */
	public static void test_1() {
		
		System.out.println("######################练习1");
		String str = "我我我...我我我...我要要.要.....要要要...要要学...学学学....学学....学学编编....编编....编...编编编...程程程...程程程！";
		
		//1.将字符串中.去掉，用替换法
		str = str.replaceAll("\\.+", "");
		System.out.println(str);
		
		//2.替换叠词。
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
	}
	
	
	/*
	 * ip地址排序
	 * 
	 * 192.168.10.34  127.0.0.1 3.3.3.3 105.70.11.55
	 * 
	 */
	public static void test_2() {
		
		System.out.println("######################练习2");
		
		String ip_str ="192.168.10.34  127.0.0.1 3.3.3.3 105.70.11.55";
		
		//1,为了让IP可以按照字符串顺序比较，只要让IP的每一段的位数相同。
		//所以，补零，按照每一位所所需最多0进行补充。每一段都加两个。
		
		ip_str = ip_str.replaceAll("(\\d+)", "00$1");
		System.out.println(ip_str);
		
		//然后每一段保留数字3位
		ip_str = ip_str.replaceAll("0*(\\d{3})", "$1");
		System.out.println(ip_str);
		
		
		
		//1，将IP地址切出
		String[] ips = ip_str.split(" +");
		
		TreeSet<String> ts = new TreeSet<String>();
		
		for(String ip:ips){
//			System.out.println(ip);
			ts.add(ip);
		}
		
		for(String ip:ts){
			System.out.println(ip.replaceAll("0*(\\d+)", "$1"));
		}
		
	}

}
