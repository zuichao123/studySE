package cn.sunjian.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;

/**
 * java数据库编程：
 * 
 * 		PreparedStatement接口完成数据库的操作；
 * 
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
		String password = "neimaer123";
		int age = 33;
		String sex = "man";
		String birthday = "1985-02-05";
		
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
		
		try {
			Class.forName(DBDRIVER);//加载驱动程序
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);//连接数据库
			pste = conn.prepareStatement(sql);//实例化PreparedStatement对象
			
			//插入内容
			pste.setString(1, name);
			pste.setString(2, password);
			pste.setInt(3, age);
			pste.setString(4, sex);
			pste.setDate(5, jsd);
			
			int t = pste.executeUpdate();//执行更新
			
			System.out.println("有"+t+"行数据更新!");
			
			pste.close();//关闭数据库操作
			
			conn.close();//关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n"+conn);//打印数据库
		
	}

}
