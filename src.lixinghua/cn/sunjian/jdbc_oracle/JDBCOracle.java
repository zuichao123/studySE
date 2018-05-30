package cn.sunjian.jdbc_oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 * jdbc连接Oracle数据库：
 * 
 * 
 * 
 * DROP TABLE person ;
 * DROP SEQUENCE myseq ;
 * CREATE SEQUENCE myseq ;
 * CREATE TABLE person
 * (
 * 		id		INT		PRIMARY KEY NOT NULL ,
 * 		name		VARCHAR(50)	NOT NULL ,
 * 		age		INT ,
 * 		birthday 	DATE
 * 	) ;
 * @author jack
 *
 */
public class JDBCOracle {

	// 定义MySQL的数据库驱动程序
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	// 定义MySQL数据库的连接地址
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:MLDN" ;
	// MySQL数据库的连接用户名
	public static final String DBUSER = "scott" ;
	// MySQL数据库的连接密码
	public static final String DBPASS = "tiger" ;
	public static void main(String args[]) throws Exception{	// 所有异常抛出
		Connection conn = null ;		// 数据库连接
		Class.forName(DBDRIVER) ;	// 加载驱动程序
		conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS) ;
		PreparedStatement pstmt = null ;
		String sql = "INSERT INTO person(id,name,age,birthday) VALUES (myseq.nextVal,?,?,?)" ;
		pstmt = conn.prepareStatement(sql) ;
		pstmt.setString(1,"李兴华") ;
		pstmt.setInt(2,30) ;
		pstmt.setDate(3,new java.sql.Date(new java.util.Date().getTime())) ;
		pstmt.executeUpdate() ;	// 执行更新操作
		pstmt.close() ;
		conn.close() ;			// 数据库关闭
	}

}
