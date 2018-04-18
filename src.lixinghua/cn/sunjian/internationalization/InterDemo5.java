package cn.sunjian.internationalization;

import java.util.ListResourceBundle;

/**
 * 国际化操作练习：
 * 		
 * 		java新特性：使用一个类代替资源文件
 * 
 * 
 * @author jack
 *
 */
class Message_zh_CN extends ListResourceBundle{
	private final Object data[][] = {
			{"info","中文，你好，{0}！"},
			{"info","英文，hello"},
			{"info","法语,nihao"}
	};
	//覆写方法
	public Object[][] getContents(){
		return data;
	}
}


public class InterDemo5 {

	public static void main(String[] args) {
		Message_zh_CN mzc = new Message_zh_CN();
		
		Object[][] arr = mzc.getContents();
		
		for(int x=0;x<arr.length;x++){
			for(int y=0;y<arr.length-1;y++){
				System.out.print(arr[x][y]+"、");
			}
			System.out.println();
		}
	}
}
