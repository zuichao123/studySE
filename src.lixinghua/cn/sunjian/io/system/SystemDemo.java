package cn.sunjian.io.system;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * System�����IO��֧��
 * 
 * 		System.out
 * 		System.err
 * 		System.in
 * 
 * 		1.����ǰʱ���ӡ����Ļ��
 * 		2.��ӡ������Ϣ
 * 		3.����¼����Ϣ������ӡ
 * 
 * @author jack
 *
 */
public class SystemDemo {

	public static void main(String[] args) {

//		systemOut();//�����Ϣ����ʾ��
//		systemErr();//��ӡ������Ϣ
//		systemIn();//����¼����Ϣ
		systemIn2();//����¼����Ϣ����һ��ʵ�ַ�ʽ
	}

	private static void systemIn2() {

		InputStream in = null;//�����ֽ�������
		in = System.in;//ʵ����
		StringBuffer sb = new StringBuffer();//����StringBuffer���󣬱������������
		
		System.out.println("�����룺");
		int temp = 0;//��¼��ȡ��������
		try {
			while((temp = in.read()) != -1){//�жϱ�־λ���Ƿ�������
				char c = (char)temp;
				sb.append(c);//��������
				if (c == '\n') {//����س��������˳�
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("�������Ϣ��"+sb);
		
		try {
			in.close();//�ر��ֽ�������
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void systemIn() {

		InputStream in = null;//�����ֽ�����������
		
		in = System.in;//ʵ����������¼��
		
		byte[] b = new byte[1024];//�����ֽ����飬���ڴ��¼�������
		System.out.println("�����룺");
		
		int len = 0;//��¼����ĳ���
		try {
			len = in.read(b);//��¼������ݣ����뵽byte�����У�����������ĳ���
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("�������Ϣ��"+new String(b,0,len));
		
		try {
			in.close();//�ر�������
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void systemErr() {

		String string = "hello";

		try {
			System.out.println(Integer.parseInt(string));
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	private static void systemOut() {
		OutputStream out = null;//�����ֽ����������
		
		out = System.out;//ʵ��������ʱ�������������Ļ�������
		
		Date date = new Date();
		String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String now = sdf.format(date);

		try {
			out.write(("�����Ǳ���ʱ�䣺"+now).getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			out.close();//�ر������
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
