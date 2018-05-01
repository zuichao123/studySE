package cn.sunjian.io.datainputandoutputstream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���ݲ���������ϰ�������������
 * 		
 * 		���ݵ�д�룺DataOutputStream
 * 
 * @author sunjian
 *
 */
public class DataOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		File f = new File("c:"+File.separator+"DataOutputStream.txt");//�����ļ�
		
		DataOutputStream dos = null;//�����������������
		
		dos = new DataOutputStream(new FileOutputStream(f));//ʵ�������������
		
		String names[] = {"����","����","Ь"};//����
		Float prices[] = {123.8f,234.9f,1234.10f};//�۸�
		int nums[] = {3,2,1};//����
		
		for(int i=0;i<names.length;i++){			
			dos.writeChars(names[i]);//д������
			dos.writeChar('\t');//д��ո�ָ���
			dos.writeFloat(prices[i]);//д��۸�
			dos.writeChar('\t');//д��ո�ָ���
			dos.writeInt(nums[i]);//д������
			dos.writeChar('\n');//д�뻻��
		}
		dos.close();//�ر������
	}
}
