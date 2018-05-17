package cn.sunjian.io.system;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * System�����IO��֧��
 * 
 * 		���롢����ض���
 * 			
 * 
 * @author jack
 *
 */
public class SystemSetDemo {

	public static void main(String[] args) throws IOException {

		reSystemOut();
		reSystemOut2();
		reSystemErr();
		reSystemIn();
	
	}

	//�ض������¼����Ϣ
	private static void reSystemIn() {

		try {
			System.setIn(
					new FileInputStream(
							new File("c:"+File.separator+"text8.txt")));//���������ض���
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		InputStream input = System.in;//ʵ�������ֽ������������ļ��н������ݣ�
		
		byte[] b = new byte[1024];//��ż���¼�����Ϣ
		int len = 0;
		try {
			len = input.read(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("��������ݣ�\r\n"+new String(b,0,len));
		
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//������Ĵ������ض���
	private static void reSystemErr() {

		ByteArrayOutputStream bos = null;//�����ڴ������
		
		bos = new ByteArrayOutputStream();//ʵ����
		
		System.setErr(new PrintStream(bos));//����ض���
		System.err.println("12345678lsfgdlfgk");//��������Ϣ������ڴ���
		
		System.out.println(bos);//���ڴ��б������Ϣ���
	}

	//��������Ϣ�ض���
	private static void reSystemOut2() {

		String str = "jack";
		
		try {
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			try {
				System.setOut(
						new PrintStream(
								new FileOutputStream(
										new File("c:"+File.separator+"error.log"))));//����ض���
			} catch (FileNotFoundException e1) { }
			System.out.println(e);
		}
	}

	//�������Ϣ�ض���
	private static void reSystemOut() {
		try {
			System.setOut(
					new PrintStream(
							new FileOutputStream(
									new File("c:"+File.separator+"text8.txt"))));//����ض���
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.print("ɽ���ٷڣ�");
		System.out.println("sunjian");
	}

}
