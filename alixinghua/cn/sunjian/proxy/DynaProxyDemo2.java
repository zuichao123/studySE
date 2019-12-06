package cn.sunjian.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * java反射机制：
 * 
 * 		动态代理：
 * 			通过一个代理类完成全部的代理功能；
 * 
 * @author jack
 *
 */
interface Subject2{
	public String say(String name,int age);//定义抽象方法say
}

class RealSubject2 implements Subject2{//实现接口
	public String say(String name,int age){
		return "姓名："+name+", 年龄："+age;
	}
}

interface Subject3{
	public String hua(String h);
}
class RealSubject3 implements Subject3{
	public String hua(String h){
		return "这是代理的第二个类："+h;
	}
}

/*
 * 参数说明：
 * Object proxy：被代理的对象；
 * Method method：要调用的方法；
 * Object args[]：方法调用时所需要的参数；
 */
class MyInvocationHandler implements InvocationHandler{
	
	private Object obj;//这是主题
	
	public Object bind(Object obj){//绑定真实操作主题
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), this);//取得代理对象
	}
	
	public Object invoke(Object proxy,Method method,Object[] args) throws Exception{//动态调用方法
		
		this.before();
		Object temp = method.invoke(this.obj, args);//调用方法，传入真实主题和参数
		return temp;//返回方法的返回信息
	}
	
	public void before(){
		System.out.println("代理操作之前。。。");
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
	 * 以上的代理，称为静态代理，因为一个代理类只能为一个接口服务；
	 * 如果现在有很多歌接口的话，那么则肯定代理类就很多了，而且，所有的代理操作除了调用的方法不一样之外，其他的操作都一样，则此时肯定是重复代码。
	 */
}
