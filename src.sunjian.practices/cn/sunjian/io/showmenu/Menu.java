package cn.sunjian.io.showmenu;

import cn.sunjian.io.InputData;

/**
 * ʵ����ϰ�����˵���ʾ��
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
		System.out.println("==-==XXXϵͳ==-==");
		System.out.println("    [1]����������");
		System.out.println("    [2]��ɾ������");
		System.out.println("    [3]���޸�����");
		System.out.println("    [4]���鿴����");
		System.out.println("    [0]��ϵͳ�˳�\n");
		
		InputData input = new InputData();
		int i = input.getInt("��ѡ��", "��������ȷ��ѡ�");//�����������ת����������
		
		switch (i) {//���������
		case 1:
			Operate.add();//�������Ӳ���
			break;
		case 2:
			Operate.delete();//����ɾ������
			break;
		case 3:
			Operate.update();//���ø��²���
			break;
		case 4:
			Operate.find();//���ò鿴����
			break;
		case 0:
			System.exit(1);//ϵͳ�˳�
			break;
			
		default://�����0--4֮�������
			System.out.println("��������ȷ��ѡ�");
		}
	}
	
	
	
}