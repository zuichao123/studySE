package com.sunjian.gui;

import cn.sunjian.io.InputData;

/**
 * 实例练习二：菜单显示类
 * 
 * @author sunjian
 *
 */
public class Menu {
	
	public Menu(){//始终显示
		while(true){
			this.show();
		}
	}
	
	//显示方法
	public void show(){
		System.out.println("==-==XXX系统==-==");
		System.out.println("    [1]、增加数据");
		System.out.println("    [2]、删除数据");
		System.out.println("    [3]、修改数据");
		System.out.println("    [4]、查看数据");
		System.out.println("    [0]、系统退出\n");
		
		InputData input = new InputData();
		int i = input.getInt("请选择：", "请输入正确的选项！");//将输入的数据转成整形数字
		
		switch (i) {//如果是整数
		case 1:
			Operate.add();//调用增加操作
			break;
		case 2:
			Operate.delete();//调用删除操作
			break;
		case 3:
			Operate.update();//调用更新操作
			break;
		case 4:
			Operate.find();//调用查看操作
			break;
		case 0:
			System.exit(1);//系统退出
			break;
			
		default://如果是0--4之外的数字
			System.out.println("请输入正确的选项！");
		}
	}
	
	
	
}
