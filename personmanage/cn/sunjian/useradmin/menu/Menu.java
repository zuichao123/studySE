package cn.sunjian.useradmin.menu;

import cn.sunjian.io.InputData;
import cn.sunjian.useradmin.operate.UserOperate;

/**
 * 菜单显示类
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
		System.out.println("==-====-==XXX人员管理系统==-====-==");
		System.out.println("    [1]、增加人员");
		System.out.println("    [2]、修改人员");
		System.out.println("    [3]、删除人员");
		System.out.println("    [4]、查看单个人员");
		System.out.println("    [5]、查看全部人员");
		System.out.println("    [0]、系统退出\n");
		
		InputData input = new InputData();
		int i = input.getInt("请选择：", "请输入数字！");//将输入的内容转成整形数字
		
		switch (i) {//如果是整数
		case 1:
			UserOperate.insert();
			break;
		case 2:
			UserOperate.update();
			break;
		case 3:
			UserOperate.delete();
			break;
		case 4:
			UserOperate.findId();
			break;
		case 5:
			UserOperate.findAll();
			break;
		case 0:
			System.out.println("系统退出！");
			System.exit(1);//系统退出
			break;
			
		default://如果是0--5之外的数字
			System.out.println("请输入正确的选项！");
		}
	}
	
	
	
}
