package cn.sunjian.proxy;
/**
 * java������ƣ�
 * 		
 * 		�������ģʽ��
 * 			
 * 
 * @author jack
 *
 */
interface Fruit{
	public void eat();//���󷽷����ԣ�
}

class Apple implements Fruit{
	public void eat(){
		System.out.println("��ƻ����������������");
	}
}
class Orange implements Fruit{
	public void eat(){
		System.out.println("�����ӡ�������������");
	}
}

class Factory{
	public static Fruit getInstance(String className){
		Fruit fruit = null;
		
		if ("apple".equals(className)) {
			fruit = new Apple();
		}
		if ("orange".equals(className)) {
			fruit = new Orange();
		}
		
		return fruit;
	}
}


public class FactoryDemo {

	public static void main(String[] args) {

		Fruit f = Factory.getInstance("apple");
		
		f.eat();
	}

}
