package cn.sunjian.interfaces;

/**
 * �������ģʽ
 * 
 * @author sunjian
 *
 */
interface NetWork{
	public void browse();//�������
}

class Real implements NetWork{
	public void browse(){
		System.out.println("���������Ϣ");
	}
}

//�������ģʽ
class Proxy implements NetWork{
	private NetWork netWork;
	public Proxy(NetWork netWork){
		this.netWork = netWork;
	}
	
	public void check(){
		System.out.println("��������Ƿ�Ϸ�");
	}
	public void browse(){
		this.check();
		this.netWork.browse();//��������������ö�Ӧ��browse����
	}
}


public class ProxyDemo {

	public static void main(String[] args) {
		Proxy p = new Proxy(new Real());
		p.browse();
	}

}
