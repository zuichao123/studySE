package cn.sunjian.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

/**
 * java数据库编程：
 * 
 * 		更新操作Mysql数据库；
 * 			增删改查；
 * 
 * 		创建数据库：
 * 			create DATABASE sunjian;
 * 		创建表：
 *	 		create table user(
 *				id int AUTO_INCREMENT PRIMARY KEY,
 *				name varchar(30) not null,
 *				password varchar(32) not null,
 *				age int not null,
 *				sex varchar(4) default "man",
 *				birthday DATE
 *			);
 * 
 * @author jack
 *
 */
public class StatementMysqlDemo {

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
		Statement ste = null;//操作数据库的对象
		ResultSet rs = null;//保存查询结果的对象
			
		//定义变量并赋值（表字段名=内容）
		String name = "CRonaldo";
		String password = "neimaer123";
		int age = 33;
		String sex = "man";
		String birthday = "1985-02-05";
		
		//定义SQL语句==插入
		String sql = "insert into user(name,password,age,sex,birthday)"+
				"values('"+name+"','"+password+"',"+age+",'"+sex+"','"+birthday+"')";
		//定义SQL语句==查询
		String sql2 = "select name,password,age,sex,birthday from user";
		//定义SQL语句==更新
		String sql3 = "update user set name = '"+name+"',password='"+password+"',age='"+age+"',sex='"+sex+"',birthday='"+birthday+"'";
		//定义SQL语句==删除
		String sql4 = "delete from user where name = '"+name+"'";
		
		try {
			Class.forName(DBDRIVER);//加载驱动程序
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);//连接数据库
			ste = conn.createStatement();//实例化Statement对象
			
			ste.executeUpdate(sql);//执行插入操作
			
			rs = ste.executeQuery(sql2);//执行查询操作
			while(rs.next()){
				name = rs.getString(1);
				password = rs.getString(2);
				age = rs.getInt(3);
				sex = rs.getString(4);
				birthday = rs.getString(5);
				System.out.print("姓名："+name+"年龄："+age+"密码："+password+"性别："+sex+"出生日期："+birthday);
				System.out.println("\n");
			}
			
			ste.executeUpdate(sql3);//执行更新操作
			
			ste.executeUpdate(sql4);//执行删除操作
			
			rs.close();//关闭查询结果集
			
			ste.close();//关闭数据库操作
			
			conn.close();//关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n"+conn);//打印数据库
		
	}

}
