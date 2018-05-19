package cn.sunjian.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


/**
 * java���ݿ��̣�
 * 
 * 		����Mysql���ݿ⣻
 * 
 * @author jack
 *
 */
public class ConnectionMysqlDemo {

	//����MySql�����ݿ���������
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	//����Mysql�����ݿ����ӵ�ַ
	public static final String DBURL = "jdbc:mysql://localhost:3306/irisApp";

	//����Mysql�����ݿ��û���
	public static final String DBUSERNAME = "ikdb";
	
	//����Mysql�����ݿ�����
	public static final String DBPASSWORD = "123456";
	
	
	public static void main(String[] args) {
		
		Connection conn = null;//���ݿ�����
		
		try {
			Class.forName(DBDRIVER);//������������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(conn);//��ӡ���ݿ�
		
		try {
			conn.close();//�ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
