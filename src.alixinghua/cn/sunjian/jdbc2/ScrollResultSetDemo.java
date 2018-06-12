package cn.sunjian.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc2.0操作：
 * 
 * 		可滚动的结果集：一般不使用，不如直接使用PreparedStatement完成方便。
 * 			查询；
 * 			插入；如果想要使用ResultSet插入数据，则在创建数据库操作的时候就必须选择好允许更新。插入数据的方法；
 * 			更新；
 * 			删除；
 * 
 * @author jack
 *
 */
public class ScrollResultSetDemo {

	//定义MySql的数据库驱动程序
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	//定义Mysql的数据库连接地址
	public static final String DBURL = "jdbc:mysql://localhost:3306/sunjian";

	//定义Mysql的数据库用户名
	public static final String DBUSERNAME = "ikdb";
	
	//定义Mysql的数据库密码
	public static final String DBPASSWORD = "123456";
	
	public static void main(String[] args) {
		
		Connection conn = null;//数据库连接对象
		PreparedStatement pstmt = null;//数据库操作对象（预处理）
		ResultSet rs = null;//结果集对象
		
		//SQL语句==查询
		String sql = "select id,name,password,age,sex,birthday from user";
		//SQL语句==查询
		String sql2 = "SELECT id,name,password,age,sex,birthday FROM user WHERE id=?" ;// 此处不需要设置任何的内容
		
		try {
			Class.forName(DBDRIVER);//加载驱动程序
			try {
				conn = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);//创建连接数据库
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

		/*
		 * 查询
		 */
		try {
			pstmt = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);//获取可滚动结果集，表示可以读取
			
			rs = pstmt.executeQuery();//查询操作 
			
			System.out.println("第2条数据：");
			rs.absolute(1);//第二条数据
			print(rs,1);//输出
			
			System.out.println("第1条数据：");
			rs.beforeFirst();//第一条数据
			print(rs, 1);
			
			System.out.println("最后一条数据：");
			rs.afterLast();//最后一条数据之后
			print(rs, -1);
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*
		 * 插入
		 */
		try {
			pstmt = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);//获取可滚动结果集，表示可以更新
			
			rs = pstmt.executeQuery();//执行操作
			
			rs.moveToInsertRow();//移动到插入的一行
			rs.updateString("name", "sunjian");//设置姓名
			rs.updateString("password", "sunjian123");//设置密码
			
			rs.updateDate("birthday", new java.sql.Date(new java.util.Date().getTime()));//设置生日
			
			rs.insertRow();//真正提交数据
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*
		 * 更新
		 */	
		try {
			pstmt = conn.prepareStatement(sql2,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE) ;// 表示结果集可以更新
			pstmt.setInt(1,4) ;
			rs = pstmt.executeQuery() ;	// 查询操作
			rs.last() ;	// 到最后一行
			
			rs.updateString("name","李藏") ;	// 设置姓名
			rs.updateString("password","lizang") ;	// 设置密码
			rs.updateInt("age",23) ;	// 设置要插入的年龄
			rs.updateString("sex","女") ;	// 设置要插入的性别
			rs.updateDate("birthday",new java.sql.Date(new java.util.Date().getTime()));
			rs.cancelRowUpdates() ;	// 取消更新
			rs.updateRow() ;	// 真正提交数据
			rs.close() ;
			pstmt.close() ;
			conn.close() ;			// 数据库关闭
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*
		 * 删除
		 */
		try {
			pstmt = conn.prepareStatement(sql2,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE) ;// 表示结果集可以更新
			pstmt.setInt(1,2) ;
			rs = pstmt.executeQuery() ;	// 查询操作
			rs.last() ;	// 到最后一行
			
			rs.deleteRow() ;	// 真正提交数据
			rs.close() ;
			pstmt.close() ;
			conn.close() ;			// 数据库关闭
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void print(ResultSet rs, int i) throws SQLException {

		if (i>0) {
			rs.next();//由前向后
		}else {
			rs.previous();//由后向前
		}
		
		int id = rs.getInt(1);
		String name = rs.getString(2);
		String password = rs.getString(3);
		int age = rs.getInt(4);
		String sex = rs.getString(5);
		java.util.Date date = rs.getDate(6);
		
		System.out.println("编号："+id+"姓名："+name+"密码："+password+"年龄："+age+"性别："+sex+"出生日期："+date);
		
		
	}
}
