package cn.sunjian.enumeration;

import java.util.EnumMap;
import java.util.Map;

/**
 * EnumMap�ࣺ
 * 	
 * 		���
 * 		
 * @author jack
 *
 */
enum Color6{
	RED,GREEN,BLUE;
}

public class EnumMapDemo {

	public static void main(String[] args) {

		Map<Color6,String> desc = null;//����Map����ͬʱָ������
		desc = new EnumMap<Color6,String>(Color6.class);
		
		
		desc.put(Color6.BLUE, "��ɫ");
		desc.put(Color6.RED, "��ɫ");
		desc.put(Color6.GREEN, "��ɫ");
	
		System.out.println("���ȫ�����ݣ�");
		
		for(Color6 c6 : Color6.values()){
			System.out.print(c6.name()+"-->"+desc.get(c6)+"��");//����ö�ٶ���key���ҵ�ö������value��
		}
		
		System.out.println("\n���ȫ������");
		for(Color6 c66 : desc.keySet()){
			System.out.print(c66.name()+"��");
		}
		
		System.out.println("\n���ȫ����ֵ��");
		for(String c666 : desc.values()){
			System.out.print(c666+"��");
		}
	}

}
