package cn.sunjian.jdbc_metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * jdbcԪ���ݲ�����ϰ��
 * 
 * 		ResultSetMetaData��
 * 			ʹ��ResultSetMetaData���Ի�ȡ����ResultSet�������е����ͺ�������Ϣ�Ķ���
 * 			ResultSetMetaData�洢��ResultSet��MetaData������ͨ�����µķ���ȡ��ResultSet����Ϣ��
 * 
 * @author jack
 *
 */
public class ResultSetMetaDataDemo {

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
		ResultSetMetaData rsmd = null;//���ݿ�Ԫ����
		PreparedStatement pstmt = null;//���ݿ��������
		
		try {
			Class.forName(DBDRIVER);//�������ݿ�����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//SQL���
		String sql = "select id,name,password,age,sex,birthday from user";
		
		try {
			conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);//�������ݿ�
			
			pstmt = conn.prepareStatement(sql);//ʵ�������ݿ��������
			
			rsmd = pstmt.getMetaData();//�õ�Ԫ����
			System.out.println("һ������"+rsmd.getColumnCount()+"������");
			if (rsmd.isAutoIncrement(1)) {//�����һ�����ǲ����Զ�������
				System.out.println(rsmd.getColumnName(1)+"�����Զ������ġ�");
			}
			
			conn.close();//���ݿ�ر�
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
