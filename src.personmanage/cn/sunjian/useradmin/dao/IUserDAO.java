package cn.sunjian.useradmin.dao;
/**
 * 数据库操作接口
 */
import java.util.List;

import cn.sunjian.useradmin.vo.User;

public interface IUserDAO {

	/**
	 * 表示数据库的增加操作
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean doCreate(User user)throws Exception;
	
	/**
	 * 表示数据库的更新操作
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean doUpdate(User user)throws Exception;
	
	/**
	 * 表示数据库的删除操作（删除时根据编号删除）
	 * 
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public boolean doDelete(int id)throws Exception;
	
	/**
	 * 表示数据库的查询操作
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User findById(int id)throws Exception;
	
	/**
	 * 查询的时候将返回一组对象
	 * 
	 * @param keyWord
	 * @return
	 * @throws Exception
	 */
	public List<User> findAll(String keyWord)throws Exception;
}
