package cn.sunjian.enumeration;
/**
 * ö�٣�enum
 * 
 *		 ͨ��switch��ʽ�����ö�ٵ�����
 *  
 * @author jack
 *
 */
public class SwitchEnum {

	public static void main(String[] args) {

		for(Colors c : Colors.values()){
			print(c);//���ö���е�ȫ������
		}
	}

	private static void print(Colors c) {

		switch (c) {
		case RED:
			System.out.println("��ɫ");
			break;
		case BLUE:
			System.out.println("��ɫ");
			break;
		case YELLOW:
			System.out.println("��ɫ");
			break;
		case GREEN:
			System.out.println("��ɫ");
			break;
		default:
			System.out.println("δ֪��ɫ");
			break;
		}
	}

}
