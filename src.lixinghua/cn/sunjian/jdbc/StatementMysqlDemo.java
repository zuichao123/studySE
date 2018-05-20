package cn.sunjian.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

/**
 * java���ݿ��̣�
 * 
 * 		���²���Mysql���ݿ⣻
 * 			��ɾ�Ĳ飻
 * 
 * 		�������ݿ⣺
 * 			create DATABASE sunjian;
 * 		������
 *	 		create table user(
 *				id int AUTO_INCREMENT PRIMARY KEY,
 *				name varchar(30) not null,
 *				password varchar(32) not null,
 *				age int not null,
 *				sex varchar(4) default "man",
 *				birthday DATE
 *			);
 * 
 * @author jack
 *
 */
public class StatementMysqlDemo {

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
		Statement ste = null;//�������ݿ�Ķ���
		ResultSet rs = null;//�����ѯ����Ķ���
			
		//�����������ֵ�����ֶ���=���ݣ�
		String name = "CRonaldo";
		String password = "neimaer123";
		int age = 33;
		String sex = "man";
		String birthday = "1985-02-05";
		
		//����SQL���==����
		String sql = "insert into user(name,password,age,sex,birthday)"+
				"values('"+name+"','"+password+"',"+age+",'"+sex+"','"+birthday+"')";
		//����SQL���==��ѯ
		String sql2 = "select name,password,age,sex,birthday from user";
		//����SQL���==����
		String sql3 = "update user set name = '"+name+"',password='"+password+"',age='"+age+"',sex='"+sex+"',birthday='"+birthday+"'";
		//����SQL���==ɾ��
		String sql4 = "delete from user where name = '"+name+"'";
		
		try {
			Class.forName(DBDRIVER);//������������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);//�������ݿ�
			ste = conn.createStatement();//ʵ����Statement����
			
			ste.executeUpdate(sql);//ִ�в������
			
			rs = ste.executeQuery(sql2);//ִ�в�ѯ����
			while(rs.next()){
				name = rs.getString(1);
				password = rs.getString(2);
				age = rs.getInt(3);
				sex = rs.getString(4);
				birthday = rs.getString(5);
				System.out.print("������"+name+"���䣺"+age+"���룺"+password+"�Ա�"+sex+"�������ڣ�"+birthday);
				System.out.println("\n");
			}
			
			ste.executeUpdate(sql3);//ִ�и��²���
			
			ste.executeUpdate(sql4);//ִ��ɾ������
			
			rs.close();//�رղ�ѯ�����
			
			ste.close();//�ر����ݿ����
			
			conn.close();//�ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n"+conn);//��ӡ���ݿ�
		
	}

}
