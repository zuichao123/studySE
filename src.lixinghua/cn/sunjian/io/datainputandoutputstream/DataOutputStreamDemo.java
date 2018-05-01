package cn.sunjian.io.datainputandoutputstream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据操作流：练习（数据输出流）
 * 		
 * 		数据的写入：DataOutputStream
 * 
 * @author sunjian
 *
 */
public class DataOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		File f = new File("c:"+File.separator+"DataOutputStream.txt");//定义文件
		
		DataOutputStream dos = null;//定义数据输出流对象
		
		dos = new DataOutputStream(new FileOutputStream(f));//实例化数据输出流
		
		String names[] = {"上衣","裤子","鞋"};//名称
		Float prices[] = {123.8f,234.9f,1234.10f};//价格
		int nums[] = {3,2,1};//数量
		
		for(int i=0;i<names.length;i++){			
			dos.writeChars(names[i]);//写入名称
			dos.writeChar('\t');//写入空格分隔符
			dos.writeFloat(prices[i]);//写入价格
			dos.writeChar('\t');//写入空格分隔符
			dos.writeInt(nums[i]);//写入数量
			dos.writeChar('\n');//写入换行
		}
		dos.close();//关闭输出流
	}
}
