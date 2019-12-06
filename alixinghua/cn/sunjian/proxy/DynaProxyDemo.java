package cn.sunjian.proxy;
/**
 * java������ƣ�
 * 
 * 		��̬����
 * 			һ��������ֻ��Ϊһ���ӿڷ���
 * 
 * @author jack
 *
 */
interface Subject{
	public String say(String name,int age);//������󷽷�say
}

class RealSubject implements Subject{//ʵ�ֽӿ�
	public String say(String name,int age){
		return "������"+name+", ���䣺"+age;
	}
}

class ProxySubject implements Subject{//ʵ�ֽӿ�
	private Subject sub = null;
	public ProxySubject(Subject sub){
		this.sub = sub;
	}
	public String say(String name,int age){
		return this.sub.say(name,age);
	}
}

public class DynaProxyDemo {

	public static void main(String[] args) {
		Subject sub = new ProxySubject(new RealSubject());
		
		System.out.println(sub.say("sunjian", 30));
	}
	
	/*
	 * ���ϵĴ�����Ϊ��̬������Ϊһ��������ֻ��Ϊһ���ӿڷ���
	 * ��������кܶ��ӿڵĻ�����ô��϶�������ͺܶ��ˣ����ң����еĴ���������˵��õķ�����һ��֮�⣬�����Ĳ�����һ�������ʱ�϶����ظ����롣
	 */
}
