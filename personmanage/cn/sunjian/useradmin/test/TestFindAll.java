package cn.sunjian.useradmin.test;

import java.util.Iterator;
import java.util.List;
import cn.sunjian.useradmin.factory.DAOFactory;
import cn.sunjian.useradmin.vo.User;

public class TestFindAll {

	public static void main(String[] args) throws Exception {

		List<User> allList = DAOFactory.getIUserDAOInstance().findAll("");
		
		Iterator<User> iter = allList.iterator();
		System.out.println("模糊查询结果为：");
		while(iter.hasNext()){
			User user = iter.next();
			System.out.println(user);
		}
	}
}
