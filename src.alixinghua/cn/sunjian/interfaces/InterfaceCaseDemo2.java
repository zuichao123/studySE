package cn.sunjian.interfaces;

/**
 * Ϊ�ӿ�ʵ��������
 * 
 * @author sunjian
 *
 */
interface USB{//����ӿ�
	public void start();
	public void stop();
}

class Computer{//����������
	public static void plugin(USB usb){
		
		usb.start();
		System.out.println("------usb�豸����----------");
		usb.stop();
		
	}
}

class Flash implements USB{//Flash��ʵ��USB�ӿ�
	public void start(){//��д����
		System.out.println("U�̿�ʼ����");
	}
	public void stop(){//��д����
		System.out.println("U��ֹͣ����");
	}
}
class Print implements USB{
	public void start(){
		System.out.println("��ӡ����ʼ����");
	}
	public void stop(){
		System.out.println("��ӡ��ֹͣ����");
	}
}




public class InterfaceCaseDemo2 {

	public static void main(String[] args) {

		Computer.plugin(new Flash());
		Computer.plugin(new Print());
		
	}

}
