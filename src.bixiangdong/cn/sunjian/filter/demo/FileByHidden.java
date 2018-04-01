package cn.sunjian.filter.demo;

import java.io.File;
import java.io.FileFilter;

public class FileByHidden implements FileFilter {

	@Override
	public boolean accept(File pathname) {

		return !pathname.isHidden();
	}

}
