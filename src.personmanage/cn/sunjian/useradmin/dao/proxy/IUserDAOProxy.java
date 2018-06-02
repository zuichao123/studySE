package cn.sunjian.useradmin.dao.proxy;
/**
 * ����ʵ���ࣻ
 * 		����򿪡��ر����ݿ⣻
 * 		����Ĳ��������ݿ�����ӿڵ�ʵ������ɣ�
 */
import java.util.List;

import cn.sunjian.useradmin.dao.IUserDAO;
import cn.sunjian.useradmin.dao.impl.IUserDAOImpl;
import cn.sunjian.useradmin.jdbc.DataBaseConnection;
import cn.sunjian.useradmin.vo.User;
/**
 * ���ݿ�����ӿڵ�ʵ����ģ�������
 * 
 * @author sunjian
 *
 */
public class IUserDAOProxy implements IUserDAO {
	
	private DataBaseConnection dbc = null;//�������ݿ����������
	private IUserDAO dao = null;//�������ݿ�����ӿڶ���
	
	public IUserDAOProxy() {
		this.dbc = new DataBaseConnection(); //ʵ������ָ�����ӵ����ݿ�
		this.dao = new IUserDAOImpl(this.dbc.getConnection());//����ͨ�����ݿ�����ӿڵ�ʵ���࣬��ָ�����ӵ����ݿ������ʵ�������ݿ�����ӿڶ���
	}

	@Override
	public boolean doCreate(User user) throws Exception {

		boolean flag = true;
		
		try {			
			flag = this.dao.doCreate(user);//�������ݿ�����ӿ��е�doCreate()����
		} catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();//�ر����ݿ�
		}
		return flag;
	}

	@Override
	public boolean doUpdate(User user) throws Exception {

		boolean flag = true;
		
		try {			
			flag = this.dao.doUpdate(user);//�������ݿ�����ӿ��е�doUpdate()����
		} catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();//�ر����ݿ�
		}
		return flag;
	}

	@Override
	public boolean doDelete(int id) throws Exception {

		boolean flag = true;
		
		try {			
			flag = this.dao.doDelete(id);//�������ݿ�����ӿ��е�doDelete()����
		} catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();//�ر����ݿ�
		}
		return flag;
	}

	@Override
	public User findById(int id) throws Exception {

		User user = null;
		
		try {			
			user = this.dao.findById(id);//�������ݿ�����ӿ��е�findById()����
		} catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();//�ر����ݿ�
		}
		return user;
	}

	@Override
	public List<User> findAll(String keyWord) throws Exception {

		List<User> allList = null;
		
		try {			
			allList = this.dao.findAll(keyWord);//�������ݿ�����ӿ��е�findAll()����
		} catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();//�ر����ݿ�
		}
		return allList;
	}

}
