package cn.sunjian.treemap;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import cn.sunjian.hashmap.Student;


/**
 * 演示TreeMap存储自定义对象
 * 使用Map.Entry()方法将map转成set后，取出值
 * 
 * @author sunjian
 *
 */
public class TreeMapDemo {

	public static void main(String[] args) {
		
		/*
		 * 将学生对象和学生的归属地通过键与值存储到map集合中
		 */
		
//		TreeMap<Student, String> tMap= new TreeMap<Student, String>();
		TreeMap<Student, String> tMap= new TreeMap<Student, String>(new ComByName());
		
		tMap.put(new Student(23, "tyui"), "山西临汾");
		tMap.put(new Student(29, "oiuytrew"), "山西阳泉");
		tMap.put(new Student(37, "hjk"), "山西长治");
		tMap.put(new Student(20, "qwesd"), "山西运城");
		tMap.put(new Student(21, "lkjmnbv"), "北京");
		
		System.out.println(tMap);
		
		Iterator<Map.Entry<Student, String>> it = tMap.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<Student, String> me = it.next();

			Student key = me.getKey();
			String value = me.getValue();
			
			System.out.println(key.getAge()+"::"+key.getName()+"---"+value);
		}
		
	}

}
