package cn.sunjian.io_transstream;

import java.io.IOException;
import java.io.InputStream;

/**
 * ��ȡ����¼����ϵ
 * 
 * @author sunjian
 *
 */
public class ReadKey {

	public static void main(String[] args) throws IOException {

		readKey_2();
	}

	public static void readKey_2() throws IOException {
		/**
		 * ��ȡ�û�����¼�������
		 * �������ݱ�ɴ�д��ʾ�ڿ���̨��
		 * ����û��������over����������¼�롣
		 * 
		 * ˼·��
		 * 1����Ϊ����¼��ֻ��ȡһ���ֽڣ�Ҫ�ж��Ƿ���over����Ҫ����ȡ�����ֽ�ƴ���ַ���
		 * 2���Ǿ���Ҫһ��������StringBuilder
		 * 3�����û��س�֮�佫¼������ݱ���ַ����жϼ��ɡ�
		 * 
		 */
		//1,��������
		StringBuilder sb = new StringBuilder();
		
		//2,��ȡ���̶�ȡ��
		InputStream in = System.in;
		
		//3,���������¼��ȡ�����ֽڣ���ѭ����ȡ
		int ch = 0;
		 while((ch=in.read())!=-1){
			 
			 //�ڴ洢֮ǰ��Ҫ�ж��Ƿ��ǻ��б�ǣ���Ϊ���б�ǲ��洢
			 if(ch=='\r')
				 continue;
			if(ch=='\n'){
				 String temp = sb.toString();
			 	if("over".equals(temp))
			 		break;
			 	System.out.println(temp.toString());
			 	sb.delete(0, sb.length());
			}
			else {
				//����ȡ�����ֽڴ洢��StringBuilder��
				sb.append((char)ch);
			}
		 }
	}

}
