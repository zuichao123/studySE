package cn.sunjian.proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * java������ƣ�
 * 		
 * 		�������ģʽ�����������ϰ
 * 			��ͨ��ʽ����򵥵Ĺ������ģʽ����
 * 			ͨ��������ɣ���������ʱ������ȥ�޸Ĺ����ࣻ
 * 				ͨ�������ļ��ķ�ʽ������Щ������·����
 * 
 * @author jack
 *
 */
interface Fruit{
	public void eat();//���󷽷����ԣ�
}

class Apple implements Fruit{
	public void eat(){
		System.out.println("��ƻ����������������");
	}
}
class Orange implements Fruit{
	public void eat(){
		System.out.println("�����ӡ�������������");
	}
}

class Factory{
	public static Fruit getInstance(String className){
		
		Fruit fruit = null;
		
		if ("apple".equals(className)) {
			fruit = new Apple();
		}
		if ("orange".equals(className)) {
			fruit = new Orange();
		}
		
		/*
		 * ͨ��������ɣ���������ʱ������ȥ�޸Ĺ�����
		 * 
		 * ������һ����򵥵Ĺ������ģʽ�����������Ĵ���������⣺
		 * 	�������������һ�����࣬��϶�Ҫ�޸Ĺ����ࡣ
		 * �����ʱϣ������������ʱ�����޸Ĺ�����Ļ�����ͱ���ʹ�÷�����ɡ�
		 */
		
		try {
			fruit = (Fruit) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * ͨ��������ɣ���������ʱ������ȥ�޸Ĺ����ࣨͨ�������ļ��ķ�ʽ������Щ������·������
		 * 	
		 * ���ϵĳ����������Ȼ�������⣬��ʹ�õ�ʱ�����������ġ���.�ࡱ���ƵĻ����϶����鷳�����п���ͨ��
		 * һЩ�����ļ��ķ�ʽ������Щ������·����	
		 * 
		 */
		
		return fruit;
	}
}

/*
 * ͨ�������ļ���ʽ��ȡ���ļ���·����Ϣ
 */
class Init{
	public static Properties getPro(){//�õ������ļ�
		
		Properties pro = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src.lixinghua\\cn\\sunjian\\proxy\\config.properties");//�ҵ������ļ�
		
		if (file.exists()) {
			try {
				pro.load(new FileInputStream(file));//��ȡ�����ļ�
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			pro.setProperty("apple", "cn.sunjian.proxy.Apple");//��������
			pro.setProperty("orange", "cn.sunjian.proxy.Orange");
			
			try {
				pro.store(new FileOutputStream(file), "Fruit Class");//�����õ�����д�������ļ�
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return pro;
	}
	/*
	 * ���ϵĳ���ﵽ�������ļ���������������Ŀ�ģ�
	 * ��ô�������˼·ʱ�Ժ󿪷��Ļ���˼·��
	 * ��Ȼ�����µ����������ڳ�����ֱ��ͨ��ע�͵ķ�ʽ�������ã�
	 */
}


public class FactoryDemo {

	public static void main(String[] args) {
		
		Properties pro = Init.getPro();
		
//		Fruit f = Factory.getInstance("apple");//��ͨ����
//		Fruit f = Factory.getInstance("cn.sunjian.proxy.Orange");//�������ʱ���贫��������
		Fruit f = Factory.getInstance(pro.getProperty("apple"));//ͨ�������ļ�����
		if (f != null) {			
			f.eat();
		}
	}

}
