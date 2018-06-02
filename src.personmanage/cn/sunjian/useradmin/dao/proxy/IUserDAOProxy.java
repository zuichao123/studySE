package cn.sunjian.useradmin.dao.proxy;
/**
 * 代理实现类；
 * 		负责打开、关闭数据库；
 * 		具体的操作由数据库操作接口的实现类完成；
 */
import java.util.List;

import cn.sunjian.useradmin.dao.IUserDAO;
import cn.sunjian.useradmin.dao.impl.IUserDAOImpl;
import cn.sunjian.useradmin.jdbc.DataBaseConnection;
import cn.sunjian.useradmin.vo.User;
/**
 * 数据库操作接口的实现类的：代理类
 * 
 * @author sunjian
 *
 */
public class IUserDAOProxy implements IUserDAO {
	
	private DataBaseConnection dbc = null;//声明数据库连接类对象
	private IUserDAO dao = null;//声明数据库操作接口对象
	
	public IUserDAOProxy() {
		this.dbc = new DataBaseConnection(); //实例化，指定连接的数据库
		this.dao = new IUserDAOImpl(this.dbc.getConnection());//还是通过数据库操作接口的实现类，用指定连接的数据库对象来实例化数据库操作接口对象
	}

	@Override
	public boolean doCreate(User user) throws Exception {

		boolean flag = true;
		
		try {			
			flag = this.dao.doCreate(user);//调用数据库操作接口中的doCreate()方法
		} catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();//关闭数据库
		}
		return flag;
	}

	@Override
	public boolean doUpdate(User user) throws Exception {

		boolean flag = true;
		
		try {			
			flag = this.dao.doUpdate(user);//调用数据库操作接口中的doUpdate()方法
		} catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();//关闭数据库
		}
		return flag;
	}

	@Override
	public boolean doDelete(int id) throws Exception {

		boolean flag = true;
		
		try {			
			flag = this.dao.doDelete(id);//调用数据库操作接口中的doDelete()方法
		} catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();//关闭数据库
		}
		return flag;
	}

	@Override
	public User findById(int id) throws Exception {

		User user = null;
		
		try {			
			user = this.dao.findById(id);//调用数据库操作接口中的findById()方法
		} catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();//关闭数据库
		}
		return user;
	}

	@Override
	public List<User> findAll(String keyWord) throws Exception {

		List<User> allList = null;
		
		try {			
			allList = this.dao.findAll(keyWord);//调用数据库操作接口中的findAll()方法
		} catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();//关闭数据库
		}
		return allList;
	}

}
