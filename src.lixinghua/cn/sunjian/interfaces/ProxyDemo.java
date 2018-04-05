package cn.sunjian.interfaces;

/**
 * 代理设计模式
 * 
 * @author sunjian
 *
 */
interface NetWork{
	public void browse();//浏览方法
}

class Real implements NetWork{
	public void browse(){
		System.out.println("上网浏览信息");
	}
}

//代理设计模式
class Proxy implements NetWork{
	private NetWork netWork;
	public Proxy(NetWork netWork){
		this.netWork = netWork;
	}
	
	public void check(){
		System.out.println("检查网络是否合法");
	}
	public void browse(){
		this.check();
		this.netWork.browse();//传入的子类对象调用对应的browse方法
	}
}


public class ProxyDemo {

	public static void main(String[] args) {
		Proxy p = new Proxy(new Real());
		p.browse();
	}

}
