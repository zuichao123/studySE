package cn.sunjian.reflect_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * ��������
 */

public class RelectTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Mainboard mb = new Mainboard();
		mb.run();
		//ÿ�����һ���豸����Ҫ�޸Ĵ��봫��һ���´����Ķ���
//		mb.usePCI(new SoundCard());
		/*
		 * �ܲ��ܲ��޸Ĵ���Ϳ���������������
		 * ����new����ɣ�����ֵ��ȡ��class�ļ������ڲ�ʵ�ִ�������Ķ�����
		 */
		
		File configFile = new File(System.getProperty("user.dir")+"/files/bixiangdong/others/pci.properties");
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(configFile);
		
		prop.load(fis);
		
		for (int i = 0; i < prop.size(); i++) {
			String pciName = prop.getProperty("pci"+(i+1));
			
			Class<?> clazz = Class.forName(pciName);//��classȥ�������pci���ࡣ
		
			PCI p = (PCI)clazz.newInstance();
		
			mb.usePCI(p);
			
		}
		
		fis.close();
	}

}
