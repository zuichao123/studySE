package cn.sunjian.enumeration;
/**
 * ʹ��ö��ʵ��һ���ӿ�:
 *		��ö���ж�����󷽷�
 *		ö�����Ϳ��Ը���ͨ����һ��ʵ��һ���ӿڣ�����ʵ�ֽӿڵ�ʱ��Ҫ��ö���е�ÿ�����󶼱��뵥����д�ýӿ��еĳ��󷽷���
 *
 * @author jack
 *
 */
interface Print{
	public String getColor();//�ӿ��ж�����󷽷�
}

enum Color8 implements Print{
	RED{
		public String getColor(){
			return "��ɫ";
		}
	},GREEN{
		public String getColor(){
			return "��ɫ";
		}
	},BLUE{
		public String getColor(){
			return "��ɫ";
		}
	}
}

public class InterfaceEnumDemo {

	public static void main(String[] args) {

		for(Color8 c8 : Color8.values()){
			System.out.print(c8+c8.getColor()+"��");
		} 
	}

}
