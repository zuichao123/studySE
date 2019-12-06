package com.sunjian.gui;


import cn.sunjian.io.InputData;

/**
 * 练习：单人信息管理程序：
 *
 *		菜单显示的操作类
 * 
 * @author sunjian
 *
 */
public class Operate {
	
	public static void add(){//增加操作
		
		InputData input = new InputData();//实例化输入数据对象
		FileOperate fo = new FileOperate(Path.deskTop()+"test.txt");
		
		String name = input.getString("请输入姓名：");
		int age = input.getInt("请输入年龄：", "年龄必须是数字！");
		
		Person per = new Person(name, age);//实例化Person类
		
		try{
			fo.save(per);//保存对象
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("信息增加成功！");
	}
	
	public static void delete(){//删除操作
		FileOperate fo = new FileOperate(Path.deskTop()+"test.txt");
		
		try{
			fo.save(null);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("信息删除成功！");
	}
	
	public static void update(){//修改操作
		FileOperate fo = new FileOperate(Path.deskTop()+"test.txt");
		Person per = null;
		
		try {
			per = (Person) fo.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		InputData input = new InputData();//实例化输入数据对象

		String name = input.getString("请输入姓名（原姓名："+per.getName()+"）");
		int age = input.getInt("请输入年龄（原年龄："+per.getAge()+"）", "年龄必须是数字！");
		
		per = new Person(name, age);//实例化Person类
		
		try{
			fo.save(per);//保存对象
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("信息修改成功！");
	}
	
	public static void find(){//查找操作
		FileOperate fo = new FileOperate(Path.deskTop()+"test.txt");
		Person per = null;
		
		try {
			per = (Person) fo.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(per);
	}
}
