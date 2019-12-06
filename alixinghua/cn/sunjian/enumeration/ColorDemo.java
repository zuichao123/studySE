package cn.sunjian.enumeration;
/**
 * 枚举：
 * 
 * 		通过普通类实现
 * 			
 * 		
 * @author sunjian
 *
 */
class Color{
	public static final Color RED = new Color("红色");
	public static final Color BLUE = new Color("蓝色");
	public static final Color YELLOW = new Color("黄色");
	
	private String name;
	
	private Color(String name){
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public static Color getInstance(int i){
		switch(i){
			case 1:{
				return RED;
			}
			case 2:{
				return BLUE;
			}
			case 3:{
				return YELLOW;
			}
			default:{
				return null;
			}
		}
	}
}

public class ColorDemo {

	public static void main(String[] args) {
		Color c1 = Color.RED;//取得红色
		System.out.println(c1.getName());
		
		Color c3 = Color.getInstance(3);//根据编号输出
		System.out.println(c3.getName());
		
	}
	
	/*
	 * 此时程序限定了所能取得的对象的范围，达到了枚举的功能。
	 */

}
