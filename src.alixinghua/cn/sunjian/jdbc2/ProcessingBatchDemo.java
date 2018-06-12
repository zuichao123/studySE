package cn.sunjian.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * jdbc2.0操作：
 * 
 * 		批处理：
 * 			就是指一次性向数据库中执行多条语句，一次提交。
			加入语句：
				void addBatch()throws SQLException
			执行语句：
				int[] executeBatch()throws SQLException
 * @author jack
 *
 */
public class ProcessingBatchDemo {
	
	//定义MySql的数据库驱动程序
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	//定义Mysql的数据库连接地址
	public static final String DBURL = "jdbc:mysql://localhost:3306/sunjian";

	//定义Mysql的数据库用户名
	public static final String DBUSERNAME = "ikdb";
	
	//定义Mysql的数据库密码
	public static final String DBPASSWORD = "123456";
	
	public static void main(String[] args) {
		
		Connection conn = null ;		// 数据库连接
		PreparedStatement pstmt = null ;
		String sql = "INSERT INTO user(name,password,age,sex,birthday) VALUES (?,?,?,?,?)" ;// 此处不需要设置任何的内容
		try {
			Class.forName(DBDRIVER) ;// 加载驱动程序
			try {
				conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD) ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
		try {
			pstmt = conn.prepareStatement(sql) ;// 表示结果集可以更新
			for(int i=0;i<10;i++){
				pstmt.setString(1,"李兴华 - " + i) ;
				pstmt.setString(2,"MLDN - " + i) ;
				pstmt.setInt(3,20 + i) ;
				pstmt.setString(4,"男")  ;
				pstmt.setDate(5,new java.sql.Date(new java.util.Date().getTime())) ;
				pstmt.addBatch() ;	// 加入批处理，等待执行
			}
			int temp[] = pstmt.executeBatch() ;
			System.out.println("更新了" + temp.length + "条数据。") ;
			pstmt.close() ;
			conn.close() ;// 数据库关闭
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
	}
}
