package cn.sunjian.regex;

/**
 * 正则表达式操作练习：
 * 
 * 		判断一个字符串是否有数字组成
 * 
 * 			原始做法
 * 
 * @author jack
 *
 */
public class RegexDemo {

	public static void main(String[] args) {
	
		String str = "12345t67890";
		
		boolean flag = true;//定义一个标记变量
		
		
		//先将字符串拆分成字符数组后，再依次判断
		char c[] = str.toCharArray();//将字符串变成字符数组
		
		for(int i=0;i<c.length;i++){//依次循环判断
			if (c[i]<'0' || c[i]>'9') {
				flag = false;	//改变标记
				break; 		//不再继续执行
			}
		}
		if (flag) {
			System.out.println("是由数字组成！");
		}else {
			System.out.println("不是由数字组成！");
		}
	}

}
