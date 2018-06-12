package cn.sunjian.enumeration;
/*
 * 枚举：
 * 		获取枚举的默认编号
 */
public class GetEnumInfo {

	public static void main(String[] args) {

		for(Colors c : Colors.values()){
			System.out.println(c.ordinal()+"-->"+c.name());
		}
	}

}
