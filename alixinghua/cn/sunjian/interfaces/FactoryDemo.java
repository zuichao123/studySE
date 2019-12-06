package cn.sunjian.interfaces;

/**
 * �������ģʽ
 * 
 * @author sunjian
 *
 */
interface Fruit{//����һ��ˮ���ӿ�
	public void eat();//������󷽷�����ˮ����
}

class Apple implements Fruit{
	public void eat(){
		System.out.println("��ƻ��������");
	}
}
class Orange implements Fruit{
	public void eat(){
		System.out.println("�����ӡ�����");
	}
}

/*
 * ������
 */
class Factory{
	public static Fruit getInstance(String className){
		Fruit f = null;
		if ("apple".equals(className)) {
			f = new Apple();
		}
		if ("orange".equals(className)) {
			f = new Orange();
		}
		return f;
	}
}

public class FactoryDemo {

	public static void main(String[] args) {
		//ʵ�������󣨽ӿڸ�������ã�ָ������Ķ���
//		Fruit f = Factory.getInstance(args[0]);
		Fruit f = Factory.getInstance("orange");
		if (f!=null) {			
			f.eat();
		}
	}

}
