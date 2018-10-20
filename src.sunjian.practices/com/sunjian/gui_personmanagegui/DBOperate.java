package com.sunjian.gui_personmanagegui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库操作
 * 
 * 创建数据库：
 * 			create DATABASE sjApp;
 * 		创建表：
 *	 		create table person(
 *				id int AUTO_INCREMENT PRIMARY KEY,
 *				name varchar(30) not null,
 *				age int not null,
 *				sex varchar(4) default "man",
 *				birthday DATE
 *			);
 * 
 * @author sunjian
 *
 */
public class DBOperate {

	//定义MySql的数据库驱动程序
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	//定义Mysql的数据库连接地址
	public static final String DBURL = "jdbc:mysql://localhost:3306/sjApp";

	//定义Mysql的数据库用户名
	public static final String DBUSERNAME = "ikdb";
	
	//定义Mysql的数据库密码
	public static final String DBPASSWORD = "123456";
	
	/******************/
	
	Connection conn = null;//数据库连接对象
	PreparedStatement pste = null;//操作数据库的对象
	ResultSet rs = null;//保存查询结果的对象
	
	private static String sex = "man";
	private static java.sql.Date birthday = riqi("1987-12-05");
	
	/**
	 * 添加内容
	 * @param name 接收界面输入的姓名
	 * @param age 接收界面输入的年龄
	 */
	public void add(String name,int age) {
		
		//定义SQL语句==插入
		String sql = "insert into person(name,age,sex,birthday) values(?,?,?,?)";

		try {
			Class.forName(DBDRIVER);//加载驱动程序
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//连接数据库
			conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
			
			pste = conn.prepareStatement(sql);//实例化PreparedStatement对象
			
			//插入内容
			pste.setString(1, name);//替换SQL语句中的第一个问号
			pste.setInt(2, age);
			pste.setString(3, sex);
			pste.setDate(4, birthday);
			
			pste.executeUpdate();//执行更新***********
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 查找信息
	 * @param name 接收界面输入的姓名（模糊）
	 * @return 返回包含所输入的姓名的所有人员的所有信息
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String find(String name){
		
		String result = "";
		List list = new ArrayList();
		
		int age = 0;
		String sex = "";
		java.util.Date date = null;
		
		//定义SQL语句==查询（根据姓名）
		String sql2 = "select name,age,sex,birthday from person where name like ?";
		
		try {
			Class.forName(DBDRIVER);//加载驱动程序
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//连接数据库
			conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
			
			pste = conn.prepareStatement(sql2);
			
			//查询内容（模糊查询）
			pste.setString(1, "%"+name+"%");//替换SQL语句中的第一个问号
			
			rs = pste.executeQuery();//执行查询*************
			if (rs != null) {				
				while(rs.next()){
					name = rs.getString(1);
					list.add("姓名："+name);
					age = rs.getInt(2);
					list.add("年龄："+age);
					sex = rs.getString(3);
					list.add("性别："+sex);
					date = rs.getDate(4);	
					list.add("生日："+date+"\n");
				}
				for(int i=0;i<list.size();i++){
					result += list.get(i)+"\n";
				}
			}else {
				result = null;
			}
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 删除信息
	 * @param name 根据接收界面输入的姓名，进行删除（模糊）
	 * @return 删除成功返回true
	 */
	public boolean delete(String name){
		boolean flag = false;
	
		//SQL语句==删除（根据姓名）
		String sql3 = "delete from person where name like ? ";
		
		try {
			Class.forName(DBDRIVER);//加载驱动程序
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		if (find(name) != null) {
			try {
				//连接数据库
				conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
			
				pste = conn.prepareStatement(sql3);
				
				//删除内容（查询到的姓名的所有信息）
				pste.setString(1, "%"+name+"%");//替换SQL语句中的第一个问号
				
				int line = pste.executeUpdate();
				if (line > 0) {								
					flag = true;
				}else {
					flag = false;
				}		
				
			}catch (Exception e){
				e.printStackTrace();
			}
		}else {
			flag = false;
		}

		return flag;
	}
	
	/**
	 * 更新信息
	 * @param oldName 接收界面输入的原姓名
	 * @param newName 接收界面输入的新姓名
	 * @param newAge 接收界面输入的新年龄
	 * @return
	 */
	public boolean update(String oldName,String newName,int newAge){
		boolean flag = false;
		
		//SQL语句==删除（根据姓名）
		String sql4 = "update person set name = ? ,age = ? where name like ?";
		
		try {
			Class.forName(DBDRIVER);//加载驱动程序
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		if (find(oldName) != null) {
			try {
				//连接数据库
				conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
	
				pste = conn.prepareStatement(sql4);
				
				//删除内容（查询到的姓名的所有信息）
				pste.setString(1, newName);//替换SQL语句中的第一个问号
				pste.setInt(2, newAge);
				pste.setString(3, "%"+oldName+"%");
				
				int line = pste.executeUpdate();
				if (line > 0) {								
					flag = true;
				}else {
					flag = false;
				}
									
			}catch (Exception e){
				e.printStackTrace();
			}
		}else {
			flag = false;
		}

		return flag;
	}
	
	
	
	/*
	 * 将
	 * java.util.Date格式的时间
	 * 转换成
	 * java.sql.Date格式的时间
	 */
	private static java.sql.Date riqi(String shengri){
		java.util.Date temp = null;
		java.sql.Date birthday = null;
		
		try {
			temp = new SimpleDateFormat("yyyy-MM-dd").parse(shengri);
			birthday = new java.sql.Date(temp.getTime());
		} catch (ParseException e1) {	
			e1.printStackTrace();
		}
		
		return birthday;
	}
	
	public static void main(String[] args) {
		DBOperate db0 = new DBOperate();
		String str = db0.find("s");
		
		System.out.println(str);
	}
	
}