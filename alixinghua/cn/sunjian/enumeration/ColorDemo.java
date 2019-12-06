package cn.sunjian.enumeration;
/**
 * ö�٣�
 * 
 * 		ͨ����ͨ��ʵ��
 * 			
 * 		
 * @author sunjian
 *
 */
class Color{
	public static final Color RED = new Color("��ɫ");
	public static final Color BLUE = new Color("��ɫ");
	public static final Color YELLOW = new Color("��ɫ");
	
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
		Color c1 = Color.RED;//ȡ�ú�ɫ
		System.out.println(c1.getName());
		
		Color c3 = Color.getInstance(3);//���ݱ�����
		System.out.println(c3.getName());
		
	}
	
	/*
	 * ��ʱ�����޶�������ȡ�õĶ���ķ�Χ���ﵽ��ö�ٵĹ��ܡ�
	 */

}
