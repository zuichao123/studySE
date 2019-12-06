package cn.sunjian.proxy;
/**
 * java反射机制：
 * 
 * 		动态代理：
 * 			一个代理类只能为一个接口服务
 * 
 * @author jack
 *
 */
interface Subject{
	public String say(String name,int age);//定义抽象方法say
}

class RealSubject implements Subject{//实现接口
	public String say(String name,int age){
		return "姓名："+name+", 年龄："+age;
	}
}

class ProxySubject implements Subject{//实现接口
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
	 * 以上的代理，称为静态代理，因为一个代理类只能为一个接口服务；
	 * 如果现在有很多歌接口的话，那么则肯定代理类就很多了，而且，所有的代理操作除了调用的方法不一样之外，其他的操作都一样，则此时肯定是重复代码。
	 */
}
