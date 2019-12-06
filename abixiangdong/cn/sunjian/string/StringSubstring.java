package cn.sunjian.string;

/**
 * 判斷一個字串在字符串中出現的次數
 * “nbaernbatynba”
 * 
 * 思路：
 * 1.要找的字串是否存在，如果存在獲取其出現的位置，這個可以使用indexOf完成
 * 2.如果找到了，那麼就記錄出現的位置並在剩餘的字符串中繼續查找該字串，
 *   而剩餘字符串的其實位是出現位置+字串的長度
 * 3.以此類推，通過循環完成查找，如果找不到就是-1，並對每次找到用計數器記錄
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
	 * 獲取字串在整串中出現的次數
	 * @param str
	 * @param key
	 * @return
	 */
	public static int getKeyStringCount(String str, String key) {
		
		//定義計數器
		int count = 0;
		
		//定義變量記錄key出現的位置
		int index = 0;
		
		while((index = str.indexOf(key))!=-1){
			str = str.substring(index+key.length());
			count++;
		}
		return count;
	}

}
