package cn.sunjian.collections;

import java.util.Vector;
import java.util.Collection;
import java.util.List;

/**
 * 集合：List接口
 * 	
 *		Vector接口：
 *			添加内容：
 *				添加一个内容
 *				添加一组内容
 *				在指定位置添加一个、一组内容 		
 * 			删除内容：
 *				List中存在两种删除：根据对象内容、根据对象的编号； 	
 *			输出内容：
 *				正序、反序输出
 *				size()
 *			取出内容：
 *				toArray()
 *			截取字符串：
 *				subList(int i1,int i2)
 *			判断是否为空：
 *				isEmpty()
 *			判断对象是否存在：
 *				contains("xxx")
 *			查找字符串的位置：
 *				indexOf("xxx")			
 *
 *
 * @author jack
 *
 */
public class VectorDemo {

	public static void main(String[] args) {

		List<String> allList = null;
		allList = new Vector<String>();//实例化List，指定操作的泛型为String
		
		System.out.println("添加****************************************************");
		allList.add("hello1");//添加内容，此方法由Collection接口而来
		allList.add("hello2");
		allList.add("hello3");
		allList.add("world!");//默认情况下，向最后加入
		allList.add(0,"world1!");//指定位置添加，（在第一个位置添加）
		
		
		Collection<String> allCollection = null;
		allCollection = new Vector<String>();//指定一个集合
		
		allCollection.add("sunjian");//向Collection中加入内容
		allCollection.add("nihao");
		
		allList.addAll(allCollection);//添加一组内容
		allList.addAll(0,allCollection);//指定位置添加，（在第一个位置处添加一组内容）
		
		System.out.println(allList);//调用toString方法输出
		
		System.out.println("\n\n删除******************************************************");
		
		allList.remove(1);//删除第一个元素，指定删除的位置
		allList.remove("hello");//此方法由Collection接口继承而来（删除第一个hello元素 ）
		System.out.println(allList);//调用toString方法输出
	
		System.out.println("\n\n输出*********************************************************");
		
		/*
		 * 此输出方式是List接口所独有的，而其他接口是没有的，尤其是Collection中是没有根据索引取出内容的操作
		 */
		System.out.print("由前向后输出：");
		for(int i=0;i<allList.size();i++){
			System.out.print(allList.get(i)+"、");
		}
		
		System.out.print("\n由后向前输出：");
		for(int i=allList.size()-1;i>=0;i--){
			System.out.print(allList.get(i)+"、");
		}
		
		System.out.println("\n\n取出************************************************************");
		
		System.out.print("指定数组类型的方式：");
		String str[] = allList.toArray(new String[]{});//指定好类型（返回指定的数组类型String）
		for(int i=0;i<allList.size();i++){
			System.out.print(str[i]+"、");
		}
		
		System.out.print("\n返回对象数组的方式：");
		Object obj[] = allList.toArray();//返回Object类型
		for(int i=0;i<obj.length;i++){
			String temp = (String) obj[i];//向下转型
			System.out.print(temp+"、");
		}
		
		
		/*
		 * 截取字符串、字符串指定位置、包含字符串（对象是否存在）、是否为空
		 */
		System.out.println("\n\n截取字符串、字符串指定位置、包含字符串（对象是否存在）、是否为空***********************");
	
		System.out.println(allList.contains("sunjian")?"\"sunjian\"字符串存在！":"sunjian字符串不存在！");
		System.out.println("sunjian字符串所在的位置："+allList.indexOf("sunjian"));
		System.out.println("集合操作后是否为空？"+allList.isEmpty());
		
		List<String> allSub = allList.subList(2, 4);//字符串截取
		System.out.print("截取后的字符串为：");
		for (int i = 0; i < allSub.size(); i++) {
			System.out.print(allSub.get(i)+"、");
		}
	
	}

}
