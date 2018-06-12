package cn.sunjian.enumeration;
/**
 * 枚举：enum
 * 
 *		 通过switch方式，输出枚举的内容
 *  
 * @author jack
 *
 */
public class SwitchEnum {

	public static void main(String[] args) {

		for(Colors c : Colors.values()){
			print(c);//输出枚举中的全部内容
		}
	}

	private static void print(Colors c) {

		switch (c) {
		case RED:
			System.out.println("红色");
			break;
		case BLUE:
			System.out.println("蓝色");
			break;
		case YELLOW:
			System.out.println("黄色");
			break;
		case GREEN:
			System.out.println("绿色");
			break;
		default:
			System.out.println("未知颜色");
			break;
		}
	}

}
