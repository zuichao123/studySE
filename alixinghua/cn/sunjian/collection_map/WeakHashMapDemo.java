package cn.sunjian.collection_map;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Map������ϰ��
 * 
 * 		WeakHashMap�������õ�Map���ϣ��������е�ĳЩ���ݲ���ʹ��ʱ��������������õ����ݣ�����ʹ��gc���л��գ�
 *  
 * @author jack
 *
 */
public class WeakHashMapDemo {

	public static void main(String[] args) {

		Map<String, String> map = null;//����Map��������key��value��ֵΪString����
		
		map = new WeakHashMap<String,String>();//����ʵ�������ӿڶ���
		
		map.put(new String("sunjian"), new String("123456"));
		map.put(new String("sunjian1"), new String("123457"));
		map.put(new String("sunjian2"), new String("123458"));
		
		System.gc();//ǿ���Խ����������ռ�����
		
		map.put(new String("sunjian"), new String("123456"));

		System.out.println(""+map);
		
	}

}
