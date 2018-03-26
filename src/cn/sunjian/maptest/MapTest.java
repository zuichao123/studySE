package cn.sunjian.maptest;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * ��ϰ��
 * ��fdgavcbsacdfs����ȡ���ַ����У�ÿһ����ĸ���ֵĴ���
 * Ҫ�󣺴�ӡ�����a(2)b(1)...
 * 
 * ���ڽ���ķ������֣���ĸ�ʹ���֮�������ӳ��Ĺ�ϵ���������ֹ�ϵ�ܶࡣ
 * �ܶ����Ҫ�洢���ܴ洢ӳ���ϵ�������������map���ϡ�
 * ��ϵ��һ������������û�У�
 * �Ǿ�ʹ��Map���ϡ��ַ��ֿ��Ա�֤Ψһ�Ե�һ���߱���˳����a b c...
 * ���п���ʹ��TreeMap���ϡ�
 * 
 * ������������մ洢������ĸ�ʹ����Ķ�Ӧ��ϵ��
 * 1.��Ϊ���������ַ����е���ĸ�������Ƚ��ַ�������ַ����顣
 * 2.�����ַ����飬��ÿһ����ĸ��Ϊ��ȥ��Map���������
 * 3.�������ĸ�������ڣ��ͽ�����ĸ��Ϊ��1��Ϊֵ�洢��map�����С�
 * 4.�������ĸ�����ڣ��ͽ�����ĸ����Ӧֵȡ��+1���ڽ�����ĸ��+1���ֵ�洢��map�����С�
 * 5.����ֵͬ�Ḳ�ǣ������ͼ�¼�˸���ĸ�Ĵ�����
 * 6.����������map���Ͼͼ�¼��������ĸ���ֵĴ�����oy
 * 
 * @author sunjian
 *
 */
public class MapTest {

	public static void main(String[] args) {
		String str = "fd g5a7v c$ytrGerYt9e   w#sdf_ds12  +dfbWsacOdfs";
		
		String s = getCharCount(str);
		
		System.out.println(s);
	}

	public static String getCharCount(String str) {
		
		//���ַ���ת���ַ�����
		char[] ch = str.toCharArray();
		
		//����map���ϱ�
		Map<Character, Integer> map = new TreeMap<Character,Integer>();
		
		for (int i = 0; i < ch.length; i++) {
			//�жϱ���ʱ���ַ��Ƿ�Ϊ��ĸ
			if(!(ch[i]>='a' && ch[i]<='z' || ch[i]>='A' && ch[i]<='Z'))
				continue;
			//�������е���ĸ��Ϊ��ȥ��map��
			Integer value = map.get(ch[i]);
			
			//�ж�ֵ�Ƿ�Ϊnull
			int count = 1;
			if (value!=null) {
				count = value+1;
			}
			map.put(ch[i], count);
			
			/*if (value==null) {
				map.put(ch[i], 1);
			}else {
				map.put(ch[i], value+1);
			}*/
			
		}
		
		
		return mapToString(map);
	}

	private static String mapToString(Map<Character, Integer> map) {
		
		StringBuilder sb = new StringBuilder();
		
		Iterator<Character> it = map.keySet().iterator();
		while(it.hasNext()){
			Character key = it.next();
			Integer value = map.get(key);
			
			sb.append(key+"("+value+")");
		}
		return sb.toString();
	}

}
