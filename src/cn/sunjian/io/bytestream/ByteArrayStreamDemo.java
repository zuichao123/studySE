package cn.sunjian.io.bytestream;

/**
 * �����ֽ����飨Դ��Ŀ�Ķ����ڴ棩
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {

	public static void main(String[] args) {
		
		//һ�����������������ļ�������
		//���Դ���ڴ棬ֱ�ӹ���
		ByteArrayInputStream bis = new ByteArrayInputStream("adbcde".getBytes());
		//���Ŀ�����ڴ棬ֱ�ӹ���
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int ch = 0;
		
		while((ch=bis.read())!=-1){
			bos.write(ch);
		}
		System.out.println(bos.toString());
	}

}
