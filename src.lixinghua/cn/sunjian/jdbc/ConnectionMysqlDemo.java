package cn.sunjian.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


/**
 * java数据库编程：
 * 
 * 		连接Mysql数据库；
 * 
 * @author jack
 *
 */
public class ConnectionMysqlDemo {

	//定义MySql的数据库驱动程序
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	//定义Mysql的数据库连接地址
	public static final String DBURL = "jdbc:mysql://localhost:3306/irisApp";

	//定义Mysql的数据库用户名
	public static final String DBUSERNAME = "ikdb";
	
	//定义Mysql的数据库密码
	public static final String DBPASSWORD = "123456";
	
	
	public static void main(String[] args) {
		
		Connection conn = null;//数据库连接
		
		try {
			Class.forName(DBDRIVER);//加载驱动程序
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(conn);//打印数据库
		
		try {
			conn.close();//关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
