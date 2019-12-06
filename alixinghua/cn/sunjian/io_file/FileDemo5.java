package cn.sunjian.io_file;

import java.io.File;

/**
 * java_IO练习：
 * 	
 * 		列出指定文件夹中所有的内容：包括子文件夹中的内容
 * 
 * 	思路：
 * 		要先判断给定的路径是否是目录，之后在使用listFiles()列出一个目录中的全部内容，
 * 		一个文件夹中可能包含其他的文件或子文件夹，子文件夹中也可能会包含其他的子文件，所以此处只能采用递归的调用方式完成。
 * 
 * 		详情如下：	
 * 
 * @author jack
 *
 */
public class FileDemo5 {

	public static void main(String[] args) {

		File file = new File("f:"+File.separator);//实例化File类对象
		
		print(file);
	}

	private static void print(File file) {//递归调用，判断当前路径是否是目录还是文件

		if (file != null) {//如果对象不为空
			if (file.isDirectory()) {//如果对象是目录
				File files[] = file.listFiles();//列出所以的内容路径
				if (files != null) {//如果内容不为空时，再输出					
					for(int i=0;i<files.length;i++){
						print(files[i]);//继续递归调用判断列出的内容
					}
				}
			}else {
				System.out.println(file);//输出当前文件路径
			}
		}
	}

}
