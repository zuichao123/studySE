package cn.sunjian.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Applications {

	public static void openApp(String appPath,String appName){
		Runtime runtime = Runtime.getRuntime();
		File file = new File(appPath+"\\"+appName);
		try {
			if (!findProcess(appName)) {				
				runtime.exec(file.getAbsolutePath());
				System.out.println("打开"+appName+"应用程序。。。");
			}
			else
				System.out.println(appName+"应用程序已经开启。。。");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void killApp(String appName){
		Runtime runtime = Runtime.getRuntime();
		try {
			if (findProcess(appName)) {				
				runtime.exec("taskkill /F /IM "+appName);
				System.out.println("杀死"+appName+"应用程序。。。");
			}else
				System.out.println(appName+"程序没有开启。。。");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean findProcess(String processName){
		boolean flag = false;
		BufferedReader bf = null;
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec("tasklist");
			bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			while((line = bf.readLine()) != null){
				if (line.contains(processName))
					flag = true;
				//System.out.println(line.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	
	
	
	
	
	public static void main(String[] args) {
		String appPath = "E:\\ButtonElf\\path\\ButtonElf";
		String appName = "2014.exe";
//		openApp(appPath,appName);
//		try {
//			Thread.sleep(30000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		killApp(appName);
		
		//System.out.println(findProcess(appName));
	}
}
