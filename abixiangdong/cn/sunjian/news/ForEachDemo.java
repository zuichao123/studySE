package cn.sunjian.news;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * for each��ϰ
 * 
 * @author sunjian
 *
 */
public class ForEachDemo {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("abc");
		list.add("abc");
		
		for(String s:list){
			System.out.println(s);
		}
		
		/**
		 * ��ͳfor�͸߼�for������
		 * ��ͳfor������ɶ����ִ�кܶ�Σ���Ϊ���Զ������ѭ����������������
		 * 
		 * �߼�for��һ�ּ���ʽ��
		 * �������б�����Ŀ�ꡣ��Ŀ��Ҫô�����飬Ҫô��Collection���м��ϡ�
		 * 
		 * ������ı�����������ǻ�ȡ�����е�Ԫ�أ�����ʹ�ø߼�for��
		 * ���Ҫ������ĽǱ���в�������ʹ�ô�ͳfor��
		 */
		int[] arr = {4,5,2,7};
		
		for(int i:arr){
			System.out.println(i);
		}
		/**
		 * �߼�for���Ա���map������
		 * ����ֱ���ã����ǿ��Խ�mapת�ɵ��е�set���Ϳ������ˡ�
		 * 
		 */
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(3, "sunmiert");
		map.put(13, "sunmghisdg");
		map.put(34, "sdgunmgifgh");
		map.put(73, "htsunmi");
		
		for(Integer key:map.keySet()){
			String value = map.get(key);
			System.out.println(key+"=="+value);
		}
		
		for(Map.Entry<Integer, String> me: map.entrySet()){
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println(key+"---"+value);
		}
		
		
		
		
		
		
		
		
	}

}
