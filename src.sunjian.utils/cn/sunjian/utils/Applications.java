package cn.sunjian.utils;

import java.io.File;
import java.io.IOException;

public class Applications {

	public static void openApp(String appPath,String appName){
		Runtime runtime = Runtime.getRuntime();
		File file = new File(appPath+"\\"+appName);
		try {
			runtime.exec(file.getAbsolutePath());
			System.out.println("��"+appName+"Ӧ�ó��򡣡���");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void killApp(String appName){
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM "+appName);
			System.out.println("ɱ��"+appName+"Ӧ�ó��򡣡���");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String appPath = "E:\\ButtonElf\\path\\ButtonElf";
		String appName = "2014.exe";
		openApp(appPath,appName);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		killApp(appName);
	}
}
