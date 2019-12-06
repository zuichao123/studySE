package cn.sunjian.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 演示hashMap存储自定义对象
 * 使用keySet()方法将map转成set后，取出值
 * 
 * @author sunjian
 *
 */
@SuppressWarnings("unused")
public class HashMapDemo {

	public static void main(String[] args) {
		
		/*
		 * 将学生对象和学生的归属地通过键与值存储到map集合中
		 */
		
		HashMap<Student, String> hMap= new HashMap<Student, String>();
		
		hMap.put(new Student(23, "tyui"), "山西临汾");
		hMap.put(new Student(29, "oiuytrew"), "山西阳泉");
		hMap.put(new Student(37, "hjk"), "山西长治");
		hMap.put(new Student(20, "qwesd"), "山西运城");
		hMap.put(new Student(21, "lkjmnbv"), "北京");
		
		System.out.println(hMap);
		
//		Set<Student> set = hMap.keySet();
//		Iterator<Student> it = set.iterator();
		//上边这两句等同于下边这一句
		Iterator<Student> it = hMap.keySet().iterator();
		
		while(it.hasNext()){
			Student key = it.next();
			String value = hMap.get(key);
			
			System.out.println(key.getAge()+"::"+key.getName()+"---"+value);
		}
		
	}

}
