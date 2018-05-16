package cn.sunjian.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * java������ƣ�
 * 
 * 		ȡ����Ľṹ��
 * 			ȡ�����ȫ�����ԣ�
 * 				�������ԣ�
 * 				�������ԣ�
 * 
 * @author jack
 *
 */
public class GetFieldDemo {

	public static void main(String[] args) {
	
		Class<?> c = null;//����Class����
		
		try {
			c = Class.forName("cn.sunjian.reflect.Person3");//ʵ��������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		{
			//��������
			Field[] f = c.getFields();//ȡ�ù���������
			for(int i=0;i<f.length;i++){
				Class<?> r = f[i].getType();//�õ���������
				
				int mo = f[i].getModifiers();//�õ����η�������
				
				String priv = Modifier.toString(mo);//��ԭ���η�
				
				System.out.print("�������ԣ�");
				System.out.print(priv+" ");
				
				System.out.print(r.getName()+" ");//�õ���������
				System.out.print(f[i].getName());//�����������
				
				System.out.println(" ;");
				
			}
		}
		
		{
			//��������
			Field[] f = c.getDeclaredFields();//ȡ�ñ��������
			for(int i=0;i<f.length;i++){
				Class<?> r = f[i].getType();//�õ���������
				
				int mo = f[i].getModifiers();//�õ����η�������
				
				String priv = Modifier.toString(mo);//��ԭ���η�
				
				System.out.print("�������ԣ�");
				System.out.print(priv+" ");
				
				System.out.print(r.getName()+" ");//�õ���������
				System.out.print(f[i].getName());//�����������
				
				System.out.println(" ;");
				
			}
		}
		
	}

}
