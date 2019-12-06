package cn.sunjian.useradmin.factory;

import cn.sunjian.useradmin.dao.IUserDAO;
import cn.sunjian.useradmin.dao.impl.IUserDAOImpl;
import cn.sunjian.useradmin.dao.proxy.IUserDAOProxy;

/**
 * ������ƣ�
 * 		�������ã����ݿ�����ӿڵ�ʵ��ģʽ��
 * 
 * @author sunjian
 *
 */
@SuppressWarnings("unused")
public class DAOFactory {

	public static IUserDAO getIUserDAOInstance(){
		//return new IUserDAOImpl();//�����ݿ�����ӿڵ�ʵ�����Լ���ɣ�
		return new IUserDAOProxy();//���ݿ�����ӿڵ�ʵ����Ĵ������
	}

}
