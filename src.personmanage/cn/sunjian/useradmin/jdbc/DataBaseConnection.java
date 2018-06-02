package cn.sunjian.useradmin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接、关闭类
 * 
 * @author jack
 *
 */
public class DataBaseConnection {

	//定义MySql的数据库驱动程序
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	//定义Mysql的数据库连接地址
	public static final String DBURL = "jdbc:mysql://localhost:3306/sunjian";

	//定义Mysql的数据库用户名
	public static final String DBUSERNAME = "ikdb";
	
	//定义Mysql的数据库密码
	public static final String DBPASSWORD = "123456";
	
	private Connection conn = null;//声明数据库连接对象
	
	//构造方法
	public DataBaseConnection(){
		try {
			Class.forName(DBDRIVER);//加载数据库驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);//连接数据库
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//得到数据库的连接对象
	public Connection getConnection(){
		return this.conn;
	}
	
	//关闭数据库连接
	public void close(){
		if (this.conn != null) {
			try {
				this.conn.close();//数据库关闭
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
