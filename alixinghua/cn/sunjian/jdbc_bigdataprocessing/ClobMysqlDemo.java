package cn.sunjian.jdbc_bigdataprocessing;

import cn.sunjian.utils.Path;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;

/**
 * java数据库编程：之--处理大数据
 * 
 * 		Clob类型的大数据处理
 * 			写入大文本；
 * 			读取大文本；
 * 
 *
 *		输出内容==3
 *		使用此方法读取大数据量的数据文本
 *			if (rs.next()) {//如果有内容
				name = rs.getString(1);//获取第一个字段的内容
				System.out.println("姓名："+name);
				Clob c = rs.getClob(2);//获取第二个字段的内容
				String note = c.getSubString(1, (int) c.length());//截取内容（从第一个字符到所有的长度）
				System.out.println("内容："+note);
				c.truncate(100);//只能读100个内容
				System.out.println("\n\n\n读取的部分100个内容："+c.getSubString(1, (int) c.length()));
			}
 * 			
 * @author jack
 *
 */
public class ClobMysqlDemo {

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
		PreparedStatement pste = null;//操作数据库的对象
		ResultSet rs = null;//保存查询结果的对象
		
		String name = "sunjian";
		
		//SQL语句==插入数据
		String sql = "insert into userclob(name,note)values(?,?)";
		//sql语句==查询插入的数据
		String sql2 = "select name,note from userclob where name = ?";
		
		//文本文件
		File file = new File(Path.deskTop()+"mldn.log");
		
		InputStream intput = null;//文件输入流
		
		try {
			intput = new FileInputStream(file);//通过输入流读取文件
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
			
		try {
			Class.forName(DBDRIVER);//加载驱动程序
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//连接数据库
			conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
			
			pste = conn.prepareStatement(sql);//实例化PreparedStatement对象
			
			/*
			 * 插入数据
			 */
			pste.setString(1, name);//设置第一个位置为：name字符sunjian
			pste.setAsciiStream(2, intput, file.length());//设置第二个位置为：读取到的文件内容
			pste.executeUpdate();//执行更新
			
			/*
			 * 查询并输出数据
			 */
			pste = conn.prepareStatement(sql2);
			pste.setString(1, name);//替换SQL语句中的第一个？问号
			rs = pste.executeQuery();//执行查询，并将结果进行接收
			
			//输出内容==1
//			if (rs.next()) {//如果有内容
//				name = rs.getString(1);//获取第一个字段的内容
//				StringBuffer note = new StringBuffer();
//				System.out.println("姓名："+name);
//				InputStream input = rs.getAsciiStream(2);//读取获取到的第二个字段的内容
//				@SuppressWarnings("resource")
//				Scanner scan = new Scanner(input);//使用scanner类读取内容
//				scan.useDelimiter("\r\n");//将文件换行作为分隔符
//				while(scan.hasNext()){//如何有内容
//					note.append(scan.next()).append("\n");
//				}
//				System.out.println("内容："+note);
//				try {
//					input.close();//关闭输入流
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
			//输出内容==2
//			while (rs.next()) {//如果有内容
//				name = rs.getString(1);//获取第一个字段的内容
//				System.out.println("姓名："+name);
//				String note = rs.getString(2);//获取第二个字段的内容
//				System.out.println("内容："+note);
//			}
			/*
			 * 输出内容==3
			 * 使用此方法读取大量的数据文本
			 */
			if (rs.next()) {//如果有内容
				name = rs.getString(1);//获取第一个字段的内容
				System.out.println("姓名："+name);
				Clob c = rs.getClob(2);//获取第二个字段的内容
				String note = c.getSubString(1, (int) c.length());//截取内容（从第一个字符到所有的长度）
				System.out.println("内容："+note);
				c.truncate(100);//只能读100个内容
				System.out.println("\n\n\n读取的部分100个内容："+c.getSubString(1, (int) c.length()));
			}
			
			
			rs.close();//关闭查询结果集
			
			pste.close();//关闭数据库操作
			
			conn.close();//关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n"+conn);//打印数据库
		
	}

}
