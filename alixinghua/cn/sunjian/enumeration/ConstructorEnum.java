package cn.sunjian.enumeration;
/*
 * ö�٣�
 * 		ͨ�����췽����
 * 		һ�������вι���֮��������ö�ٶ����ʱ��ͱ�����ȷ�ĵ��ù��췽���������ݲ�����
 */
enum Color2{
	
	RED("��ɫ"),GREEN("��ɫ"),BLUE("��ɫ") ;
	
	private String name ;			// ����name����
	
	private Color2(String name){//��ʱ���죬ֻ��˽��
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
