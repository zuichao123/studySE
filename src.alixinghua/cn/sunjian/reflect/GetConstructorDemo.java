package cn.sunjian.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * java������ƣ�
 * 
 * 		ȡ����Ľṹ��
 * 			ȡ�����ȫ�����췽����
 * 
 * @author jack
 *
 */
public class GetConstructorDemo {

	public static void main(String[] args) {
	
		Class<?> c = null;//����Class����
		
		try {
			c = Class.forName("cn.sunjian.reflect.Person3");//ʵ��������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Constructor<?> con[] = c.getConstructors();//ȡ��ȫ���Ĺ��췽��
		
		for(int i=0;i<con.length;i++){			
//			System.out.println("���췽����"+con[i]);
			/*
			 * ���ϵ����еĹ��췽����ʱͨ������ֱ�Ӵ�ӡȡ�õģ��϶������Constructor���е�toString()������
			 */
			
			System.out.println("******************");
			Class<?>[] p = con[i].getParameterTypes();//�õ����췽���е�ȫ������
			System.out.print("���췽����");
			int mo = con[i].getModifiers();//ȡ�÷���Ȩ��
			System.out.print(Modifier.toString(mo)+" ");//ȡ�����η�
			System.out.print(con[i].getName());//ȡ�ù��췽��������
			System.out.print("(");
			for(int j=0;j<p.length;j++){
				System.out.println(p[j].getName()+"  arg  "+i);
				if (j<p.length-1) {
					//�жϴ�ʱ�Ƿ������һ������
					System.out.print(",");
				}
			}
			System.out.println("){}");
		}
		/*
		 * java�е�Ȩ����ͨ�������ʾ�ģ������Ҫ��ԭ���û����Կ��ö��ģ���Ҫʹ��Modifier()�����е�toString()������ɣ�
		 */
	}

}
