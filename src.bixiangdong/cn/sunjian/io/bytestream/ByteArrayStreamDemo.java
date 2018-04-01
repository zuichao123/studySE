package cn.sunjian.io.bytestream;

/**
 * 操作字节数组（源和目的都是内存）
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {

	public static void main(String[] args) {
		
		//一般这两个流操作的文件都不大
		//如果源是内存，直接挂它
		ByteArrayInputStream bis = new ByteArrayInputStream("adbcde".getBytes());
		//如果目的是内存，直接挂它
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int ch = 0;
		
		while((ch=bis.read())!=-1){
			bos.write(ch);
		}
		System.out.println(bos.toString());
	}

}
