package cn.sunjian.jdbc_metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbcԪ���ݲ�����ϰ��
 * 
 * 		DatabaseMetaData��
 * 			ʹ��Ԫ���ݿ��Է������ݿ�Ļ�����Ϣ���������ݿ�����ơ��汾�Լ��õ������Ϣ��
 * 
 * @author jack
 *
 */
public class DatabaseMetaDataDemo {

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
		DatabaseMetaData dmd = null;//���ݿ�Ԫ����
		ResultSet rs = null;//�����
		
		try {
			Class.forName(DBDRIVER);//�������ݿ�����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);//�������ݿ�
			
			dmd = conn.getMetaData();//ʵ����Ԫ���ݶ���
			
			System.out.println("���ݿ����ƣ�"+dmd.getDatabaseProductName());
			System.out.println("���ݿ�汾��"+dmd.getDatabaseMajorVersion()+"."+dmd.getDriverMinorVersion());
			
			rs = dmd.getPrimaryKeys(null, null, "user");//ȡ��user�������
			while(rs.next()){
				System.out.println("�����"+rs.getString(1));
				System.out.println("��ģʽ��"+rs.getString(2));
				System.out.println("�����ƣ�"+rs.getString(3));
				System.out.println("�����ƣ�"+rs.getString(4));
				System.out.println("�������кţ�"+rs.getString(5));
				System.out.println("�������ƣ�"+rs.getString(6));
			}
			
			
			
			conn.close();//���ݿ�ر�
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
