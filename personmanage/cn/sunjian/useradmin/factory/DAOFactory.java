package cn.sunjian.useradmin.factory;

import cn.sunjian.useradmin.dao.IUserDAO;
import cn.sunjian.useradmin.dao.impl.IUserDAOImpl;
import cn.sunjian.useradmin.dao.proxy.IUserDAOProxy;

/**
 * 工厂设计；
 * 		就是设置：数据库操作接口的实现模式；
 * 
 * @author sunjian
 *
 */
@SuppressWarnings("unused")
public class DAOFactory {

	public static IUserDAO getIUserDAOInstance(){
		//return new IUserDAOImpl();//（数据库操作接口的实现类自己完成）
		return new IUserDAOProxy();//数据库操作接口的实现类的代理完成
	}

}
