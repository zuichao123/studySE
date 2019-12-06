package cn.sunjian.io_properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ���幦�ܣ���ȡһ��Ӧ�ó������еĴ������������5�Σ�����ʹ�ô����ѵ���ע�����ʾ������Ҫ���г���
 * 
 * ˼·��
 * 1,Ӧ���м�����
 * ÿ�γ�����������Ҫ����һ�Σ�������ԭ�еĴ����Ͻ��м���
 * 2.����������һ��������ͻȻð��һ���뷨����������ʱ�����м������������ͱ���������ڴ��н������㡣
 * ���ǣ���������أ���������ʧ�ˡ���ô�ٴ������ó��򣬼����������±���ʼ���ˡ�
 * ��������Ҫ�������ͬһ��Ӧ�ó���ʹ�õ�ʱͬһ����������
 * �����Ҫ���������������ڱ䳤�����ڴ�洢��Ӳ���ļ��С�
 * 3.���ʹ������������أ�
 * ���ȣ���������ʱ��Ӧ���ȶ�ȡ������ڼ�¼��������Ϣ�������ļ���
 * ��ȡ��һ�μ�����������������ʹ�ô������жϡ�
 * ��Σ��Ըôν�������������������Ĵ������´洢�������ļ��С�
 * 4.�ļ��е���Ϣ����ν��д洢�����֡�
 * ֱ�Ӵ洢����ֵ���ԣ����ǲ���ȷ�����ݵĺ��壬���������־ͱ�ú���Ҫ��
 * ����������ֺ�ֵ�Ķ�Ӧ�����п���ʹ�ü�ֵ�ԡ�
 * ����ӳ���ϵmap���ϸ㶨������Ҫ��ȡӲ���ϵ����ݣ�����map+io=Properties.
 * 
 * 
 * 
 * �򵥵������ļ���Properties
 * ���ӵ������ļ���xml
 * 
 * @author jack
 *
 */

public class PropertiesTest {

	public static void main(String[] args) throws IOException {

		getAppCount();
	}
	
	public static void getAppCount() throws IOException{
		//�������ļ���װ��File����
		File confile = new File("count.properties");
		
		if(!confile.exists()){//����ļ������ڣ��ʹ���һ��
			confile.createNewFile();
		}
		
		FileInputStream fis = new FileInputStream(confile);//���ļ���װ��һ���ֽ�������
		
		Properties prop = new Properties();//����һ�����ϣ� 
		
		prop.load(fis);//�����ݼ��ؽ���
		
		//�Ӽ�����ͨ������ȡ��������ȡֵ��
		String value = prop.getProperty("time");
		//�������������¼��ȡ���Ĵ�����
		int count = 0;
		if (value!=null) {//���ֵ��Ϊ��
			count = Integer.parseInt(value);//��ȡ��ֵ������ֵ���ַ���ת��������	
			if (count>=5) {//�����ֵ���ڵ���5
//				System.out.println("ʹ�ô����ѵ�����ע�Ṻ�����棡");
//				return;
				throw new RuntimeException("ʹ�ô����ѵ�����ע�Ṻ�����棡");
			}
		}
		count++;
		
		//���ı��Ĵ������´洢��������
		prop.setProperty("time", count+"");//����countΪ�������֣�����ת�����ַ���
		
		FileOutputStream fos = new FileOutputStream(confile);//���´���һ���ļ������ļ����ǵ������µ�����д�뵽�ļ���
		
		prop.store(fos, "");//��ӵ������У�ע��Ϊ������
		
		fos.close();
		fis.close();
		
	}

}
       