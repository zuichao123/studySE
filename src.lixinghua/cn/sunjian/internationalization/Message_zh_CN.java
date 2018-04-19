package cn.sunjian.internationalization;

import java.util.ListResourceBundle;

public class Message_zh_CN extends ListResourceBundle {

	
	private final Object data[][] = {
			{"info","中文123，你好456，{0}！"}
		
	};
	
	//覆写方法
	public Object[][] getContents(){//返回对象的二维数组
		return data;
	}
	
}
