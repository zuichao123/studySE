package cn.sunjian.systemlogin;

/**
 * ��ϰϵͳ��¼����
 * 
 * @author sunjian
 *
 */

/*
 * ����û�����������Ϣ
 * ��ɾ������֤����
 */
class CheckInfo{
	public boolean validate(String name,String password){
		if (name.equals("sunjian")&&password.equals("123456")) {
			return true;
		}else {
			return false;
		}
	}
}

/*
 * �û���¼����
 * ���þ������֤����
 */
class Operator{
	private String[] info;//����һ���������ԣ����ڽ�������Ĳ�����Ϣ
	public Operator(String[] info){
		this.info = info;//ͨ�����췽��������ȡȫ�����������
	}
	
	public String login(){//��¼����
		CheckInfo check = new CheckInfo();
		this.isExit();

		String str = null;
		String name = this.info[0];
		String password = this.info[1];
		
		if (check.validate(name, password)) {
			str = "��ӭ"+name+"���٣�";
		}else {
			str = "��������û���������������������룡";
		}
		return str;
	}
	
	public void isExit(){
		if (this.info.length!=2) {
			System.out.println("����Ĳ�������ȷ");
			System.out.println("��ʽΪ��\n�û���\n����");
			System.exit(1);
		}
	}
	
}


public class LoginDemo2 {

	public static void main(String[] args) {
		
		Operator operator = new Operator(args);
		System.out.println(operator.login());
	}

}
