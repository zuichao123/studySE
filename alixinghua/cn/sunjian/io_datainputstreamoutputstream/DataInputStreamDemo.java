package cn.sunjian.io_datainputstreamoutputstream;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * ���ݲ���������ϰ��������������
 * 
 * 		���ݵĶ�ȡ��DataInputStream
 * 
 * @author sunjian
 *
 */
public class DataInputStreamDemo {

	public static void main(String[] args) throws IOException {
		File f = new File("c:"+File.separator+"DataOutputStream.txt");
		
		DataInputStream dis = null;
		
		dis = new DataInputStream(new FileInputStream(f));
		
		String name = null;//��������
		float price = 0.0f;//���ռ۸�
		int num = 0;//��������
		
		char temp[] = null;//�����Ʒ����
		int len = 0;//��¼���鳤��
		char c = 0;//���ն�ȡ�����ַ�
		
		try{
			while(true){
				temp = new char[200];//��������ռ�
				len = 0;//����������ʵλ��
				
				while((c = dis.readChar()) != '\t'){//�����ȡ���ַ�����'\t',��ʾ��������
					temp[len] = c;//�洢��������
					len++;
				}
				
				name = new String(temp, 0, len);//���洢���ַ������е������ַ���ת���ַ���
				price = dis.readFloat();//��ȡ�۸�
				dis.readChar();//��ȡ'\t'�ո�
				num = dis.readInt();//��ȡ����
				dis.readChar();//��ȡ'\n'����
				
				System.out.printf("���ƣ�%s���۸�%5.2f��������%d\n",name,price,num);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		dis.close();//�ر���
	}

}
