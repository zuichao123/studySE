package cn.sunjian.useradmin.menu;

import cn.sunjian.io.InputData;
import cn.sunjian.useradmin.operate.UserOperate;

/**
 * �˵���ʾ��
 * 
 * @author sunjian
 *
 */
public class Menu {
	
	public Menu(){//ʼ����ʾ
		while(true){
			this.show();
		}
	}
	
	//��ʾ����
	public void show(){
		System.out.println("==-====-==XXX��Ա����ϵͳ==-====-==");
		System.out.println("    [1]��������Ա");
		System.out.println("    [2]���޸���Ա");
		System.out.println("    [3]��ɾ����Ա");
		System.out.println("    [4]���鿴������Ա");
		System.out.println("    [5]���鿴ȫ����Ա");
		System.out.println("    [0]��ϵͳ�˳�\n");
		
		InputData input = new InputData();
		int i = input.getInt("��ѡ��", "���������֣�");//�����������ת����������
		
		switch (i) {//���������
		case 1:
			UserOperate.insert();
			break;
		case 2:
			UserOperate.update();
			break;
		case 3:
			UserOperate.delete();
			break;
		case 4:
			UserOperate.findId();
			break;
		case 5:
			UserOperate.findAll();
			break;
		case 0:
			System.out.println("ϵͳ�˳���");
			System.exit(1);//ϵͳ�˳�
			break;
			
		default://�����0--5֮�������
			System.out.println("��������ȷ��ѡ�");
		}
	}
	
	
	
}
