package cn.sunjian.io_properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 定义功能，获取一个应用程序运行的次数，如果超过5次，给出使用次数已到请注册的提示，并不要运行程序
 * 
 * 思路：
 * 1,应该有计数器
 * 每次程序启动都需要计数一次，并且在原有的次数上进行计数
 * 2.计数器就是一个变量。突然冒出一个想法：程序启动时，进行计数，计数器就必须存在于内存中进行运算。
 * 可是，程序结束呢，计数器消失了。那么再次启动该程序，计数器又重新被初始化了。
 * 而我们需要多次启动同一个应用程序，使用的时同一个计数器。
 * 这就需要计数器的生命周期变长，从内存存储到硬盘文件中。
 * 3.如何使用这个计数器呢？
 * 首先，程序启动时，应该先读取这个用于记录计数器信息的配置文件。
 * 获取上一次计数器次数，并进行使用次数的判断。
 * 其次，对该次进行自增，并将自增后的次数重新存储到配置文件中。
 * 4.文件中的信息该如何进行存储并体现。
 * 直接存储次数值可以，但是不明确该数据的含义，所有起名字就变得很重要。
 * 这就有了名字和值的对应，所有可以使用键值对。
 * 可是映射关系map集合搞定，有需要读取硬盘上的数据，所有map+io=Properties.
 * 
 * 
 * 
 * 简单的配置文件用Properties
 * 复杂的配置文件用xml
 * 
 * @author jack
 *
 */

public class PropertiesTest {

	public static void main(String[] args) throws IOException {

		getAppCount();
	}
	
	public static void getAppCount() throws IOException{
		//将配置文件封装成File对象。
		File confile = new File("count.properties");
		
		if(!confile.exists()){//如果文件不存在，就创建一个
			confile.createNewFile();
		}
		
		FileInputStream fis = new FileInputStream(confile);//将文件封装成一个字节流对象
		
		Properties prop = new Properties();//创建一个集合， 
		
		prop.load(fis);//将数据加载进来
		
		//从集合中通过键获取次数（获取值）
		String value = prop.getProperty("time");
		//定义计数器。记录获取到的次数。
		int count = 0;
		if (value!=null) {//如果值不为空
			count = Integer.parseInt(value);//获取该值，将该值的字符串转换成数字	
			if (count>=5) {//如果该值大于等于5
//				System.out.println("使用次数已到，请注册购买正版！");
//				return;
				throw new RuntimeException("使用次数已到，请注册购买正版！");
			}
		}
		count++;
		
		//将改变后的次数重新存储到集合中
		prop.setProperty("time", count+"");//由于count为整形数字，所有转换成字符串
		
		FileOutputStream fos = new FileOutputStream(confile);//重新创建一个文件将此文件覆盖掉，将新的内容写入到文件中
		
		prop.store(fos, "");//添加到集合中，注释为“”空
		
		fos.close();
		fis.close();
		
	}

}
       