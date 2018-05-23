package cn.sunjian.jdbc_callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * jdbc��CallableStatement�ӿڣ�
 * 
 * 		�洢���ù��̣�
 * 
 * DELIMITER//
 * -- DROP PROCEDURE myproc // -- ɾ������
 * CREATE PROCEDURE myproc(IN p1 int, INOUT p2 int,OUT p3 int)
 * BEGIN 
 * SELECT p1,p2,p3;   -- ���p1/p2/p3������
 * SET p1 = 10;
 * SET p2 = 20;
 * SET p3 = 30;
 * END
 * //
 * 
 * IN ���ͣ�Ĭ�ϵ����ã�ʲô���������ͱ�ʾIN���ͣ�ֻ�ǽ����ݴ��ݽ�����
 * INOUT���ͣ���ʾ��ֵ���ݵ������У����ҿ��Ա������̶Դ�ֵ���޸ģ����ã�
 * OUT���ͣ����Բ��ô������ݣ������жԴ�ֵ�Ĳ������Է��أ�
 * 
 */


public class CallableStatementDemo {

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
		CallableStatement cstmt = null;//�������ݿ�Ķ���
		
		String sql = "{CALL myproc(?,?,?)}";//���ù���
		
		try {
			Class.forName(DBDRIVER);//������������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);//�������ݿ�
			cstmt = conn.prepareCall(sql);//
			
			cstmt.setInt(1, 70);//���õ�һ��������70
			cstmt.setInt(2, 90);//���õڶ���������90
			
			cstmt.registerOutParameter(2, Types.INTEGER);//���õڶ���ע������ķ���ֵ����
			cstmt.registerOutParameter(3, Types.INTEGER);
			
			cstmt.execute();//ִ�й���
			
			System.out.println("INOUT�ķ���ֵ��"+cstmt.getInt(2));
			System.out.println("OUT�ķ���ֵ��"+cstmt.getInt(3));
			
			cstmt.close();//�ر����ݿ����
			conn.close();//�ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n"+conn);//��ӡ���ݿ�	
	}

}