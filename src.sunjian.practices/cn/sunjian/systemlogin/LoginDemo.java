package cn.sunjian.systemlogin;

public class LoginDemo {

	public static void main(String[] args) {
		if (args.length!=2) {
			System.out.println("������ĸ�ʽ����ȷ��");
			System.out.println("��ʽΪ��\n�û���  \n����");
			System.exit(1);
		}
		System.out.println(args[0]);//ȡ���û���
		System.out.println(args[1]);//ȡ������
		
		if (args[0].equals("sunjian") && args[1].equals("123456")) {
			System.out.println("��ӭ"+args[0]+"���٣�");
		}else {
			System.out.println("�û������������");
		}
	}
}
