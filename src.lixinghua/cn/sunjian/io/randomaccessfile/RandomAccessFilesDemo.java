package cn.sunjian.io.randomaccessfile;

import java.io.File;
import java.io.RandomAccessFile;

/**
 *  java中io：
 * 
 * 		RandomAccessFile类练习：随机读取操作
 * 
 * 		完成写入的操作，每条数据的长度都是12位；
 * 		完成读取的操作，
 * 			随机读取
 * 
 * @author jack
 *
 */
public class RandomAccessFilesDemo {

	public static void main(String[] args) throws Exception{
		
		File file = new File("e:"+File.separator+"text.txt");//指定要操作的文件
		
		if (file.exists()) {//如果文件存在，就删除
			file.delete();
		}
		
		RandomAccessFile rdf = null;//声明RandomAccessFile类的对象
		
		rdf = new RandomAccessFile(file, "rw");//读写模式，如果文件不存在，会自动创建
		
		writeContent(rdf,"zhangsan",30);//写入内容
		writeContent(rdf,"lisi    ", 31);//写入内容
		writeContent(rdf,"wangwu  ", 32);//写入内容
		
		
		rdf = new RandomAccessFile(file, "r");//只读模式下，读取文件内容
		
		readContent(rdf,12,2);//读取第二个人的信息
		rdf.seek(0);//指针回到开头的位置
		readContent(rdf,0,1);//读取第一个人的信息
		readContent(rdf,12,3);//读取第三个人的信息
		
		rdf.close();//关闭输出流
	}

	/*
	 * 读取个人信息
	 */
	private static void readContent(RandomAccessFile rdf,int num,int man) throws Exception{

		byte[] b = new byte[8];//开辟byte数组，用于存储读取到的姓名
		
		rdf.skipBytes(num);//跳过num个字符
		for(int i=0;i<b.length;i++){
			b[i] = rdf.readByte();//读取一个字节
		}
		String name = new String(b);//将读取出来的byte数组变为字符串
		int age = rdf.readInt();//读取数字
		
		System.out.println("第"+man+"个人的信息--> 姓名："+name+"  年龄："+age);//输出个人信息
		
	}

	/*
	 * 写入个人信息
	 */
	private static void writeContent(RandomAccessFile rdf,String name,int age)throws Exception {

		rdf.writeBytes(name);//将姓名写入到文件中
		rdf.writeInt(age);//将年龄写入到文件中
		
	}

}
