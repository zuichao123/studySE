package cn.sunjian.enumeration;
/*
 * 枚举：
 * 		通过set方法；设置枚举对象；
 * 		
 */
enum Color4{
	
	RED,GREEN,BLUE ;
	
	private String name ;			// 定义name属性
	
	public void setName(String name){
		switch (this) {
			case RED:{				
				if("红色".equals(name)){
					this.name = name;
				}else {
					System.out.println("设置内容错误！");
				}
				break;
			}
			case BLUE:{				
				if("蓝色".equals(name)){
					this.name = name;
				}else {
					System.out.println("设置内容错误！");
				}
				break;
			}
			case GREEN:{				
				if("绿色".equals(name)){
					this.name = name;
				}else {
					System.out.println("设置内容错误！");
				}
				break;
			}
			default:
				System.out.println("未知颜色");
				break;
		}
	}
	public String getName(){
		return this.name ;
	}
}



public class SetMethodEnum{
	public static void main(String args[]){
//		Color4 c4 = Color4.BLUE;
		Color4 c4 = Color4.valueOf(Color4.class,"BLUE");//得到蓝色，（等同于上句）
		
		c4.setName("兰色");//名字错误
		c4.setName("蓝色");
		
		System.out.println(c4.getName());
		
	}
}
