package cn.sunjian.jdbc_transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * jdbc事务处理：
 * 
 * 		在数据库中处理事务；
 * 			回滚；
 * 			设置事务点；
 * 
 * 		DROP TABLE user ;	-- 删除表
 * 		CREATE TABLE user(
 * 		id		INT		AUTO_INCREMENT PRIMARY KEY ,
 * 		name		VARCHAR(30)	NOT NULL ,
 * 		password 	VARCHAR(32)	NOT NULL ,
 * 		age		INT		NOT NULL ,
 * 		sex		VARCHAR(2)	DEFAULT '男' ,
 * 		birthday	DATE 
 * 		) ;
 * 
 * 		INSERT INTO user(name,password,age,sex,birthday) VALUES ('李康','www.mldnjava.cn',23,'女','2003-08-27') ;
 * 
 * @author jack
 *
 */
public class TransactionDemo {

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
		Statement stmt = null;//定义数据库操作
		
		try {
			Class.forName(DBDRIVER);//加载数据库驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);//连接数据库
			
			conn.setAutoCommit(false);//取消掉自动提交
			
			stmt = conn.createStatement();//实例化Statement对象
			
			stmt.executeUpdate("INSERT INTO user(name,password,age,sex,birthday)" +
					" VALUES ('LXH-1','hello-1',11,'男','1975-03-05') ") ;
			stmt.executeUpdate("INSERT INTO user(name,password,age,sex,birthday)" +
					" VALUES ('LXH-2','hello-2',12,'女','1976-03-05') ") ;
			
			Savepoint sp = conn.setSavepoint();// 设置保存点
				
			stmt.executeUpdate("INSERT INTO user(name,password,age,sex,birthday)" +
					" VALUES ('LXH-4','hello-4',14,'女','1965-03-05') ") ;
			stmt.executeUpdate("INSERT INTO user(name,password,age,sex,birthday)" +
					" VALUES ('LXH-5','hello-5',15,'女','1965-08-05') ") ;
			
			conn.rollback(sp);//回滚到保存点
			conn.commit();//所有的操作成功了
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt.close();//关闭数据库操作
			conn.close();//数据库关闭
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
