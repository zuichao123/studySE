package cn.sunjian.useradmin.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * IUserDAO���ݿ�����ӿڵ�ʵ���ࣻ
 * 
 */
import java.util.List;

import cn.sunjian.useradmin.dao.IUserDAO;
import cn.sunjian.useradmin.jdbc.DataBaseConnection;
import cn.sunjian.useradmin.vo.User;

public class IUserDAOImpl implements IUserDAO {

	private DataBaseConnection dbc = null;//�������ݿ����ӡ��ر���Ķ���
	private Connection conn = null;//�������ݿ����Ӷ���
	
	public IUserDAOImpl() {
		this.dbc = new DataBaseConnection();//ͨ�����췽��ʵ���������ݿ����������
		this.conn = this.dbc.getConnection();//ͨ�����췽��ʵ���������ݿ����Ӷ���
	}
	
	@Override
	public boolean doCreate(User user) throws Exception {
		
		boolean flag = false;//�������
		PreparedStatement pstmt = null;//�������ݿ�Ԥ�����������
		
		String sql = "INSERT INTO user(name,sex,birthday)VALUES(?,?,?)";//����SQL���
		
		try {
			
			pstmt = this.conn.prepareStatement(sql);//ʵ�������ݿ��������
			
			pstmt.setString(1, user.getName());//����SQL����еĵ�һ���ʺ�
			pstmt.setString(2, user.getSex());
			pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			
			if (pstmt.executeUpdate() > 0) {//�����Ѿ�������һ��
				flag = true;
			}
			
		} catch (Exception e) {
			throw e;
		}finally {//��������׳������տ϶���Ҫ�������ݿ�Ĺرղ�����
			if (pstmt != null) {
				try {
					pstmt.close();//�ر����ݿ��������
				} catch (Exception e2) {
					throw e2;
				}
			}
			this.dbc.close();//�ر����ݿ�
		}
		
		return flag;
	}

	@Override
	public boolean doUpdate(User user) throws Exception {
		boolean flag = false;//�������
		PreparedStatement pstmt = null;//�������ݿ�Ԥ�����������
		
		String sql = "UPDATE user SET name = ?, sex = ?, birthday = ? WHERE id = ?";//����SQL���
		
		try {
			
			pstmt = this.conn.prepareStatement(sql);//ʵ�������ݿ��������
			
			pstmt.setString(1, user.getName());//����SQL����еĵ�һ�����ʺ�
			pstmt.setString(2, user.getSex());
			pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			pstmt.setInt(4, user.getId());
			
			if (pstmt.executeUpdate() > 0) {//�����Ѿ�������һ��
				flag = true;
			}
			
		} catch (Exception e) {
			throw e;
		}finally {//��������׳������տ϶���Ҫ�������ݿ�Ĺرղ�����
			if (pstmt != null) {
				try {
					pstmt.close();//�ر����ݿ��������
				} catch (Exception e2) {
					throw e2;
				}
			}
			this.dbc.close();//�ر����ݿ�
		}
		
		return flag;
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		boolean flag = false;//�������
		PreparedStatement pstmt = null;//�������ݿ�Ԥ�����������
		
		String sql = "DELETE FORM user where id = ?";//����SQL���
		
		try {
			
			pstmt = this.conn.prepareStatement(sql);//ʵ�������ݿ��������
			
			pstmt.setInt(1, id);//����SQL����еĵ�һ���ʺ�
			
			if (pstmt.executeUpdate() > 0) {//�����Ѿ�������һ��
				flag = true;
			}
			
		} catch (Exception e) {
			throw e;
		}finally {//��������׳������տ϶���Ҫ�������ݿ�Ĺرղ�����
			if (pstmt != null) {
				try {
					pstmt.close();//�ر����ݿ��������
				} catch (Exception e2) {
					throw e2;
				}
			}
			this.dbc.close();//�ر����ݿ�
		}
		
		return flag;
	}

	@Override
	public User findById(int id) throws Exception {
		
	}

	@Override
	public List<User> findAll(String keyWord) throws Exception {
		List<User> allList = new ArrayList<User>();//���弯��
		PreparedStatement pstmt = null;//�������ݿ�Ԥ�����������
		ResultSet rs = null;//�������������
		
		String sql = "SELECT id, name, password, age, sex, birthday FROM user where name LIKE ? OR sex LIKE ? OR birthday LIKE ?";//����SQL���
		
		try {
			
			pstmt = this.conn.prepareStatement(sql);//ʵ�������ݿ��������
			
			//����SQL����еĵ�һ���ʺ�
			pstmt.setString(1, "%"+keyWord+"%");
			pstmt.setString(2, "%"+keyWord+"%");
			pstmt.setString(3, "%"+keyWord+"%");
			
			rs = pstmt.executeQuery();//ִ�в�ѯ����
			
			while(rs.next()){
				User user = new User();
				
				user.setId(rs.getInt(1));//�ڽ������ȡ��id
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setSex(rs.getString(5));
				user.setBirthday(rs.getDate(6));
				
				allList.add(user);//���е������򼯺��в���
			}
			
			rs.close();//�رս����
			
		} catch (Exception e) {
			throw e;
		}finally {//��������׳������տ϶���Ҫ�������ݿ�Ĺرղ�����
			if (pstmt != null) {
				try {
					pstmt.close();//�ر����ݿ��������
				} catch (Exception e2) {
					throw e2;
				}
			}
			this.dbc.close();//�ر����ݿ�
		}
		
		return allList;
		
	}

}
