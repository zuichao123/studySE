package cn.sunjian.otherapi;

import java.io.IOException;

/**
 * Runtime:û�й��췽��ժҪ��˵�����಻���Դ�������
 * �ַ��ֻ��зǾ�̬�ķ�����˵������Ӧ���ṩ��̬�ķ��ظ������ķ�����
 * ����ֻ��һ����˵��Runtime��ʹ�õ������ģʽ��
 * 
 * @author sunjian
 *
 */
public class RuntimeDemo {

	public static void main(String[] args) throws IOException, InterruptedException {

		Runtime r = Runtime.getRuntime();
		
//		r.exec("notepad.exe");
//		r.exec("./QQ.exe");
		
		//ʹ��notepad��c���µ��пƺ�Լ��.txt�ļ�
//		r.exec("notepad.exe c:\\�пƺ�Լ��.txt");
		
		Process p = r.exec("notepad.exe");
		Thread.sleep(3000);
		//ɱ������
		p.destroy();
	}

}
