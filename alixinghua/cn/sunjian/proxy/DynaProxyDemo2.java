package cn.sunjian.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * java������ƣ�
 * 
 * 		��̬����
 * 			ͨ��һ�����������ȫ���Ĵ����ܣ�
 * 
 * @author jack
 *
 */
interface Subject2{
	public String say(String name,int age);//������󷽷�say
}

class RealSubject2 implements Subject2{//ʵ�ֽӿ�
	public String say(String name,int age){
		return "������"+name+", ���䣺"+age;
	}
}

interface Subject3{
	public String hua(String h);
}
class RealSubject3 implements Subject3{
	public String hua(String h){
		return "���Ǵ���ĵڶ����ࣺ"+h;
	}
}

/*
 * ����˵����
 * Object proxy��������Ķ���
 * Method method��Ҫ���õķ�����
 * Object args[]����������ʱ����Ҫ�Ĳ�����
 */
class MyInvocationHandler implements InvocationHandler{
	
	private Object obj;//��������
	
	public Object bind(Object obj){//����ʵ��������
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), this);//ȡ�ô������
	}
	
	public Object invoke(Object proxy,Method method,Object[] args) throws Exception{//��̬���÷���
		
		this.before();
		Object temp = method.invoke(this.obj, args);//���÷�����������ʵ����Ͳ���
		return temp;//���ط����ķ�����Ϣ
	}
	
	public void before(){
		System.out.println("�������֮ǰ������");
	}
	
}

public class DynaProxyDemo2 {

	public static void main(String[] args) {
		Subject2 sub2 = (Subject2) new MyInvocationHandler().bind(new RealSubject2());
		
		System.out.println(sub2.say("sunjian", 30));
		
		Subject3 sub3 = (Subject3) new MyInvocationHandler().bind(new RealSubject3());
		System.out.println(sub3.hua("yes"));
	}
	
	/*
	 * ���ϵĴ�����Ϊ��̬������Ϊһ��������ֻ��Ϊһ���ӿڷ���
	 * ��������кܶ��ӿڵĻ�����ô��϶�������ͺܶ��ˣ����ң����еĴ���������˵��õķ�����һ��֮�⣬�����Ĳ�����һ�������ʱ�϶����ظ����롣
	 */
}
