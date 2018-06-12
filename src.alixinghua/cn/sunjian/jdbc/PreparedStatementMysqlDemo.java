package cn.sunjian.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;

/**
 * java数据库编程：
 * 
 * 		PreparedStatement接口完成数据库的操作；
 * 			开发中使用
 * @author jack
 *
 */
public class PreparedStatementMysqlDemo {

	//定义MySql的数据库驱动程序
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	//定义Mysql的数据库连接地址
	public static final String DBURL = "jdbc:mysql://localhost:3306/sunjian";

	//定义Mysql的数据库用户名
	public static final String DBUSERNAME = "ikdb";
	
	//定义Mysql的数据库密码
	public static final String DBPASSWORD = "123456";
	
	
	public static void main(String[] args) {
		
		Connection conn = null;//数据库连接对象
		PreparedStatement pste = null;//操作数据库的对象
		ResultSet rs = null;//保存查询结果的对象
			
		//定义变量并赋值（表字段名=内容）
		String name = "CRonaldo";
		String password = "ronaldo123";
		int age = 33;
		String sex = "man";
		String birthday = "1985-02-05";
		
		//定义模糊查询字符内容
		String keyWord = "r";
		
		/*
		 * 将
		 * java.util.Date格式的时间
		 * 转换成
		 * java.sql.Date格式的时间
		 */
		java.util.Date temp = null;
		java.sql.Date jsd = null;
		try {
			temp = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			jsd = new java.sql.Date(temp.getTime());
		} catch (ParseException e1) {	
			e1.printStackTrace();
		}

		//定义SQL语句==插入
		String sql = "insert into user(name,password,age,sex,birthday) values(?,?,?,?,?)";
		//定义SQL语句==查询（模糊查询）
		String sql2 = "select name,password,age,sex,birthday from user where name like ? or password like ? or sex like ?";
		//定义SQL语句==查询（查询全部）		
		String sql3 = "select name,password,age,sex,birthday from user";
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
			pste.setString(2, password);
			pste.setInt(3, age);
			pste.setString(4, sex);
			pste.setDate(5, jsd);
			
			int t = pste.executeUpdate();//执行更新***********
			
			System.out.println("有"+t+"行数据更新!");
			
			pste = conn.prepareStatement(sql2);//实例化PreparedStatement对象
			
			//查询内容（模糊查询）
			pste.setString(1, "%"+keyWord+"%");//替换SQL语句中的第一个问号
			pste.setString(2, "%"+keyWord+"%");
			pste.setString(3, "%"+keyWord+"%");
			
			rs = pste.executeQuery();//执行查询*************
			while(rs.next()){
				name = rs.getString(1);
				password = rs.getString(2);
				age = rs.getInt(3);
				sex = rs.getString(4);
				java.util.Date date = rs.getDate(5);
				System.out.println("姓名："+name+",密码："+password+",年龄："+age+",性别："+",性别："+",生日："+date);
				System.out.println("--------------");
			}
			
			System.out.println("查询所有*************");
			//查询内容（查询所有）
			
			pste = conn.prepareStatement(sql3);//实例化PreparedStatement对象
			
			rs = pste.executeQuery();//执行查询*************
			while(rs.next()){
				name = rs.getString(1);
				password = rs.getString(2);
				age = rs.getInt(3);
				sex = rs.getString(4);
				java.util.Date date = rs.getDate(5);
				System.out.println("姓名："+name+",密码："+password+",年龄："+age+",性别："+",性别："+",生日："+date);
				System.out.println("--------------");
			}
			rs.close();//关闭查询结果集
			
			pste.close();//关闭数据库操作
			
			conn.close();//关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n"+conn);//打印数据库
		
	}

}
