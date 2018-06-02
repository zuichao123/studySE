package cn.sunjian.useradmin.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cn.sunjian.useradmin.dao.IUserDAO;
import cn.sunjian.useradmin.vo.User;

/**
 * IUserDAO数据库操作接口的实现类；
 * 		只负责数据库的增删改查操作；
 * 		不负责数据库的打开、关闭操作；
 * 
 */
public class IUserDAOImpl implements IUserDAO {

	private Connection conn = null;//声明数据库连接对象
	
	public IUserDAOImpl(Connection conn) {
		this.conn = conn;//通过构造方法实例化，数据库连接对象（将数据库操作类的对象赋值给数据库连接对象）
	}
	
	@Override
	public boolean doCreate(User user) throws Exception {
		
		boolean flag = false;//定义标记
		PreparedStatement pstmt = null;//声明数据库预处理操作对象
		
		String sql = "INSERT INTO user(name,password,age,sex,birthday)VALUES(?,'',?,?,?)";//定义SQL语句
		
		try {
			pstmt = this.conn.prepareStatement(sql);//实例化数据库操作对象
			
			pstmt.setString(1, user.getName());//设置SQL语句中的第一个问号
			pstmt.setInt(2, user.getAge());
			pstmt.setString(3, user.getSex());
			pstmt.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
			
			int num = pstmt.executeUpdate();//执行更新操作（executeUpdate方法返回更新行）
			
			if (num > 0) {//至少已经更新了一行
				flag = true;
				System.out.println("更新了"+num+"行");
			}else {
				flag = false;
				System.out.println("插入失败！");
			}	
		} catch (Exception e) {
			throw e;
		}finally {//不管如何抛出，最终肯定是要进行数据库的关闭操作的
			if (pstmt != null) {
				try {
					pstmt.close();//关闭数据库操作连接
				} catch (Exception e2) {
					throw e2;
				}
			}
		}
		
		return flag;
	}

	@Override
	public boolean doUpdate(User user) throws Exception {
		
		boolean flag = false;//定义标记
		PreparedStatement pstmt = null;//声明数据库预处理操作对象
		
		String sql = "UPDATE user SET name = ?, sex = ?, birthday = ? WHERE id = ?";//定义SQL语句
		
		try {
			pstmt = this.conn.prepareStatement(sql);//实例化数据库操作对象
			
			pstmt.setString(1, user.getName());//设置SQL语句中的第一个？问号
			pstmt.setString(2, user.getSex());
			pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			pstmt.setInt(4, user.getId());
			
			int num = pstmt.executeUpdate();//执行更新操作（executeUpdate方法返回更新行）
			
			if (num > 0) {//至少已经更新了一行
				flag = true;
				System.out.println("更新了"+num+"行");
			}else {
				flag = false;
				System.out.println("更新失败！");
			}				
		} catch (Exception e) {
			throw e;
		}finally {//不管如何抛出，最终肯定是要进行数据库的关闭操作的
			if (pstmt != null) {
				try {
					pstmt.close();//关闭数据库操作连接
				} catch (Exception e2) {
					throw e2;
				}
			}
		}
		
		return flag;
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		
		boolean flag = false;//定义标记
		PreparedStatement pstmt = null;//声明数据库预处理操作对象
		
		String sql = "DELETE FROM user where id = ?";//定义SQL语句
		
		try {
			pstmt = this.conn.prepareStatement(sql);//实例化数据库操作对象
			
			pstmt.setInt(1, id);//设置SQL语句中的第一个问号
			
			int num = pstmt.executeUpdate();//执行更新操作（executeUpdate方法返回更新行）
			
			if (num > 0) {//至少已经更新了一行
				flag = true;
				System.out.println("更新了"+num+"行");
			}else {
				flag = false;
				System.out.println("删除失败！");
			}				
		} catch (Exception e) {
			throw e;
		}finally {//不管如何抛出，最终肯定是要进行数据库的关闭操作的
			if (pstmt != null) {
				try {
					pstmt.close();//关闭数据库操作连接
				} catch (Exception e2) {
					throw e2;
				}
			}
		}
		
		return flag;
	}

	@Override
	public User findById(int id) throws Exception {
		
		User user = null;//声明user对象
		PreparedStatement pstmt = null;//声明数据库预处理操作对象
		ResultSet rs = null;//声明结果集对象
		
		String sql = "SELECT id, name, password, age, sex, birthday FROM user where id LIKE ?";//定义SQL语句
		
		try {	
			pstmt = this.conn.prepareStatement(sql);//实例化数据库操作对象
			
			//设置SQL语句中的第一个问号
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();//执行查询操作
			
			if(rs.next()){//如果有结果
				user = new User();//实例化user对象
				
				user.setId(rs.getInt(1));//在结果集中取得id
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setSex(rs.getString(5));
				user.setBirthday(rs.getDate(6));
			}else {
				System.out.println("您查找的ID不存在！");
			}
			
			rs.close();//关闭结果集
			
		} catch (Exception e) {
			throw e;
		}finally {//不管如何抛出，最终肯定是要进行数据库的关闭操作的
			if (pstmt != null) {
				try {
					pstmt.close();//关闭数据库操作连接
				} catch (Exception e2) {
					throw e2;
				}
			}
		}
		
		return user;//返回一个对象	
	}

	@Override
	public List<User> findAll(String keyWord) throws Exception {
		
		List<User> allList = new ArrayList<User>();//定义集合
		PreparedStatement pstmt = null;//声明数据库预处理操作对象
		ResultSet rs = null;//声明结果集对象
		
		String sql = "SELECT id, name, password, age, sex, birthday FROM user where name LIKE ? OR sex LIKE ? OR birthday LIKE ?";//定义SQL语句
		
		try {	
			pstmt = this.conn.prepareStatement(sql);//实例化数据库操作对象
			
			//设置SQL语句中的第一个问号
			pstmt.setString(1, "%"+keyWord+"%");
			pstmt.setString(2, "%"+keyWord+"%");
			pstmt.setString(3, "%"+keyWord+"%");
			
			rs = pstmt.executeQuery();//执行查询操作，获取查询结果		
		
			while(rs.next()){
				User user = new User();
				
				user.setId(rs.getInt(1));//在结果集中取得id
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setSex(rs.getString(5));
				user.setBirthday(rs.getDate(6));
				
				allList.add(user);//所有的内容向集合中插入
			}
			
			rs.close();//关闭结果集
			
		} catch (Exception e) {
			throw e;
		}finally {//不管如何抛出，最终肯定是要进行数据库的关闭操作的
			if (pstmt != null) {
				try {
					pstmt.close();//关闭数据库操作连接
				} catch (Exception e2) {
					throw e2;
				}
			}
		}
		
		return allList;//返回一组对象	
	}

}
