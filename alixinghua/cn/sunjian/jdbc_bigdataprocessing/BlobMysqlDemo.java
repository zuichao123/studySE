package cn.sunjian.jdbc_bigdataprocessing;

import cn.sunjian.utils.Path;

import java.io.*;
import java.sql.*;

/**
 * java���ݿ��̣�֮--���������
 * 
 * 		Blob���͵Ķ��������ݲ�����
 * 			д������ƣ�
 * 			��ȡ�����ƣ�
 * 		
 * 		ʹ��blob��ȡ���һЩ��
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
		
		String name = "sunjian1";
		
		//SQL���==��������
		String sql = "insert into userblob(name,photo)values(?,?)";
		//sql���==��ѯ���������
		String sql2 = "select name,photo from userblob where name = ?";
		
		//д��ʱ��ͼƬ�ļ�
		File file = new File(Path.deskTop()+"mldn.bmp");
		//���ʱ��ͼƬ�ļ�
		File file1 = new File(Path.deskTop()+"mldn2.bmp");
		
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
			pste.setString(1, name);//���õ�һ��λ��Ϊ��name�ַ�sunjian
			pste.setBinaryStream(2, intput,file.length());//���õڶ���λ��Ϊ����ȡ�����ļ�����
			pste.executeUpdate();//ִ�и���
			
			/*
			 * ��ѯ���������ȡ������
			 * 		ʹ��io��ȡ����
			 * 		ʹ��BLOB��ȡ����
			 */
			pste = conn.prepareStatement(sql2);
			pste.setString(1, name);//�滻SQL����еĵ�һ���ʺ�
			rs = pste.executeQuery();//ִ�в�ѯ,��������
			
			//����һ��io��ȡ
//			if(rs.next()){//���������
//				
//				name = rs.getString(1);
//				System.out.println("������"+name);
//				intput = rs.getBinaryStream(2);//ʹ�������������ȡ�ڶ����ֶεĶ���������
//				try {
//					output = new FileOutputStream(file1);//�ҵ�����ļ�
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				}
//				int temp = 0;
//				try {
//					while((temp = intput.read())!= -1){//�߶���д
//						output.write(temp);
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			
//				try {
//					intput.close();//�ر�������
//					output.close();//�ر������
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
			
			//��������BLOB��ȡ�����ã�
			if (rs.next()) {
				name = rs.getString(1);//���յ�һ������
				System.out.println("������"+name);
				
				Blob b = rs.getBlob(2);//ʹ��blob���յڶ�������
				
				try {
					output = new FileOutputStream(file1);//�ҵ�Ŀ���ļ���Ҫ��������ļ���
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				try {
					output.write(b.getBytes(1, (int) b.length()));//��blob������յ����ݣ�д�뵽Ŀ���ļ��У��ӵ�һ���ֽڵ����һ���ֽڡ�
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
