package cn.sunjian.generic;
/**
 * ���ͷ�������ϰ
 * 		
 * @author sunjian
 *
 */
class Demo{
	public <T> T fun(T t){//���巺�ͷ��������Խ����������͵�����
		return t;//ֱ�ӰѲ�������
	}
}

public class GenericsMethodDemo {

	public static void main(String[] args) {
		Demo d = new Demo();//ʵ����Demo����
		
		String str = d.fun("sunjian");//�����ַ���
		int i = d.fun(30);//�������֣��Զ�װ��
		
		System.out.println(str+i);//�������
	}

}
