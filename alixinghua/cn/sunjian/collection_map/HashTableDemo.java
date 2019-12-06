package cn.sunjian.collection_map;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map������ϰ��
 * 
 * 		HashMap�������ŵģ��ǾɵĲ����࣬key�������ظ���
 * 			���ӡ�ȡ������
 * 
 * 		����ʹ��map.containsKey()�����ж�key�Ƿ����
 * 		����ʹ��map.containsValue()�����ж�Value�Ƿ����
 * 
 * @author jack
 *
 */
public class HashTableDemo {

	public static void main(String[] args) {

		Map<String, String> map = null;//����Map��������key��value��ֵΪString����
		
		map = new Hashtable<String,String>();//����ʵ�������ӿڶ���
		
		map.put("sunjian", "is chinese people!");//��������
		map.put("sunjian1", "is chinese peple!");
		map.put("sunjian2", "is chinese peple!");
		map.put("sunjian3", "is chinese peple!");
		map.put("sunjian4", "is chinese peple!");
		
		String val = map.get("sunjian");//����keyȡ��ֵ
		
		System.out.println("ȡ�������ݣ�"+val);//�������
		
		if (map.containsKey("sunjian")) {
			System.out.println("������key���ڣ�");
		}else {
			System.out.println("������key�����ڣ�");
		}
		
		if (map.containsValue("is chinese people!")) {
			System.out.println("������value���ڣ�");
		}else {
			System.out.println("������value�����ڣ�");
		}
		
		/*
		 * ���Ҫ���ȫ����keyʱ��ʹ�ã�Set�ӿ��е�map.keys()������ 
		 */
		System.out.print("ȫ����key��");
		Set<String> keys = map.keySet();//�õ�ȫ���ļ�key
		Iterator<String> iterator = keys.iterator();//����iterator()����ʵ����Iterator�ӿڶ���
		while(iterator.hasNext()){//�ж������Ƿ����
			String str = iterator.next();//�������
			System.out.print(str+"��");
		}
		
		System.out.print("\nȫ����value��");
		/*
		 * ���ȫ����value��ʹ�ã�Collection�ӿ��е�map.values()������
		 */
		Collection<String> values = map.values();//�õ�ȫ����valueֵ
		Iterator<String> iterator2 = values.iterator();
		while(iterator2.hasNext()){
			String str2 = iterator2.next();
			System.out.print(str2+"��");
		}
		
	}

}
