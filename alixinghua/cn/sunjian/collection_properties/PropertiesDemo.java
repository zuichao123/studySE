package cn.sunjian.collection_properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Properties�ࣺ
 * 
 * 		�������ԡ��õ�����
 * 
 * @author sunjian
 *
 */
public class PropertiesDemo {

	public static void main(String[] args) throws IOException {

		Properties pro = new Properties();
		
		//��������
		pro.setProperty("bj", "beijing");
		pro.setProperty("nj", "nanjing");
		pro.setProperty("tj", "tianjing");
	
		//������д��xml�ļ���
		File file = new File("c:"+File.separator+"properties.xml");
		OutputStream out = new FileOutputStream(file);
		pro.storeToXML(out, "properties info");//�������Ե�ָ���ļ�
		
		//��ȡ��ͨxml�е�������Ϣ
		InputStream input = new FileInputStream(file);
		pro.loadFromXML(input);//��ȡ�ļ�
		
		System.out.println(pro.getProperty("nj"));
		
	}

}
