package cn.sunjian.annotation;
/**
 * Annotation��ע��
 * 
 * 		@Deprecated��������ʹ�õĲ���
 * 
 * @author jack
 *
 */
@Deprecated
class Demo{
	@Deprecated
	public String getInfo(){
		return "����һ��Person�ࡣ����";
	}
}

public class DeprecatedAnnotationDemo {

	public static void main(String[] args) {

		Demo d = new Demo();
		
		System.out.println(d.getInfo());
	}

}
