package cn.sunjian.news;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;
import static java.util.Collections.*;
import static java.lang.System.*;
/**
 * ��ϰ-��̬����
 * 
 * @author sunjian
 *
 */
public class StaticImportDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abc231");
		list.add("abc300");
		list.add("abc783");
		
		out.println(list);
		
		//����
		sort(list);
		System.out.println(list);
		
		//ȡ���ֵ
		String max = max(list);
		System.out.println(max);
	}

}
