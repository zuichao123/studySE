package cn.sunjian.filter;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByJava implements FilenameFilter {
	
	
	/**
	 * 指定盘符下的指定后缀文件---过滤器
	 */
	
	@Override
	public boolean accept(File dir, String name) {

		
		return name.endsWith(".java");
	}

}
