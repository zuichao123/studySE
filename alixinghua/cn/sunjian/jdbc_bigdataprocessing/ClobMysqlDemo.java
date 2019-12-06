package cn.sunjian.jdbc_bigdataprocessing;

import cn.sunjian.utils.Path;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;

/**
 * java���ݿ��̣�֮--���������
 * 
 * 		Clob���͵Ĵ����ݴ���
 * 			д����ı���
 * 			��ȡ���ı���
 * 
 *
 *		�������==3
 *		ʹ�ô˷�����ȡ���������������ı�
 *			if (rs.next()) {//���������
				name = rs.getString(1);//��ȡ��һ���ֶε�����
				System.out.println("������"+name);
				Clob c = rs.getClob(2);//��ȡ�ڶ����ֶε�����
				String note = c.getSubString(1, (int) c.length());//��ȡ���ݣ��ӵ�һ���ַ������еĳ��ȣ�
				System.out.println("���ݣ�"+note);
				c.truncate(100);//ֻ�ܶ�100������
				System.out.println("\n\n\n��ȡ�Ĳ���100�����ݣ�"+c.getSubString(1, (int) c.length()));
			}
 * 			
 * @author jack
 *
 */
public class ClobMysqlDemo {

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
		
		String name = "sunjian";
		
		//SQL���==��������
		String sql = "insert into userclob(name,note)values(?,?)";
		//sql���==��ѯ���������
		String sql2 = "select name,note from userclob where name = ?";
		
		//�ı��ļ�
		File file = new File(Path.deskTop()+"mldn.log");
		
		InputStream intput = null;//�ļ�������
		
		try {
			intput = new FileInputStream(file);//ͨ����������ȡ�ļ�
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
			
		try {
			Class.forName(DBDRIVER);//������������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//�������ݿ�
			conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
			
			pste = conn.prepareStatement(sql);//ʵ����PreparedStatement����
			
			/*
			 * ��������
			 */
			pste.setString(1, name);//���õ�һ��λ��Ϊ��name�ַ�sunjian
			pste.setAsciiStream(2, intput, file.length());//���õڶ���λ��Ϊ����ȡ�����ļ�����
			pste.executeUpdate();//ִ�и���
			
			/*
			 * ��ѯ���������
			 */
			pste = conn.prepareStatement(sql2);
			pste.setString(1, name);//�滻SQL����еĵ�һ�����ʺ�
			rs = pste.executeQuery();//ִ�в�ѯ������������н���
			
			//�������==1
//			if (rs.next()) {//���������
//				name = rs.getString(1);//��ȡ��һ���ֶε�����
//				StringBuffer note = new StringBuffer();
//				System.out.println("������"+name);
//				InputStream input = rs.getAsciiStream(2);//��ȡ��ȡ���ĵڶ����ֶε�����
//				@SuppressWarnings("resource")
//				Scanner scan = new Scanner(input);//ʹ��scanner���ȡ����
//				scan.useDelimiter("\r\n");//���ļ�������Ϊ�ָ���
//				while(scan.hasNext()){//���������
//					note.append(scan.next()).append("\n");
//				}
//				System.out.println("���ݣ�"+note);
//				try {
//					input.close();//�ر�������
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
			//�������==2
//			while (rs.next()) {//���������
//				name = rs.getString(1);//��ȡ��һ���ֶε�����
//				System.out.println("������"+name);
//				String note = rs.getString(2);//��ȡ�ڶ����ֶε�����
//				System.out.println("���ݣ�"+note);
//			}
			/*
			 * �������==3
			 * ʹ�ô˷�����ȡ�����������ı�
			 */
			if (rs.next()) {//���������
				name = rs.getString(1);//��ȡ��һ���ֶε�����
				System.out.println("������"+name);
				Clob c = rs.getClob(2);//��ȡ�ڶ����ֶε�����
				String note = c.getSubString(1, (int) c.length());//��ȡ���ݣ��ӵ�һ���ַ������еĳ��ȣ�
				System.out.println("���ݣ�"+note);
				c.truncate(100);//ֻ�ܶ�100������
				System.out.println("\n\n\n��ȡ�Ĳ���100�����ݣ�"+c.getSubString(1, (int) c.length()));
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
