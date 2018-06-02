package cn.sunjian.useradmin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ݿ����ӡ��ر���
 * 
 * @author jack
 *
 */
public class DataBaseConnection {

	//����MySql�����ݿ���������
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	//����Mysql�����ݿ����ӵ�ַ
	public static final String DBURL = "jdbc:mysql://localhost:3306/sunjian";

	//����Mysql�����ݿ��û���
	public static final String DBUSERNAME = "ikdb";
	
	//����Mysql�����ݿ�����
	public static final String DBPASSWORD = "123456";
	
	private Connection conn = null;//�������ݿ����Ӷ���
	
	//���췽��
	public DataBaseConnection(){
		try {
			Class.forName(DBDRIVER);//�������ݿ�����
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);//�������ݿ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�õ����ݿ�����Ӷ���
	public Connection getConnection(){
		return this.conn;
	}
	
	//�ر����ݿ�����
	public void close(){
		if (this.conn != null) {
			try {
				this.conn.close();//���ݿ�ر�
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
