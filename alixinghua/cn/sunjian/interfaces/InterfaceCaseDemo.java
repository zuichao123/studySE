package cn.sunjian.interfaces;

/**
 * Ϊ�ӿ�ʵ��������
 * 
 * @author sunjian
 *
 */
interface AA{
	public void print();
}
class BB implements AA{
	public void print(){
		System.out.println("hello");
	}
}

public class InterfaceCaseDemo {

	public static void main(String[] args) {
		AA a = new BB();//ͨ������Ϊ�������ӿ�ʵ����
		a.print();
	}

}
