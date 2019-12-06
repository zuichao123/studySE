package cn.sunjian.reflect;

import java.lang.reflect.Array;

/**
 * java������ƣ��ص㸴ϰ��
 * 
 * 		�������飺
 * 			�õ��������ݣ�
 * 			������������
 * 				�޸����ݣ�
 *			�޸������С��
 *				�޸ĵĹ���ʵ���Ͼ���һ�������Ĺ��̣�����һ���µ����飬���ɵ����ݿ������µ������У���
 * 
 * @author jack
 *
 */
public class ClassArrayDemo {

	public static void main(String[] args) {
		
		int temp[] = {1,2,3};//����һ����������
		
		/*
		 * �õ����飻
		 * �޸����ݣ�
		 */
		Class<?> c = temp.getClass().getComponentType();//�õ������Class����
		System.out.println("���ͣ�"+c.getName());//ȡ��������������
		System.out.println("���ȣ�"+Array.getLength(temp));//ȡ�����鳤��
		System.out.println("��һ�����ݣ�"+Array.get(temp, 0));//��һ������
		
		Array.set(temp, 0, 6);//�޸ĵ�һ���������Ϊ��6��
		System.out.println("��һ�����ݣ�"+Array.get(temp,0));//�޸ĺ�ĵ�һ������
		
		/*
		 * �޸������С
		 */
		int newTemp[] = (int[]) arrayInc(temp, 6);
		print(newTemp);
		System.out.println("\n----------------------");
		String strArr[] = {"adfasf","adsfasdf","adsfasdf"};
		String newStrArr[] = (String[]) arrayInc(strArr, 8);
		print(newStrArr);
	}

	//�޸����鷽��
	public static Object arrayInc(Object obj,int len){
		Class<?> c = obj.getClass();//�õ�Class����
		Class<?> arr = c.getComponentType();//�õ������Class����
		
		Object newO = Array.newInstance(arr, len);//�����µĴ�С
		int co = Array.getLength(obj);//�õ����������ĳ���
		System.arraycopy(obj, 0, newO, 0, co);//��������
		
		return newO;//����������
	}
	
	//�������
	public static void print(Object obj){
		Class<?> cc = obj.getClass();//�õ�Class��Ķ���
		if (!cc.isArray()) {//�����������
			return;
		}
		Class<?> arr = cc.getComponentType();//�õ��������
		System.out.println(arr.getName()+"����ĳ��ȣ�"+Array.getLength(obj));
		for(int i=0;i<Array.getLength(obj);i++){
			System.out.print(Array.get(obj, i)+"��");
		}
	}
}
