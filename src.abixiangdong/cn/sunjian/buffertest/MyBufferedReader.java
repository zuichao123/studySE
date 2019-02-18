package cn.sunjian.buffertest;

import java.io.FileReader;
import java.io.IOException;

/**
 * �Զ���Ķ�ȡ����������ʵ����ģ��BufferReader
 * 
 * ������
 * ���������޷Ǿ��Ƿ�װ��һ������
 * �������ṩ�˸���ķ�����������з���
 * ��ʵ��Щ�������ղ����Ķ�������ĽǱ�
 * 
 * �����ԭ��
 * ��ʵ���Ǵ�Դ�л�ȡһ������װ����������
 * �ڴӻ������в��ϵ�ȡ��һ��һ�����ݡ�
 * 
 *�ڴ˴�ȡ����ٴ�Դ�м���ȡһ�����ݽ�������
 *��Դ�е�����ȡ��ʱ����-1��Ϊ������ǡ�
 * 
 * 
 * 
 * @author sunjian
 *
 */
public class MyBufferedReader {
	
	private FileReader r;
	//����һ��������Ϊ������
	private  char[] buf = new char[1024];
	//����һ��ָ�����ڲ�����������е�Ԫ�أ������������һ��Ԫ�غ�ָ��Ӧ��Ϊ��
	private int pos = 0;
	//����һ�����������ڼ�¼�������е����ݸ������������ݼ���0���ʹ�Դ�м�����ȡ���ݵ��������С�
	private int count =0;
	
	
	public MyBufferedReader(FileReader r) {
		this.r = r;
	}
	public static void main(String[] args) {
	
		
	}

	/**
	 * �÷����ӻ�������һ��ȡһ���ַ�
	 * 
	 * @return
	 * @throws IOException 
	 */
	public int myRead() throws IOException{
		
		if(count==0){
			count = r.read(buf);
			pos = 0;
		}
		if (count<0) 
			return -1;
			
		char ch = buf[pos++];
		count--;
		return ch;
		
		
		//1����Դ�л�ȡһ�����ݵ���������.��Ҫ�����жϣ�ֻ�м�����Ϊ0ʱ������Ҫ��Դ�л�ȡ���ݡ�
		/*if(count == 0){
		count = r.read(buf);
		
		if(count<0)
			return -1;
		//ÿ�λ�ȡ���ݵ��������󣬽Ǳ��0
		pos = 0;
		char ch = buf[pos];
		pos++;
		count--;
		return ch;
		
		}else if(count>0){
			char ch = buf[pos];
			pos++;
			count--;
			return ch;
		}*/
					
	}
	
	public String myReadLine() throws IOException{
		
		StringBuilder sb = new StringBuilder();
		
		int ch = 0;
		
		while((ch=myRead())!=-1){
			
			if (ch=='\r')//�س�
				continue;
			if(ch=='\n')//����====��\t  tab��
				return sb.toString();
			
			sb.append((char)ch);
		}
		
		if(sb.length()!=0)
			return sb.toString();
		
		return null;
	}
	public void myClose() throws IOException {
		
		r.close();
	}
	
}
