package cn.sunjian.jdbc_transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * jdbc������
 * 
 * 		�����ݿ��д�������
 * 			�ع���
 * 			��������㣻
 * 
 * 		DROP TABLE user ;	-- ɾ����
 * 		CREATE TABLE user(
 * 		id		INT		AUTO_INCREMENT PRIMARY KEY ,
 * 		name		VARCHAR(30)	NOT NULL ,
 * 		password 	VARCHAR(32)	NOT NULL ,
 * 		age		INT		NOT NULL ,
 * 		sex		VARCHAR(2)	DEFAULT '��' ,
 * 		birthday	DATE 
 * 		) ;
 * 
 * 		INSERT INTO user(name,password,age,sex,birthday) VALUES ('�','www.mldnjava.cn',23,'Ů','2003-08-27') ;
 * 
 * @author jack
 *
 */
public class TransactionDemo {

	//����MySql�����ݿ���������
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	//����Mysql�����ݿ����ӵ�ַ
	public static final String DBURL = "jdbc:mysql://localhost:3306/sunjian";

	//����Mysql�����ݿ��û���
	public static final String DBUSERNAME = "ikdb";
	
	//����Mysql�����ݿ�����
	public static final String DBPASSWORD = "123456";
	
	public static void main(String[] args) {

		Connection conn = null;//���ݿ�����
		Statement stmt = null;//�������ݿ����
		
		try {
			Class.forName(DBDRIVER);//�������ݿ�����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);//�������ݿ�
			
			conn.setAutoCommit(false);//ȡ�����Զ��ύ
			
			stmt = conn.createStatement();//ʵ����Statement����
			
			stmt.executeUpdate("INSERT INTO user(name,password,age,sex,birthday)" +
					" VALUES ('LXH-1','hello-1',11,'��','1975-03-05') ") ;
			stmt.executeUpdate("INSERT INTO user(name,password,age,sex,birthday)" +
					" VALUES ('LXH-2','hello-2',12,'Ů','1976-03-05') ") ;
			
			Savepoint sp = conn.setSavepoint();// ���ñ����
				
			stmt.executeUpdate("INSERT INTO user(name,password,age,sex,birthday)" +
					" VALUES ('LXH-4','hello-4',14,'Ů','1965-03-05') ") ;
			stmt.executeUpdate("INSERT INTO user(name,password,age,sex,birthday)" +
					" VALUES ('LXH-5','hello-5',15,'Ů','1965-08-05') ") ;
			
			conn.rollback(sp);//�ع��������
			conn.commit();//���еĲ����ɹ���
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt.close();//�ر����ݿ����
			conn.close();//���ݿ�ر�
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
