package cn.sunjian.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * java������ƣ�
 * 
 * 		ȡ����Ľṹ��
 * 			ȡ�����ȫ��������
 * 
 * @author jack
 *
 */
public class GetMethodDemo {

	public static void main(String[] args) {
	
		Class<?> c = null;//����Class����
		
		try {
			c = Class.forName("cn.sunjian.reflect.Person3");//ʵ��������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
//		Method[] m = c.getDeclaredMethods();//ȡ�ñ���ȫ������
		Method[] m = c.getMethods();//ȡ�����У��������ࣩȫ������
		for(int i=0;i<m.length;i++){
			Class<?> r = m[i].getReturnType();//ȡ�÷���ֵ����
			Class<?> p[] = m[i].getParameterTypes();//ȡ��ȫ������������
			int x = m[i].getModifiers();//�õ����η�
			System.out.print(Modifier.toString(x)+" ");//������η�(����Ȩ��)
			System.out.print(r+" ");//�������ֵ����
			System.out.print(m[i].getName());
			System.out.print("(");
			for(int j=0;j<p.length;j++){
				System.out.print(p[j].getName()+" "+"arg"+j);
				if (j<p.length) {
					System.out.print(",");
				}
			}
			Class<?> ex[] = m[i].getExceptionTypes();//ȡ���쳣
			if (ex.length>0) {
				System.out.print(") throws ");
			}else {				
				System.out.print(")");
			}
			for(int j=0;j<ex.length;j++){
				System.out.print(ex[j].getName());
				if (j<p.length) {
					System.out.print(",");
				}
			}
			
			System.out.println();
		}
		
	}

}
