package com.sunjian.gui;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class Path {

	public static String deskTop() {
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File com = fsv.getHomeDirectory().getAbsoluteFile();
		String path = com.toString().replaceAll("\\\\", "/") + "/";
		
		return path;
	}
}
