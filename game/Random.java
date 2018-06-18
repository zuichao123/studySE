import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Random{
	BufferedReader buf = null;//接收键盘输入数据信息对象
	public static void main(String[] args){
		
		if (args.length != 2) {
			System.out.println("error!");
			return;
		}
		

		this.buf = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = null;
		String str2 = null;//接收读取的信息

		for(int i=0;i<args.length;i++){
			try {
				args[i] = this.buf.readLine();//读取键盘录入的信息，一次读取一行
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			str[i] = args[i];
		}
		System.out.print("******************");
		System.out.print("\n**"+str1+"  VS "+str2+"**   $$ "+(int)((Math.random()*10)/2));
		System.out.println(":"+(int)((Math.random()*10)/2)+" $$"+"\n******************");
	}
	
	//获取字符串信息
//	public static String getString(String info){
//		return temp;
//	}
}