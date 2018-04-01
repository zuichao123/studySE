package cn.sunjian.regex.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ������ʽ
 */
public class RegexDemo2 {

	public static void main(String[] args) {

		/*
		 * ������ʽ���ַ����ĳ���������
		 * 	1��ƥ��
		 * 		��ʵʹ�õľ���String���е�matches������
		 *  2���и�
		 *  	��ʵ����String�۵�split������
		 *  3���滻
		 *  	��ʵʹ�õľ���String���е�replaceAll()������
		 *  
		 *  4����ȡ
		 *  		
		 */
		
		functionDemo_4();
		
	}
	
	/*
	 * ��ȡ��ʾ
	 * 
	 * �����������ж���ķ�װ��
	 * Pattern p = Pattern.compile("a*b");
	 * ͨ����������matcher�����ַ������������ȡҪ���ַ���������ƥ��������Matcher
	 * Matcher m = p.matcher("aaaaab");
	 * ͨ��Matcherƥ��������ķ������ַ������в�����
	 * boolean b = m.matches();
	 * 
	 */

	public static void functionDemo_4() {
		
		String str = "da jia hao, ming tian bu fang jia!";
		
		String regex = "\\b[a-z]{3}\\b";//��ĸ����3��;��б��b������ĸ�߽�
		
		//1���������װ�ɶ���
		Pattern p = Pattern.compile(regex);
		//2��ͨ����������ȡƥ��������
		Matcher m = p.matcher(str);
		
		//ʹ��Match������ķ������ַ������в�����
		//��ȻҪ��ȡ�����ַ���ɵĵ��ʡ�
		//���ҡ�find();
		
		System.out.println(str);
		while(m.find()){
			System.out.println(m.group());//��ȡƥ��������С�
			
			System.out.println(m.start()+":"+m.end());
		}
		
	}


	/*
	 * �滻��ʾ
	 * 
	 */
	public static void functionDemo_3() {
		String str = "zhangsanttttxiaoqiangmmmmmzhaoliu";
//		str = str.replaceAll("(.)\\1+", "#");//�ѵ����滻��#��
		str = str.replaceAll("(.)\\1+", "$1");//��������������еĵ��ʻ�ȡ������һ������
	
		System.out.println(str);
		
		String tel = "15800001111";//158****1111
		
		tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");//ͷβ�������£��м䲿���滻Ϊ*
		
		System.out.println(tel);
		
	}
	
	
	
	
	
	
	
	
	
	/*
	 * �и���ʾ
	 * 
	 * �飺((A)(B(C)))
	 * 
	 */
	public static void functionDemo_2(){
		
//		String str = "zhangsan     xiaoqiang     zhaoliu";
//		String str1 = "zhangsan.xiaoqiang.zhaoliu";
		String str2 = "zhangsanttttxiaoqiangmmmmmmmzhaoliu";
		
//		String [] names = str.split(" +");//�ո����һ�λ���
//		String [] names = str1.split("\\.");//"\\."���������ַ�������Ҫת��
		String [] names = str2.split("(.)\\1+");//�ã���С���ŷ�װ�ɺ���;��˼�ǣ���һ��������.���⣬���Ҳ�ֹ����1��
											    //(.)�������ַ���С���ŷ�װ�ɺ���
												//\\1������1ת���1������һ��
												//+������������ַ���ֹ����һ��
		
		for(String name:names){
			System.out.println(name);
		}
		
	}
	
	
	/*
	 * ��ʾƥ��
	 */
	public static void functionDemo_1(){
		
		//ƥ���ֻ������Ƿ���ȷ
		String tel = "15800001111";
		
//		String regex = "1[358][0-9]{9}";
		String regex = "1[358]\\d{9}";
		
		boolean b = tel.matches(regex);
		System.out.println(tel+":"+b);
		
	}

	
}
