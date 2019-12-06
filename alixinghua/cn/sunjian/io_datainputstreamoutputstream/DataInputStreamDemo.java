package cn.sunjian.io_datainputstreamoutputstream;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 数据操作流：练习（数据输入流）
 * 
 * 		数据的读取：DataInputStream
 * 
 * @author sunjian
 *
 */
public class DataInputStreamDemo {

	public static void main(String[] args) throws IOException {
		File f = new File("c:"+File.separator+"DataOutputStream.txt");
		
		DataInputStream dis = null;
		
		dis = new DataInputStream(new FileInputStream(f));
		
		String name = null;//接收名称
		float price = 0.0f;//接收价格
		int num = 0;//接收数量
		
		char temp[] = null;//存放商品名称
		int len = 0;//记录数组长度
		char c = 0;//接收读取到的字符
		
		try{
			while(true){
				temp = new char[200];//开辟数组空间
				len = 0;//定义数组其实位置
				
				while((c = dis.readChar()) != '\t'){//如果读取到字符不是'\t',表示还有内容
					temp[len] = c;//存储到数组中
					len++;
				}
				
				name = new String(temp, 0, len);//将存储到字符数组中的名称字符，转成字符串
				price = dis.readFloat();//读取价格
				dis.readChar();//读取'\t'空格
				num = dis.readInt();//读取数量
				dis.readChar();//读取'\n'换行
				
				System.out.printf("名称：%s、价格：%5.2f、数量：%d\n",name,price,num);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		dis.close();//关闭流
	}

}
