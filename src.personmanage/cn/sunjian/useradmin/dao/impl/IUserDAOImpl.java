package cn.sunjian.useradmin.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cn.sunjian.useradmin.dao.IUserDAO;
import cn.sunjian.useradmin.vo.User;

/**
 * IUserDAO���ݿ�����ӿڵ�ʵ���ࣻ
 * 		ֻ�������ݿ����ɾ�Ĳ������
 * 		���������ݿ�Ĵ򿪡��رղ�����
 * 
 */
public class IUserDAOImpl implements IUserDAO {

	private Connection conn = null;//�������ݿ����Ӷ���
	
	public IUserDAOImpl(Connection conn) {
		this.conn = conn;//ͨ�����췽��ʵ���������ݿ����Ӷ��󣨽����ݿ������Ķ���ֵ�����ݿ����Ӷ���
	}
	
	@Override
	public boolean doCreate(User user) throws Exception {
		
		boolean flag = false;//������
		PreparedStatement pstmt = null;//�������ݿ�Ԥ�����������
		
		String sql = "INSERT INTO user(name,password,age,sex,birthday)VALUES(?,'',?,?,?)";//����SQL���
		
		try {
			pstmt = this.conn.prepareStatement(sql);//ʵ�������ݿ��������
			
			pstmt.setString(1, user.getName());//����SQL����еĵ�һ���ʺ�
			pstmt.setInt(2, user.getAge());
			pstmt.setString(3, user.getSex());
			pstmt.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
			
			int num = pstmt.executeUpdate();//ִ�и��²�����executeUpdate�������ظ����У�
			
			if (num > 0) {//�����Ѿ�������һ��
				flag = true;
				System.out.println("������"+num+"��");
			}else {
				flag = false;
				System.out.println("����ʧ�ܣ�");
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
		}
		
		return flag;
	}

	@Override
	public boolean doUpdate(User user) throws Exception {
		
		boolean flag = false;//������
		PreparedStatement pstmt = null;//�������ݿ�Ԥ�����������
		
		String sql = "UPDATE user SET name = ?, sex = ?, birthday = ? WHERE id = ?";//����SQL���
		
		try {
			pstmt = this.conn.prepareStatement(sql);//ʵ�������ݿ��������
			
			pstmt.setString(1, user.getName());//����SQL����еĵ�һ�����ʺ�
			pstmt.setString(2, user.getSex());
			pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			pstmt.setInt(4, user.getId());
			
			int num = pstmt.executeUpdate();//ִ�и��²�����executeUpdate�������ظ����У�
			
			if (num > 0) {//�����Ѿ�������һ��
				flag = true;
				System.out.println("������"+num+"��");
			}else {
				flag = false;
				System.out.println("����ʧ�ܣ�");
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
		}
		
		return flag;
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		
		boolean flag = false;//������
		PreparedStatement pstmt = null;//�������ݿ�Ԥ�����������
		
		String sql = "DELETE FROM user where id = ?";//����SQL���
		
		try {
			pstmt = this.conn.prepareStatement(sql);//ʵ�������ݿ��������
			
			pstmt.setInt(1, id);//����SQL����еĵ�һ���ʺ�
			
			int num = pstmt.executeUpdate();//ִ�и��²�����executeUpdate�������ظ����У�
			
			if (num > 0) {//�����Ѿ�������һ��
				flag = true;
				System.out.println("������"+num+"��");
			}else {
				flag = false;
				System.out.println("ɾ��ʧ�ܣ�");
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
		}
		
		return flag;
	}

	@Override
	public User findById(int id) throws Exception {
		
		User user = null;//����user����
		PreparedStatement pstmt = null;//�������ݿ�Ԥ�����������
		ResultSet rs = null;//�������������
		
		String sql = "SELECT id, name, password, age, sex, birthday FROM user where id LIKE ?";//����SQL���
		
		try {	
			pstmt = this.conn.prepareStatement(sql);//ʵ�������ݿ��������
			
			//����SQL����еĵ�һ���ʺ�
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();//ִ�в�ѯ����
			
			if(rs.next()){//����н��
				user = new User();//ʵ����user����
				
				user.setId(rs.getInt(1));//�ڽ������ȡ��id
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setSex(rs.getString(5));
				user.setBirthday(rs.getDate(6));
			}else {
				System.out.println("�����ҵ�ID�����ڣ�");
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
		}
		
		return user;//����һ������	
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
			
			rs = pstmt.executeQuery();//ִ�в�ѯ��������ȡ��ѯ���		
		
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
		}
		
		return allList;//����һ�����	
	}

}
