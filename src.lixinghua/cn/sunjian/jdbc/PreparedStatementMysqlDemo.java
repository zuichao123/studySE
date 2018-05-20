package cn.sunjian.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;

/**
 * java���ݿ��̣�
 * 
 * 		PreparedStatement�ӿ�������ݿ�Ĳ�����
 * 
 * @author jack
 *
 */
public class PreparedStatementMysqlDemo {

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
		PreparedStatement pste = null;//�������ݿ�Ķ���
		ResultSet rs = null;//�����ѯ����Ķ���
			
		//�����������ֵ�����ֶ���=���ݣ�
		String name = "CRonaldo";
		String password = "neimaer123";
		int age = 33;
		String sex = "man";
		String birthday = "1985-02-05";
		
		/*
		 * ��
		 * java.util.Date��ʽ��ʱ��
		 * ת����
		 * java.sql.Date��ʽ��ʱ��
		 */
		java.util.Date temp = null;
		java.sql.Date jsd = null;
		try {
			temp = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			jsd = new java.sql.Date(temp.getTime());
		} catch (ParseException e1) {	
			e1.printStackTrace();
		}

		//����SQL���==����
		String sql = "insert into user(name,password,age,sex,birthday) values(?,?,?,?,?)";
		
		try {
			Class.forName(DBDRIVER);//������������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);//�������ݿ�
			pste = conn.prepareStatement(sql);//ʵ����PreparedStatement����
			
			//��������
			pste.setString(1, name);
			pste.setString(2, password);
			pste.setInt(3, age);
			pste.setString(4, sex);
			pste.setDate(5, jsd);
			
			int t = pste.executeUpdate();//ִ�и���
			
			System.out.println("��"+t+"�����ݸ���!");
			
			pste.close();//�ر����ݿ����
			
			conn.close();//�ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n"+conn);//��ӡ���ݿ�
		
	}

}
