package cn.sunjian.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;

/**
 * java���ݿ��̣�
 * 
 * 		PreparedStatement�ӿ�������ݿ�Ĳ�����
 * 			������ʹ��
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
		String password = "ronaldo123";
		int age = 33;
		String sex = "man";
		String birthday = "1985-02-05";
		
		//����ģ����ѯ�ַ�����
		String keyWord = "r";
		
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
		//����SQL���==��ѯ��ģ����ѯ��
		String sql2 = "select name,password,age,sex,birthday from user where name like ? or password like ? or sex like ?";
		//����SQL���==��ѯ����ѯȫ����		
		String sql3 = "select name,password,age,sex,birthday from user";
		try {
			Class.forName(DBDRIVER);//������������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//�������ݿ�
			conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
			
			pste = conn.prepareStatement(sql);//ʵ����PreparedStatement����
			
			//��������
			pste.setString(1, name);//�滻SQL����еĵ�һ���ʺ�
			pste.setString(2, password);
			pste.setInt(3, age);
			pste.setString(4, sex);
			pste.setDate(5, jsd);
			
			int t = pste.executeUpdate();//ִ�и���***********
			
			System.out.println("��"+t+"�����ݸ���!");
			
			pste = conn.prepareStatement(sql2);//ʵ����PreparedStatement����
			
			//��ѯ���ݣ�ģ����ѯ��
			pste.setString(1, "%"+keyWord+"%");//�滻SQL����еĵ�һ���ʺ�
			pste.setString(2, "%"+keyWord+"%");
			pste.setString(3, "%"+keyWord+"%");
			
			rs = pste.executeQuery();//ִ�в�ѯ*************
			while(rs.next()){
				name = rs.getString(1);
				password = rs.getString(2);
				age = rs.getInt(3);
				sex = rs.getString(4);
				java.util.Date date = rs.getDate(5);
				System.out.println("������"+name+",���룺"+password+",���䣺"+age+",�Ա�"+",�Ա�"+",���գ�"+date);
				System.out.println("--------------");
			}
			
			System.out.println("��ѯ����*************");
			//��ѯ���ݣ���ѯ���У�
			
			pste = conn.prepareStatement(sql3);//ʵ����PreparedStatement����
			
			rs = pste.executeQuery();//ִ�в�ѯ*************
			while(rs.next()){
				name = rs.getString(1);
				password = rs.getString(2);
				age = rs.getInt(3);
				sex = rs.getString(4);
				java.util.Date date = rs.getDate(5);
				System.out.println("������"+name+",���룺"+password+",���䣺"+age+",�Ա�"+",�Ա�"+",���գ�"+date);
				System.out.println("--------------");
			}
			rs.close();//�رղ�ѯ�����
			
			pste.close();//�ر����ݿ����
			
			conn.close();//�ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n"+conn);//��ӡ���ݿ�
		
	}

}
