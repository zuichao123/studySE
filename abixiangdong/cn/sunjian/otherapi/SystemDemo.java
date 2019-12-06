package cn.sunjian.otherapi;

import java.util.Properties;
import java.util.Set;

/**
 * System��ķ��������Զ��Ǿ�̬��
 * 
 * @author sunjian
 *
 */
public class SystemDemo {
	/*
	 * ��������
	 * long currentTimeMillis();��ȡ��ǰʱ��ĺ���ֵ
	 * 
	 */

	public static void main(String[] args) {
		long l1 = System.currentTimeMillis();
		System.out.println(l1);
		long l2 = System.currentTimeMillis();
		System.out.println(l2);
		
		//���ݲ���ϵͳ���з�
		System.out.println("hello-"+System.getProperty("line.separator")+"world");
		demo_1();
	}
	
	public static void demo_1(){
		/**
		 * ��ȡϵͳ��������Ϣ�����洢��Properties������
		 * 
		 * properties�����д洢�Ķ���String���͵ļ���ֵ
		 * ���ʹ�����Լ��Ĵ洢��ȡ���ķ��������Ԫ�صĲ�����
		 * 
		 */
		Properties prop = System.getProperties();
		
		Set<String> nameSet = prop.stringPropertyNames();
		
		for(String name : nameSet){
			String value = prop.getProperty(name);
			System.out.println(name+"::"+value);
		}
	}
}
