package cn.sunjian.io.vote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2.输入数据类
 * 
 * @author sunjian
 *
 */
public class InputData {

	private BufferedReader bufr = null;//接收数据
	
	public InputData(){//构造实例化，BufferedReader:实现接收键盘输入数据	
		this.bufr = new BufferedReader(new InputStreamReader(System.in));
	}
	
	//得到字符串
	public String getString(String info){
		String temp = null;//接收输入内容	
		System.out.println(info);
		
		try{
			temp = this.bufr.readLine();//接收数据
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return temp;
	}
	
	//得到整形数据
	public int getInt(String info,String err){
		int temp = 0;//保存转换后的整型数据
		String str = null;//接收整型数据
		boolean flag = true;//定义一个循环标记
		
		while(flag){//循环判断输入的内容
			str = this.getString(info);	
			if (str.matches("\\d+")) {//正则判断，输入的内容是否是数字
				temp = Integer.parseInt(str);//将字符串数字，转换成整型数字
				flag = false;//修改标记位，退出循环
			}else {
				System.out.println(err);
			}
		}
		
		return temp;
	}
}
