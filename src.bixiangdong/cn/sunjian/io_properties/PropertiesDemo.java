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
		 *  Properties集合：
		 *  特点：
		 *  1,该集合中的键和值都是字符串类型
		 *  2,集合中的数据可以保存到流中，或者从流中获取
		 *  
		 *  通常该集合用于操作以键值对形式存在的配置文件
		 */
		
//		propertiesDemo();
//		methodDemo();
//		methodDemo_2();
//		methodDemo_3();
		
		myLoad();
	}
	
	//对已有的配置文件中的信息进行修改
	/**
	 * 读取这个文件
	 * 并将这个文件中的键值数据存储到集合中
	 * 在通过集合对数据进行修改
	 * 在通过流将修改后的数据存储到文件中
	 * @throws IOException 
	 */
	public static void test() throws IOException{
		
		//读取这个文件
		File file = new File("info.txt");
		if(!file.exists()){
			//创建文件
			file.createNewFile();
		}
		FileReader fr = new FileReader("info.txt");//和info.txt文件相关联进行读取
		
		//创建集合存储配置信息
		Properties pro = new Properties();
		
		//将流中的数据存储到集合中
		pro.load(fr);
		
		pro.setProperty("wangwu", "16");
		
		/*
		 * 先在集合中改完，再做输出动作（将集合中的数据存储到新创建的文件中）
		 */
		
		FileWriter fw = new FileWriter(file);//新创建一个file文件
		
		pro.store(fw, "");//将集合中的数据存储到文件中
		
		fw.close();
		fr.close();
		
	}
	
	
	//模拟一下load方法
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
		 * 读取文件中的数据
		 */
		
		Properties pro = new Properties();
		
		//集合中的数据来自于一个文件
		//注意：必须要保证该文件中的数据是键值对
		//需要使用到读取流
		
		FileInputStream fis = new FileInputStream("info.txt");
		
		//使用load方法 读取文件中的数据
		pro.load(fis);
		
		pro.list(System.out);
		
		
	}


	public static void methodDemo_2() throws IOException {

		/**
		 * 将集合中的数据存储到文件中
		 */
		Properties pro = new Properties();
		
		//存储元素
		pro.setProperty("zhangsan", "30");
		pro.setProperty("lisi", "31");
		pro.setProperty("wangwu", "36");
		pro.setProperty("zhaoliu", "20");
		
		//想要将这些集合中的字符串键值信息持久化存储到文件中
		//需要关联输出流
		FileOutputStream fos = new FileOutputStream("info.txt");
		
		//将集合中数据存储到文件中，使用store方法
		pro.store(fos, "name+age");//name+age是注释信息
		
		fos.close();
		
		
	}


	//store()方法用于存储
	
	
	
	
	
	
	/**
	 * 演示Properties集合和流对象相结合的功能
	 * 
	 * 调试时，用的多，输出集合中的数据
	 */
	
	public static void methodDemo(){
		Properties pro = new Properties();
		
		//存储元素
		pro.setProperty("zhangsan", "30");
		pro.setProperty("lisi", "31");
		pro.setProperty("wangwu", "36");
		pro.setProperty("zhaoliu", "20");
		
		pro = System.getProperties();
		
		pro.list(System.out);
		
	}
	
	
	
	
	/**
	 * Properties集合的存和取
	 * 
	 */
	public  static void propertiesDemo(){
		
		//Properties创建一个 集合
		
		Properties pro = new Properties();
		
		//存储元素
		pro.setProperty("zhangsan", "30");
		pro.setProperty("lisi", "31");
		pro.setProperty("wangwu", "36");
		pro.setProperty("zhaoliu", "20");
		
		
		//修改元素
		pro.setProperty("wangwu", "26");//修改王五的值
		
		
		
		//取出所有元素
		Set<String > names = pro.stringPropertyNames();//取出键，存储在set集合中
		
		for(String name:names){
			
			String str = pro.getProperty(name);//遍历names集合，根据name键获取对应的值
			System.out.println(name+":"+str);//打印
		}
	}

}
