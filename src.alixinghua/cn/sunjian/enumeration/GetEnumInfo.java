package cn.sunjian.enumeration;
/*
 * ö�٣�
 * 		��ȡö�ٵ�Ĭ�ϱ��
 */
public class GetEnumInfo {

	public static void main(String[] args) {

		for(Colors c : Colors.values()){
			System.out.println(c.ordinal()+"-->"+c.name());
		}
	}

}
