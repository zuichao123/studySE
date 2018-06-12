package cn.sunjian.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * jdbc2.0������
 * 
 * 		������
 * 			����ָһ���������ݿ���ִ�ж�����䣬һ���ύ��
			������䣺
				void addBatch()throws SQLException
			ִ����䣺
				int[] executeBatch()throws SQLException
 * @author jack
 *
 */
public class ProcessingBatchDemo {
	
	//����MySql�����ݿ���������
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	//����Mysql�����ݿ����ӵ�ַ
	public static final String DBURL = "jdbc:mysql://localhost:3306/sunjian";

	//����Mysql�����ݿ��û���
	public static final String DBUSERNAME = "ikdb";
	
	//����Mysql�����ݿ�����
	public static final String DBPASSWORD = "123456";
	
	public static void main(String[] args) {
		
		Connection conn = null ;		// ���ݿ�����
		PreparedStatement pstmt = null ;
		String sql = "INSERT INTO user(name,password,age,sex,birthday) VALUES (?,?,?,?,?)" ;// �˴�����Ҫ�����κε�����
		try {
			Class.forName(DBDRIVER) ;// ������������
			try {
				conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD) ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
		try {
			pstmt = conn.prepareStatement(sql) ;// ��ʾ��������Ը���
			for(int i=0;i<10;i++){
				pstmt.setString(1,"���˻� - " + i) ;
				pstmt.setString(2,"MLDN - " + i) ;
				pstmt.setInt(3,20 + i) ;
				pstmt.setString(4,"��")  ;
				pstmt.setDate(5,new java.sql.Date(new java.util.Date().getTime())) ;
				pstmt.addBatch() ;	// �����������ȴ�ִ��
			}
			int temp[] = pstmt.executeBatch() ;
			System.out.println("������" + temp.length + "�����ݡ�") ;
			pstmt.close() ;
			conn.close() ;// ���ݿ�ر�
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
	}
}
