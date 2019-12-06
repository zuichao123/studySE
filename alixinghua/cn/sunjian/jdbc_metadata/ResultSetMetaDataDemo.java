package cn.sunjian.jdbc_metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * jdbc元数据操作练习：
 * 
 * 		ResultSetMetaData：
 * 			使用ResultSetMetaData可以获取关于ResultSet对象中列的类型和属性信息的对象，
 * 			ResultSetMetaData存储了ResultSet的MetaData，可以通过以下的方法取得ResultSet的信息。
 * 
 * @author jack
 *
 */
public class ResultSetMetaDataDemo {

	//定义MySql的数据库驱动程序
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	//定义Mysql的数据库连接地址
	public static final String DBURL = "jdbc:mysql://localhost:3306/sunjian";

	//定义Mysql的数据库用户名
	public static final String DBUSERNAME = "ikdb";
	
	//定义Mysql的数据库密码
	public static final String DBPASSWORD = "123456";
		
	public static void main(String[] args) {

		Connection conn = null;//数据库连接
		ResultSetMetaData rsmd = null;//数据库元数据
		PreparedStatement pstmt = null;//数据库操作对象
		
		try {
			Class.forName(DBDRIVER);//加载数据库驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//SQL语句
		String sql = "select id,name,password,age,sex,birthday from user";
		
		try {
			conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);//连接数据库
			
			pstmt = conn.prepareStatement(sql);//实例化数据库操作对象
			
			rsmd = pstmt.getMetaData();//得到元数据
			System.out.println("一共返回"+rsmd.getColumnCount()+"条数据");
			if (rsmd.isAutoIncrement(1)) {//如果第一个列是不是自动增长的
				System.out.println(rsmd.getColumnName(1)+"列是自动增长的。");
			}
			
			conn.close();//数据库关闭
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
