package cn.sunjian.set;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set集合练习：
 * 
 * 通过HashSet完成，在100万数据中查重操作
 * 
 * @author jack
 *
 */
public class HashSetTest {

	public static void main(String[] args) {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss.SSS");//定义时间显示格式

		Date date = new Date();
		System.out.println("开始时间："+df.format(date));
		
		int[] arr = new int[1000000];//定义一个长度为100万的数组
		
		for(int i=0;i<arr.length;i++){
		arr[i] = i+1;//为数组赋值
		}
		
		arr[65535] = 1000;//修改数组中的一个值，与其他的一个值一样
		
		Set<Integer> set = new HashSet<Integer>();//声明HashSet集合（元素不可重复）
		
		int i = 0;//定义变量，用于保存重复元素的坐标
		
		for(i=0;i<arr.length;i++){
			if (!set.add(arr[i])){//将初始化后的数组元素，添加到set集合中，由于set集合中的元素不可重复，所有当添加到之前修改过的元素时，会返回false
				break;//如果返回false，程序退出
			}
		}
		
		Iterator<Integer> iterator = set.iterator();//声明集合输出接口iterator对象，并调用iterator()方法实例化
		 
		while(iterator.hasNext()){
			int temp = iterator.next();//保存set集合中的元素
			if (temp == arr[i]) {//判断：如果当前元素与arr数组中的重复元素相同
				break;
			}
		}
		 
		System.out.println("重复元素的坐标："+i);
		System.out.println("重复元素的值："+arr[i]);
		
		Date date2 = new Date();
		System.out.println("结束时间："+df.format(date2));

	}

}
