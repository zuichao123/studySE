package cn.sunjian.io;
/**
 * java.IO练习：
 * 
 * 		文件的读取和写入
 * 
 * @author jack
 *
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReaderAndWriterFile{

	public static void main(String[] args) throws IOException {

		File srcFile = new File("c:"+File.separator+"src.txt");
		File desFile = new File("c:"+File.separator+"des.txt");

		InputStreamReader input = new InputStreamReader(new FileInputStream(srcFile));

		BufferedReader bufr = new BufferedReader(input);
		
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(desFile));
		//FileWriter out = new FileWriter(desFile);//等同于上边这句

		BufferedWriter bufw = new BufferedWriter(out);

		String temp = null;

		while((temp = bufr.readLine()) != null){
		
			bufw.write(temp+"\r\n");
		}

		input.close();
		bufw.close();

	}

}