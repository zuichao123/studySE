package cn.sunjian.io_properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {

		/**
		 * Map
		 *  |--Hashtable
		 *  	|--Properties:
		 *  
		 *  Properties���ϣ�
		 *  �ص㣺
		 *  1,�ü����еļ���ֵ�����ַ�������
		 *  2,�����е����ݿ��Ա��浽���У����ߴ����л�ȡ
		 *  
		 *  ͨ���ü������ڲ����Լ�ֵ����ʽ���ڵ������ļ�
		 */
		
//		propertiesDemo();
//		methodDemo();
//		methodDemo_2();
//		methodDemo_3();
		
		myLoad();
	}
	
	//�����е������ļ��е���Ϣ�����޸�
	/**
	 * ��ȡ����ļ�
	 * ��������ļ��еļ�ֵ���ݴ洢��������
	 * ��ͨ�����϶����ݽ����޸�
	 * ��ͨ�������޸ĺ�����ݴ洢���ļ���
	 * @throws IOException 
	 */
	public static void test() throws IOException{
		
		//��ȡ����ļ�
		File file = new File("info.txt");
		if(!file.exists()){
			//�����ļ�
			file.createNewFile();
		}
		FileReader fr = new FileReader("info.txt");//��info.txt�ļ���������ж�ȡ
		
		//�������ϴ洢������Ϣ
		Properties pro = new Properties();
		
		//�����е����ݴ洢��������
		pro.load(fr);
		
		pro.setProperty("wangwu", "16");
		
		/*
		 * ���ڼ����и��꣬��������������������е����ݴ洢���´������ļ��У�
		 */
		
		FileWriter fw = new FileWriter(file);//�´���һ��file�ļ�
		
		pro.store(fw, "");//�������е����ݴ洢���ļ���
		
		fw.close();
		fr.close();
		
	}
	
	
	//ģ��һ��load����
	public static void myLoad() throws IOException{
		
		Properties properties = new Properties();
		
		BufferedReader bufr = new BufferedReader(new FileReader("info.txt"));
		
		String line = null;
		
		while((line = bufr.readLine()) !=null){
			
			if(line.startsWith("#"))
				continue;
			String [] arr = line.split("=");
			
//			System.out.println(arr[0]+"::"+arr[1]);
			properties.setProperty(arr[0], arr[1]);
		}
		
		properties.list(System.out);
		
		bufr.close();
	}
	
	
	public static void methodDemo_3() throws IOException {
		
		/**
		 * ��ȡ�ļ��е�����
		 */
		
		Properties pro = new Properties();
		
		//�����е�����������һ���ļ�
		//ע�⣺����Ҫ��֤���ļ��е������Ǽ�ֵ��
		//��Ҫʹ�õ���ȡ��
		
		FileInputStream fis = new FileInputStream("info.txt");
		
		//ʹ��load���� ��ȡ�ļ��е�����
		pro.load(fis);
		
		pro.list(System.out);
		
		
	}


	public static void methodDemo_2() throws IOException {

		/**
		 * �������е����ݴ洢���ļ���
		 */
		Properties pro = new Properties();
		
		//�洢Ԫ��
		pro.setProperty("zhangsan", "30");
		pro.setProperty("lisi", "31");
		pro.setProperty("wangwu", "36");
		pro.setProperty("zhaoliu", "20");
		
		//��Ҫ����Щ�����е��ַ�����ֵ��Ϣ�־û��洢���ļ���
		//��Ҫ���������
		FileOutputStream fos = new FileOutputStream("info.txt");
		
		//�����������ݴ洢���ļ��У�ʹ��store����
		pro.store(fos, "name+age");//name+age��ע����Ϣ
		
		fos.close();
		
		
	}


	//store()�������ڴ洢
	
	
	
	
	
	
	/**
	 * ��ʾProperties���Ϻ����������ϵĹ���
	 * 
	 * ����ʱ���õĶ࣬��������е�����
	 */
	
	public static void methodDemo(){
		Properties pro = new Properties();
		
		//�洢Ԫ��
		pro.setProperty("zhangsan", "30");
		pro.setProperty("lisi", "31");
		pro.setProperty("wangwu", "36");
		pro.setProperty("zhaoliu", "20");
		
		pro = System.getProperties();
		
		pro.list(System.out);
		
	}
	
	
	
	
	/**
	 * Properties���ϵĴ��ȡ
	 * 
	 */
	public  static void propertiesDemo(){
		
		//Properties����һ�� ����
		
		Properties pro = new Properties();
		
		//�洢Ԫ��
		pro.setProperty("zhangsan", "30");
		pro.setProperty("lisi", "31");
		pro.setProperty("wangwu", "36");
		pro.setProperty("zhaoliu", "20");
		
		
		//�޸�Ԫ��
		pro.setProperty("wangwu", "26");//�޸������ֵ
		
		
		
		//ȡ������Ԫ��
		Set<String > names = pro.stringPropertyNames();//ȡ�������洢��set������
		
		for(String name:names){
			
			String str = pro.getProperty(name);//����names���ϣ�����name����ȡ��Ӧ��ֵ
			System.out.println(name+":"+str);//��ӡ
		}
	}

}
