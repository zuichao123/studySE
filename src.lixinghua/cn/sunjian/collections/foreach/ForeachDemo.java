package cn.sunjian.collections.foreach;

import java.util.ArrayList;
import java.util.List;

/**
 * foreach������ϰ��
 * 
 * 		ѭ�����
 * 
 * @author jack
 *
 */
public class ForeachDemo {

	public static void main(String[] args) {

		List<String> allList = new ArrayList<String>();
		
		allList.add("hello");
		allList.add("_");
		allList.add("world");
		
		for(String str : allList){
			System.out.print(str+"��");//�������
		}
	}

}
