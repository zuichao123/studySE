package cn.sunjian.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc2.0������
 * 
 * 		�ɹ����Ľ������һ�㲻ʹ�ã�����ֱ��ʹ��PreparedStatement��ɷ��㡣
 * 			��ѯ��
 * 			���룻�����Ҫʹ��ResultSet�������ݣ����ڴ������ݿ������ʱ��ͱ���ѡ���������¡��������ݵķ�����
 * 			���£�
 * 			ɾ����
 * 
 * @author jack
 *
 */
public class ScrollResultSetDemo {

	//����MySql�����ݿ���������
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	//����Mysql�����ݿ����ӵ�ַ
	public static final String DBURL = "jdbc:mysql://localhost:3306/sunjian";

	//����Mysql�����ݿ��û���
	public static final String DBUSERNAME = "ikdb";
	
	//����Mysql�����ݿ�����
	public static final String DBPASSWORD = "123456";
	
	public static void main(String[] args) {
		
		Connection conn = null;//���ݿ����Ӷ���
		PreparedStatement pstmt = null;//���ݿ��������Ԥ����
		ResultSet rs = null;//���������
		
		//SQL���==��ѯ
		String sql = "select id,name,password,age,sex,birthday from user";
		//SQL���==��ѯ
		String sql2 = "SELECT id,name,password,age,sex,birthday FROM user WHERE id=?" ;// �˴�����Ҫ�����κε�����
		
		try {
			Class.forName(DBDRIVER);//������������
			try {
				conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);//�����������ݿ�
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

		/*
		 * ��ѯ
		 */
		try {
			pstmt = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);//��ȡ�ɹ������������ʾ���Զ�ȡ
			
			rs = pstmt.executeQuery();//��ѯ���� 
			
			System.out.println("��2�����ݣ�");
			rs.absolute(1);//�ڶ�������
			print(rs,1);//���
			
			System.out.println("��1�����ݣ�");
			rs.beforeFirst();//��һ������
			print(rs, 1);
			
			System.out.println("���һ�����ݣ�");
			rs.afterLast();//���һ������֮��
			print(rs, -1);
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*
		 * ����
		 */
		try {
			pstmt = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);//��ȡ�ɹ������������ʾ���Ը���
			
			rs = pstmt.executeQuery();//ִ�в���
			
			rs.moveToInsertRow();//�ƶ��������һ��
			rs.updateString("name", "sunjian");//��������
			rs.updateString("password", "sunjian123");//��������
			
			rs.updateDate("birthday", new java.sql.Date(new java.util.Date().getTime()));//��������
			
			rs.insertRow();//�����ύ����
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*
		 * ����
		 */	
		try {
			pstmt = conn.prepareStatement(sql2,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE) ;// ��ʾ��������Ը���
			pstmt.setInt(1,4) ;
			rs = pstmt.executeQuery() ;	// ��ѯ����
			rs.last() ;	// �����һ��
			
			rs.updateString("name","���") ;	// ��������
			rs.updateString("password","lizang") ;	// ��������
			rs.updateInt("age",23) ;	// ����Ҫ���������
			rs.updateString("sex","Ů") ;	// ����Ҫ������Ա�
			rs.updateDate("birthday",new java.sql.Date(new java.util.Date().getTime()));
			rs.cancelRowUpdates() ;	// ȡ������
			rs.updateRow() ;	// �����ύ����
			rs.close() ;
			pstmt.close() ;
			conn.close() ;			// ���ݿ�ر�
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*
		 * ɾ��
		 */
		try {
			pstmt = conn.prepareStatement(sql2,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE) ;// ��ʾ��������Ը���
			pstmt.setInt(1,2) ;
			rs = pstmt.executeQuery() ;	// ��ѯ����
			rs.last() ;	// �����һ��
			
			rs.deleteRow() ;	// �����ύ����
			rs.close() ;
			pstmt.close() ;
			conn.close() ;			// ���ݿ�ر�
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void print(ResultSet rs, int i) throws SQLException {

		if (i>0) {
			rs.next();//��ǰ���
		}else {
			rs.previous();//�ɺ���ǰ
		}
		
		int id = rs.getInt(1);
		String name = rs.getString(2);
		String password = rs.getString(3);
		int age = rs.getInt(4);
		String sex = rs.getString(5);
		java.util.Date date = rs.getDate(6);
		
		System.out.println("��ţ�"+id+"������"+name+"���룺"+password+"���䣺"+age+"�Ա�"+sex+"�������ڣ�"+date);
		
		
	}
}
