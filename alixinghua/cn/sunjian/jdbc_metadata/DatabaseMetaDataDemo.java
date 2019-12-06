package cn.sunjian.jdbc_metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc元数据操作练习：
 * 
 * 		DatabaseMetaData：
 * 			使用元数据可以分析数据库的基本信息，包括数据库的名称、版本以及得到表的信息；
 * 
 * @author jack
 *
 */
public class DatabaseMetaDataDemo {

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
		DatabaseMetaData dmd = null;//数据库元数据
		ResultSet rs = null;//结果集
		
		try {
			Class.forName(DBDRIVER);//加载数据库驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);//连接数据库
			
			dmd = conn.getMetaData();//实例化元数据对象
			
			System.out.println("数据库名称："+dmd.getDatabaseProductName());
			System.out.println("数据库版本："+dmd.getDatabaseMajorVersion()+"."+dmd.getDriverMinorVersion());
			
			rs = dmd.getPrimaryKeys(null, null, "user");//取得user表的主键
			while(rs.next()){
				System.out.println("表类别："+rs.getString(1));
				System.out.println("表模式："+rs.getString(2));
				System.out.println("表名称："+rs.getString(3));
				System.out.println("列名称："+rs.getString(4));
				System.out.println("主键序列号："+rs.getString(5));
				System.out.println("主键名称："+rs.getString(6));
			}
			
			
			
			conn.close();//数据库关闭
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
