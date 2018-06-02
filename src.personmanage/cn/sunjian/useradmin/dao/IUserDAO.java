package cn.sunjian.useradmin.dao;
/**
 * ���ݿ�����ӿ�
 */
import java.util.List;

import cn.sunjian.useradmin.vo.User;

public interface IUserDAO {

	/**
	 * ��ʾ���ݿ�����Ӳ���
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean doCreate(User user)throws Exception;
	
	/**
	 * ��ʾ���ݿ�ĸ��²���
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean doUpdate(User user)throws Exception;
	
	/**
	 * ��ʾ���ݿ��ɾ��������ɾ��ʱ���ݱ��ɾ����
	 * 
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public boolean doDelete(int id)throws Exception;
	
	/**
	 * ��ʾ���ݿ�Ĳ�ѯ����
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User findById(int id)throws Exception;
	
	/**
	 * ��ѯ��ʱ�򽫷���һ�����
	 * 
	 * @param keyWord
	 * @return
	 * @throws Exception
	 */
	public List<User> findAll(String keyWord)throws Exception;
}
