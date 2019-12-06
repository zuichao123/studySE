package cn.sunjian.useradmin.operate;

import java.util.Iterator;
import java.util.List;

import cn.sunjian.useradmin.factory.DAOFactory;
import cn.sunjian.useradmin.util.InputData;
import cn.sunjian.useradmin.vo.User;

/**
 * 用户操作类：
 * 
 * 		菜单显示的操作类；
 * 
 * @author sunjian
 *
 */
public class UserOperate {
	
	/*
	 * 插入人员信息
	 */
	public static void insert(){
		
		User user = new User();
		InputData input = new InputData();
		
		user.setName(input.getString("请输入姓名："));
		user.setAge(input.getInt("请输入年龄：", "年龄输入错误！"));
		user.setSex(input.getString("请输入性别："));
		user.setBirthday(input.getDate("请输入生日：格式（yyyy-MM-dd）", "格式错误，请重新输入！"));
	
		try {
			DAOFactory.getIUserDAOInstance().doCreate(user);//执行插入操作
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 更新人员信息
	 */
	public static void update(){
		
		InputData input = new InputData();
		int id = input.getInt("请输入要更新的人员编号：", "编号必须是数字！");
		
		User user = null;
		try {
			user = DAOFactory.getIUserDAOInstance().findById(id);//先查找该编号的人员
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (user != null) {//修改该编号的人员信息
			
			user.setName(input.getString("请输入姓名（原姓名："+user.getName()+"）"));
			user.setSex(input.getString("请输入性别（原性别："+user.getSex()+"）"));
			user.setBirthday(input.getDate("请输入生日（原生日："+user.getBirthday()+"）", "格式错误，请重新输入！"));

			try {
				DAOFactory.getIUserDAOInstance().doUpdate(user);//执行更新操作
			} catch (Exception e) {	
				e.printStackTrace();
			}
			
		}else {
			System.out.println("您要修改的人员不存在！");
		}
	}
	
	/*
	 * 删除人员信息
	 */
	public static void delete(){
		
		InputData input = new InputData();
		int id = input.getInt("请输入要删除的人员编号：", "编号必须是0-5之间的数字！");
		
		try {
			DAOFactory.getIUserDAOInstance().doDelete(id);//执行删除操作
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 查找单个人员信息
	 */
	public static void findId(){
		
		InputData input = new InputData();
		int id = input.getInt("请输入要查询的编号：", "编号必须是数字！");
		
		User user = null;
		try {
			user = DAOFactory.getIUserDAOInstance().findById(id);//查找该编号的人员
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (user != null) {
			System.out.println(user);//输出该编号的人员信息
		}
	}
	
	/*
	 * 查找所有人员信息
	 */
	public static void findAll(){
		
		InputData input = new InputData();
		String keyword = input.getString("请输入要查询的关键字：");
		
		List<User> allList = null;
		
		try {
			allList = DAOFactory.getIUserDAOInstance().findAll(keyword);//执行查询关键字操作
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		Iterator<User> iter = allList.iterator();
		
		if (iter.hasNext()) {//如果有内容	，再输出		
			System.out.println("查询结果为：");
			while(iter.hasNext()){
				User user = iter.next();
				System.out.println(user);
			}
		}else {
			System.out.println("您所查找的内容不存在！2");
		}
		
	}
}
