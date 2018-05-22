package cn.sunjian.jdbc_bigdateprocessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import cn.sunjian.utils.CurrentPath;

/**
 * java���ݿ��̣�֮--���������
 * 
 * 		Blob���͵Ķ��������ݲ�����
 * 			д������ƣ�
 * 			��ȡ�����ƣ�
 * 
 * 			
 * @author jack
 *
 */
public class BlobMysqlDemo {

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
		
		try {
			Class.forName(DBDRIVER);//������������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String name = "sunjian";
		
		//SQL���==��������
		String sql = "insert into userblob(name,photo)values(?,?)";
		//sql���==��ѯ���������
		String sql2 = "select name,photo from userblob where name = ?";
		
		//д��ʱ��ͼƬ�ļ�
		File file = new File(CurrentPath.deskTop()+"mldn.bmp");
		//���ʱ��ͼƬ�ļ�
		File file1 = new File(CurrentPath.deskTop()+"mldn1.bmp");
		
		InputStream intput = null;//�ļ�������
		OutputStream output = null;//�ļ������
		
		try {
			intput = new FileInputStream(file);//ͨ����������ȡ�ļ�
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
			
		
		try {
			//�������ݿ�
			conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
			
			pste = conn.prepareStatement(sql);//ʵ����PreparedStatement����
			
			/*
			 * ��������
			 */
//			pste.setString(1, name);//���õ�һ��λ��Ϊ��name�ַ�sunjian
//			pste.setBinaryStream(2, intput,file.length());//���õڶ���λ��Ϊ����ȡ�����ļ�����
//			pste.executeUpdate();//ִ�и���
			
			/*
			 * ��ѯ���������ȡ������
			 */
			pste = conn.prepareStatement(sql2);
			pste.setString(1, name);//�滻SQL����еĵ�һ���ʺ�
			rs = pste.executeQuery();//ִ�в�ѯ,��������
			
			if(rs.next()){//���������
				
				name = rs.getString(1);
				System.out.println("������"+name);
				intput = rs.getBinaryStream(2);//ʹ�������������ȡ�ڶ����ֶεĶ���������
				try {
					output = new FileOutputStream(file1);//�ҵ�����ļ�
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				int temp = 0;
				try {
					while((temp = intput.read())!= -1){//�߶���д
						output.write(temp);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			
				try {
					intput.close();//�ر�������
					output.close();//�ر������
				} catch (IOException e) {
					e.printStackTrace();
				}
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
