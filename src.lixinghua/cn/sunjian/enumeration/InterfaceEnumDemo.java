package cn.sunjian.enumeration;
/**
 * 使用枚举实现一个接口:
 *		在枚举中定义抽象方法
 *		枚举类型可以跟普通的类一样实现一个接口，但是实现接口的时候要求枚举中的每个对象都必须单独覆写好接口中的抽象方法。
 *
 * @author jack
 *
 */
interface Print{
	public String getColor();//接口中定义抽象方法
}

enum Color8 implements Print{
	RED{
		public String getColor(){
			return "红色";
		}
	},GREEN{
		public String getColor(){
			return "绿色";
		}
	},BLUE{
		public String getColor(){
			return "蓝色";
		}
	}
}

public class InterfaceEnumDemo {

	public static void main(String[] args) {

		for(Color8 c8 : Color8.values()){
			System.out.print(c8+c8.getColor()+"、");
		} 
	}

}
