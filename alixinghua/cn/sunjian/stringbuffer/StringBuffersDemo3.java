package cn.sunjian.stringbuffer;

/**
 * StringBuffer：
 * 		常用方法，练习
 * 
 * @author jack
 *
 */
public class StringBuffersDemo3 {

	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer();
		
		buf.append("Hello");

//		buf.insert(0, "sunjian");//在第一个位置处添加内容
//		
//		buf.insert(buf.length(), "123");//在最后添加内容
//		
//		buf.reverse();//字符串反转
//		
//		buf.replace(2, 6, "name");//替换字符串
		
		String str = buf.substring(1, 4);//字符串截取指定范围的字符串
		
		str = buf.delete(0, 1).toString();//删除指定范围内的内容
		
		if (buf.indexOf("hell")==-1) {//查找指定的内容
			System.out.println("没有差遭到指定的内容");
		}else{
			System.out.println("可以查找到指定的内容");
		}
		
		System.out.println(str);
	}

}
