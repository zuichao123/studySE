package cn.sunjian.jdbc_bigdateprocessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import cn.sunjian.utils.CurrentPath;

/**
 * java数据库编程：之--处理大数据
 * 
 * 		Blob类型的二进制数据操作；
 * 			写入二进制；
 * 			读取二进制；
 * 
 * 			
 * @author jack
 *
 */
public class BlobMysqlDemo {

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
		
		try {
			Class.forName(DBDRIVER);//加载驱动程序
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String name = "sunjian";
		
		//SQL语句==插入数据
		String sql = "insert into userblob(name,photo)values(?,?)";
		//sql语句==查询插入的数据
		String sql2 = "select name,photo from userblob where name = ?";
		
		//写入时的图片文件
		File file = new File(CurrentPath.deskTop()+"mldn.bmp");
		//输出时的图片文件
		File file1 = new File(CurrentPath.deskTop()+"mldn1.bmp");
		
		InputStream intput = null;//文件输入流
		OutputStream output = null;//文件输出流
		
		try {
			intput = new FileInputStream(file);//通过输入流读取文件
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
			
		
		try {
			//连接数据库
			conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
			
			pste = conn.prepareStatement(sql);//实例化PreparedStatement对象
			
			/*
			 * 插入数据
			 */
//			pste.setString(1, name);//设置第一个位置为：name字符sunjian
//			pste.setBinaryStream(2, intput,file.length());//设置第二个位置为：读取到的文件内容
//			pste.executeUpdate();//执行更新
			
			/*
			 * 查询并输出（读取）数据
			 */
			pste = conn.prepareStatement(sql2);
			pste.setString(1, name);//替换SQL语句中的第一个问号
			rs = pste.executeQuery();//执行查询,并保存结果
			
			if(rs.next()){//如果有内容
				
				name = rs.getString(1);
				System.out.println("姓名："+name);
				intput = rs.getBinaryStream(2);//使用输入流对象获取第二个字段的二进制数据
				try {
					output = new FileOutputStream(file1);//找到输出文件
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				int temp = 0;
				try {
					while((temp = intput.read())!= -1){//边读边写
						output.write(temp);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			
				try {
					intput.close();//关闭输入流
					output.close();//关闭输出流
				} catch (IOException e) {
					e.printStackTrace();
				}
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
