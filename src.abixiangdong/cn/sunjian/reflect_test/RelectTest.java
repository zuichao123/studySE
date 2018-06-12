package cn.sunjian.reflect_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * 电脑运行
 */

public class RelectTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Mainboard mb = new Mainboard();
		mb.run();
		//每次添加一个设备都需要修改代码传递一个新创建的对象。
//		mb.usePCI(new SoundCard());
		/*
		 * 能不能不修改代码就可以完成这个动作。
		 * 不用new来完成，而是值获取其class文件。在内部实现创建对象的动作。
		 */
		
		File configFile = new File(System.getProperty("user.dir")+"/files/bixiangdong/others/pci.properties");
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(configFile);
		
		prop.load(fis);
		
		for (int i = 0; i < prop.size(); i++) {
			String pciName = prop.getProperty("pci"+(i+1));
			
			Class<?> clazz = Class.forName(pciName);//用class去加载这个pci子类。
		
			PCI p = (PCI)clazz.newInstance();
		
			mb.usePCI(p);
			
		}
		
		fis.close();
	}

}
