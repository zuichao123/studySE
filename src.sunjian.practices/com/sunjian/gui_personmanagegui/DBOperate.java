package com.sunjian.gui_personmanagegui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * ���ݿ����
 * 
 * �������ݿ⣺
 * 			create DATABASE sjApp;
 * 		������
 *	 		create table person(
 *				id int AUTO_INCREMENT PRIMARY KEY,
 *				name varchar(30) not null,
 *				age int not null,
 *				sex varchar(4) default "man",
 *				birthday DATE
 *			);
 * 
 * @author sunjian
 *
 */
public class DBOperate {

	//����MySql�����ݿ���������
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	//����Mysql�����ݿ����ӵ�ַ
	public static final String DBURL = "jdbc:mysql://localhost:3306/sjApp";

	//����Mysql�����ݿ��û���
	public static final String DBUSERNAME = "ikdb";
	
	//����Mysql�����ݿ�����
	public static final String DBPASSWORD = "123456";
	
	/******************/
	
	Connection conn = null;//���ݿ����Ӷ���
	PreparedStatement pste = null;//�������ݿ�Ķ���
	ResultSet rs = null;//�����ѯ����Ķ���
	
	private static String sex = "man";
	private static java.sql.Date birthday = riqi("1987-12-05");
	
	/**
	 * �������
	 * @param name ���ս������������
	 * @param age ���ս������������
	 */
	public void add(String name,int age) {
		
		//����SQL���==����
		String sql = "insert into person(name,age,sex,birthday) values(?,?,?,?)";

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
			pste.setInt(2, age);
			pste.setString(3, sex);
			pste.setDate(4, birthday);
			
			pste.executeUpdate();//ִ�и���***********
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ������Ϣ
	 * @param name ���ս��������������ģ����
	 * @return ���ذ����������������������Ա��������Ϣ
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String find(String name){
		
		String result = "";
		List list = new ArrayList();
		
		int age = 0;
		String sex = "";
		java.util.Date date = null;
		
		//����SQL���==��ѯ������������
		String sql2 = "select name,age,sex,birthday from person where name like ?";
		
		try {
			Class.forName(DBDRIVER);//������������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//�������ݿ�
			conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
			
			pste = conn.prepareStatement(sql2);
			
			//��ѯ���ݣ�ģ����ѯ��
			pste.setString(1, "%"+name+"%");//�滻SQL����еĵ�һ���ʺ�
			
			rs = pste.executeQuery();//ִ�в�ѯ*************
			if (rs != null) {				
				while(rs.next()){
					name = rs.getString(1);
					list.add("������"+name);
					age = rs.getInt(2);
					list.add("���䣺"+age);
					sex = rs.getString(3);
					list.add("�Ա�"+sex);
					date = rs.getDate(4);	
					list.add("���գ�"+date+"\n");
				}
				for(int i=0;i<list.size();i++){
					result += list.get(i)+"\n";
				}
			}else {
				result = null;
			}
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ɾ����Ϣ
	 * @param name ���ݽ��ս������������������ɾ����ģ����
	 * @return ɾ���ɹ�����true
	 */
	public boolean delete(String name){
		boolean flag = false;
	
		//SQL���==ɾ��������������
		String sql3 = "delete from person where name like ? ";
		
		try {
			Class.forName(DBDRIVER);//������������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		if (find(name) != null) {
			try {
				//�������ݿ�
				conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
			
				pste = conn.prepareStatement(sql3);
				
				//ɾ�����ݣ���ѯ����������������Ϣ��
				pste.setString(1, "%"+name+"%");//�滻SQL����еĵ�һ���ʺ�
				
				int line = pste.executeUpdate();
				if (line > 0) {								
					flag = true;
				}else {
					flag = false;
				}		
				
			}catch (Exception e){
				e.printStackTrace();
			}
		}else {
			flag = false;
		}

		return flag;
	}
	
	/**
	 * ������Ϣ
	 * @param oldName ���ս��������ԭ����
	 * @param newName ���ս��������������
	 * @param newAge ���ս��������������
	 * @return
	 */
	public boolean update(String oldName,String newName,int newAge){
		boolean flag = false;
		
		//SQL���==ɾ��������������
		String sql4 = "update person set name = ? ,age = ? where name like ?";
		
		try {
			Class.forName(DBDRIVER);//������������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		if (find(oldName) != null) {
			try {
				//�������ݿ�
				conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
	
				pste = conn.prepareStatement(sql4);
				
				//ɾ�����ݣ���ѯ����������������Ϣ��
				pste.setString(1, newName);//�滻SQL����еĵ�һ���ʺ�
				pste.setInt(2, newAge);
				pste.setString(3, "%"+oldName+"%");
				
				int line = pste.executeUpdate();
				if (line > 0) {								
					flag = true;
				}else {
					flag = false;
				}
									
			}catch (Exception e){
				e.printStackTrace();
			}
		}else {
			flag = false;
		}

		return flag;
	}
	
	
	
	/*
	 * ��
	 * java.util.Date��ʽ��ʱ��
	 * ת����
	 * java.sql.Date��ʽ��ʱ��
	 */
	private static java.sql.Date riqi(String shengri){
		java.util.Date temp = null;
		java.sql.Date birthday = null;
		
		try {
			temp = new SimpleDateFormat("yyyy-MM-dd").parse(shengri);
			birthday = new java.sql.Date(temp.getTime());
		} catch (ParseException e1) {	
			e1.printStackTrace();
		}
		
		return birthday;
	}
	
	public static void main(String[] args) {
		DBOperate db0 = new DBOperate();
		String str = db0.find("s");
		
		System.out.println(str);
	}
	
}