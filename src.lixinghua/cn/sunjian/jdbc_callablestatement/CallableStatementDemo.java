package cn.sunjian.jdbc_callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * jdbc：CallableStatement接口：
 * 
 * 		存储调用过程：
 * 
 * DELIMITER//
 * -- DROP PROCEDURE myproc // -- 删除过程
 * CREATE PROCEDURE myproc(IN p1 int, INOUT p2 int,OUT p3 int)
 * BEGIN 
 * SELECT p1,p2,p3;   -- 输出p1/p2/p3的内容
 * SET p1 = 10;
 * SET p2 = 20;
 * SET p3 = 30;
 * END
 * //
 * 
 * IN 类型：默认的设置，什么都不声明就表示IN类型，只是将内容传递进来；
 * INOUT类型：表示把值传递到过程中，并且可以保留过程对此值的修改，引用；
 * OUT类型：可以不用传递内容，过程中对此值的操作可以返回；
 * 
 */


public class CallableStatementDemo {

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
		CallableStatement cstmt = null;//操作数据库的对象
		
		String sql = "{CALL myproc(?,?,?)}";//调用过程
		
		try {
			Class.forName(DBDRIVER);//加载驱动程序
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);//连接数据库
			cstmt = conn.prepareCall(sql);//
			
			cstmt.setInt(1, 70);//设置第一个参数是70
			cstmt.setInt(2, 90);//设置第二个参数是90
			
			cstmt.registerOutParameter(2, Types.INTEGER);//设置第二个注册参数的返回值类型
			cstmt.registerOutParameter(3, Types.INTEGER);
			
			cstmt.execute();//执行过程
			
			System.out.println("INOUT的返回值："+cstmt.getInt(2));
			System.out.println("OUT的返回值："+cstmt.getInt(3));
			
			cstmt.close();//关闭数据库操作
			conn.close();//关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n"+conn);//打印数据库	
	}

}