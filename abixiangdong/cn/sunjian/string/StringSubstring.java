package cn.sunjian.string;

/**
 * �Д�һ���ִ����ַ����г��F�ĴΔ�
 * ��nbaernbatynba��
 * 
 * ˼·��
 * 1.Ҫ�ҵ��ִ��Ƿ���ڣ�������ګ@ȡ����F��λ�ã��@������ʹ��indexOf���
 * 2.����ҵ��ˣ����N��ӛ䛳��F��λ�ÁK��ʣ�N���ַ������^�m����ԓ�ִ���
 *   ��ʣ�N�ַ������䌍λ�ǳ��Fλ��+�ִ����L��
 * 3.�Դ���ƣ�ͨ�^ѭ�h��ɲ��ң�����Ҳ�������-1���K��ÿ���ҵ���Ӌ����ӛ�
 * 
 * @author sunjian
 *
 */
public class StringSubstring {

	public static void main(String[] args) {
		
		String str = "nbaernbatynba";
		String key = "nba";
		
		int count = getKeyStringCount_2(str, key);
		System.out.println(key.length());
		System.out.println("count="+count);
	}

	public static int getKeyStringCount_2(String str, String key) {
		
		int count = 0;
		int index = 0;
		
		while((index = str.indexOf(key, index))!=-1){
			
			index = index + key.length();
			count++;
		}
		return count;
	}

	/**
	 * �@ȡ�ִ��������г��F�ĴΔ�
	 * @param str
	 * @param key
	 * @return
	 */
	public static int getKeyStringCount(String str, String key) {
		
		//���xӋ����
		int count = 0;
		
		//���x׃��ӛ�key���F��λ��
		int index = 0;
		
		while((index = str.indexOf(key))!=-1){
			str = str.substring(index+key.length());
			count++;
		}
		return count;
	}

}
