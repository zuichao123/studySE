package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Applications {

	/**
	 * ��ָ����Ӧ�ó���
	 * @param appPath Ӧ�ó���·��
	 * @param appName Ӧ�ó������ƣ���.exe��
	 */
	public static void openApp(String appPath,String appName){
		Runtime runtime = Runtime.getRuntime();
		File file = new File(appPath+"\\"+appName);
		try {
			if (!findProcess(appName)) {				
				runtime.exec(file.getAbsolutePath());
				System.out.println("��"+appName+"Ӧ�ó��򡣡���");
			}
			else
				System.out.println(appName+"Ӧ�ó����Ѿ�����������");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ɱ��ָ����Ӧ�ó���
	 * @param appName Ӧ�ó������ƣ���.exe��
	 */
	public static void killApp(String appName){
		Runtime runtime = Runtime.getRuntime();
		try {
			if (findProcess(appName)) {				
				runtime.exec("taskkill /F /IM "+appName);
				System.out.println("ɱ��"+appName+"Ӧ�ó��򡣡���");
			}else
				System.out.println(appName+"����û�п���������");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �ڽ����в���ָ����Ӧ�ó����Ƿ�����
	 * @param processName Ӧ�ó��������
	 * @return ����?true:false
	 */
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
	
}
