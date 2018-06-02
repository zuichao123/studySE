package cn.sunjian.useradmin.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * IUserDAO数据库操作接口的实现类；
 * 
 */
import java.util.List;

import cn.sunjian.useradmin.dao.IUserDAO;
import cn.sunjian.useradmin.jdbc.DataBaseConnection;
import cn.sunjian.useradmin.vo.User;

public class IUserDAOImpl implements IUserDAO {

	private DataBaseConnection dbc = null;//声明数据库连接、关闭类的对象
	private Connection conn = null;//声明数据库连接对象
	
	public IUserDAOImpl() {
		this.dbc = new DataBaseConnection();//通过构造方法实例化，数据库连接类对象
		this.conn = this.dbc.getConnection();//通过构造方法实例化，数据库连接对象
	}
	
	@Override
	public boolean doCreate(User user) throws Exception {
		
		boolean flag = false;//定义变量
		PreparedStatement pstmt = null;//声明数据库预处理操作对象
		
		String sql = "INSERT INTO user(name,sex,birthday)VALUES(?,?,?)";//定义SQL语句
		
		try {
			
			pstmt = this.conn.prepareStatement(sql);//实例化数据库操作对象
			
			pstmt.setString(1, user.getName());//设置SQL语句中的第一个问号
			pstmt.setString(2, user.getSex());
			pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			
			if (pstmt.executeUpdate() > 0) {//至少已经更新了一行
				flag = true;
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
			this.dbc.close();//关闭数据库
		}
		
		return flag;
	}

	@Override
	public boolean doUpdate(User user) throws Exception {
		boolean flag = false;//定义变量
		PreparedStatement pstmt = null;//声明数据库预处理操作对象
		
		String sql = "UPDATE user SET name = ?, sex = ?, birthday = ? WHERE id = ?";//定义SQL语句
		
		try {
			
			pstmt = this.conn.prepareStatement(sql);//实例化数据库操作对象
			
			pstmt.setString(1, user.getName());//设置SQL语句中的第一个？问号
			pstmt.setString(2, user.getSex());
			pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			pstmt.setInt(4, user.getId());
			
			if (pstmt.executeUpdate() > 0) {//至少已经更新了一行
				flag = true;
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
			this.dbc.close();//关闭数据库
		}
		
		return flag;
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		boolean flag = false;//定义变量
		PreparedStatement pstmt = null;//声明数据库预处理操作对象
		
		String sql = "DELETE FORM user where id = ?";//定义SQL语句
		
		try {
			
			pstmt = this.conn.prepareStatement(sql);//实例化数据库操作对象
			
			pstmt.setInt(1, id);//设置SQL语句中的第一个问号
			
			if (pstmt.executeUpdate() > 0) {//至少已经更新了一行
				flag = true;
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
			this.dbc.close();//关闭数据库
		}
		
		return flag;
	}

	@Override
	public User findById(int id) throws Exception {
		
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
			
			rs = pstmt.executeQuery();//执行查询操作
			
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
			this.dbc.close();//关闭数据库
		}
		
		return allList;
		
	}

}
