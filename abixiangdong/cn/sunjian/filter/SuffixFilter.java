package cn.sunjian.filter;

import java.io.File;
import java.io.FilenameFilter;

public class SuffixFilter implements FilenameFilter {
	
	private String suffix;
	
	/**
	 * 专门过滤后缀名的过滤器
	 * @param suffix
	 */

	public SuffixFilter(String suffix) {
		super();
		this.suffix = suffix;
	}


	@Override
	public boolean accept(File dir, String name) {

		return name.endsWith(suffix);
	}

}
