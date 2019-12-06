package com.sunjian.gui;


import cn.sunjian.io.InputData;

/**
 * ��ϰ��������Ϣ�������
 *
 *		�˵���ʾ�Ĳ�����
 * 
 * @author sunjian
 *
 */
public class Operate {
	
	public static void add(){//���Ӳ���
		
		InputData input = new InputData();//ʵ�����������ݶ���
		FileOperate fo = new FileOperate(Path.deskTop()+"test.txt");
		
		String name = input.getString("������������");
		int age = input.getInt("���������䣺", "������������֣�");
		
		Person per = new Person(name, age);//ʵ����Person��
		
		try{
			fo.save(per);//�������
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("��Ϣ���ӳɹ���");
	}
	
	public static void delete(){//ɾ������
		FileOperate fo = new FileOperate(Path.deskTop()+"test.txt");
		
		try{
			fo.save(null);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("��Ϣɾ���ɹ���");
	}
	
	public static void update(){//�޸Ĳ���
		FileOperate fo = new FileOperate(Path.deskTop()+"test.txt");
		Person per = null;
		
		try {
			per = (Person) fo.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		InputData input = new InputData();//ʵ�����������ݶ���

		String name = input.getString("������������ԭ������"+per.getName()+"��");
		int age = input.getInt("���������䣨ԭ���䣺"+per.getAge()+"��", "������������֣�");
		
		per = new Person(name, age);//ʵ����Person��
		
		try{
			fo.save(per);//�������
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("��Ϣ�޸ĳɹ���");
	}
	
	public static void find(){//���Ҳ���
		FileOperate fo = new FileOperate(Path.deskTop()+"test.txt");
		Person per = null;
		
		try {
			per = (Person) fo.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(per);
	}
}
