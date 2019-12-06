package cn.sunjian.collection_map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map������ϰ��
 * 
 * 		HashMap�������ŵģ����µĲ����࣬key�������ظ���
 * 			���ӡ�ȡ������
 * 
 * 		����ʹ��map.containsKey()�����ж�key�Ƿ����
 * 		����ʹ��map.containsValue()�����ж�Value�Ƿ����
 * 
 * @author jack
 *
 */
public class HashMapDemo {

	public static void main(String[] args) {

		Map<String, String> map = null;//����Map��������key��value��ֵΪString����
		
		map = new HashMap<String,String>();//����ʵ�������ӿڶ���
		
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
		Set<String> keys = map.keySet();//�õ�ȫ���ļ�key
		Iterator<String> iterator = keys.iterator();//����iterator()����ʵ����Iterator�ӿڶ���
		while(iterator.hasNext()){//�ж������Ƿ����
			String str = iterator.next();//�������
			System.out.print(str+"��");
		}
		
		System.out.println();
		/*
		 * ���ȫ����value��ʹ�ã�Collection�ӿ��е�map.values()������
		 */
		Collection<String> values = map.values();//�õ�ȫ����valueֵ
		Iterator<String> iterator2 = values.iterator();
		while(iterator2.hasNext()){
			String str2 = iterator2.next();
			System.out.print(str2+"��");
		}
		
		System.out.println();
		/*
		 * ���ȫ����key+value����ʽһ��ʹ�ã����ݼ���ֵ�ķ�ʽ
		 */
		Set<String> keys2 = map.keySet();//�õ�ȫ���ļ�key
		Iterator<String> iterator3 = keys2.iterator();//����iterator()����ʵ����Iterator�ӿڶ���
		while(iterator3.hasNext()){//�ж������Ƿ����
			String strKey = iterator3.next();//���key������
			String strValue = map.get(strKey);//����key�õ�ֵ
			System.out.print(strKey+"="+strValue+"��");
		}
		
		System.out.println();
		/*
		 * ���ȫ����key+value����ʽ����ʹ�ã�ʹ��Map.Entry()��������ֵ��ӳ���ϵ��Ϊ���󣬴洢��Set���ϵ���
		 */
		Set<Map.Entry<String, String>> sets = map.entrySet();//
		Iterator<Map.Entry<String, String>> iter = sets.iterator();//����iterator()����ʵ����Iterator�ӿڶ���
		while(iter.hasNext()){//�ж������Ƿ����
			Map.Entry<String, String> maps = iter.next();
			String strKey = maps.getKey();//���key������
			String strValue = maps.getValue();//����key�õ�ֵ
			System.out.print(strKey+"="+strValue+"��");
		}
		
		System.out.println();
		/*
		 * ���ȫ����key+value����ʽ����ʹ�ã�foreach��ʽ���
		 */
		for(Map.Entry<String, String> maps : map.entrySet()){
			String strKey = maps.getKey();
			String strValue = maps.getValue();
			
			System.out.print(strKey+"-->"+strValue+"��");
		}
	}
}
