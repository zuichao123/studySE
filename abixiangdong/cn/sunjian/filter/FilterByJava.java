package cn.sunjian.filter;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByJava implements FilenameFilter {
	
	
	/**
	 * ָ���̷��µ�ָ����׺�ļ�---������
	 */
	
	@Override
	public boolean accept(File dir, String name) {

		
		return name.endsWith(".java");
	}

}
