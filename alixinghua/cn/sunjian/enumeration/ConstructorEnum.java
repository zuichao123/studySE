package cn.sunjian.enumeration;
/*
 * 枚举：
 * 		通过构造方法；
 * 		一旦定义有参构造之后，在声明枚举对象的时候就必须明确的调用构造方法，并传递参数。
 */
enum Color2{
	
	RED("红色"),GREEN("绿色"),BLUE("兰色") ;
	
	private String name ;			// 定义name属性
	
	private Color2(String name){//此时构造，只能私有
		this.setName(name) ;
	}
	
	public void setName(String name){
		this.name = name ;
	}
	public String getName(){
		return this.name ;
	}
}



public class ConstructorEnum{
	public static void main(String args[]){
		for(Color2 c : Color2.values()){
			System.out.println(c.ordinal() + " --> " + c.name()
				+"(" + c.getName() + ")") ;
		}
	}
}
