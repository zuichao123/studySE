package cn.sunjian.useradmin.test;

import cn.sunjian.useradmin.factory.DAOFactory;
import cn.sunjian.useradmin.vo.User;

public class TestFindID {

	public static void main(String[] args) throws Exception {

		User user = DAOFactory.getIUserDAOInstance().findById(3);//查找第一个ID的人员
		
		if (user != null) {			
			System.out.println("该ID的人员信息：\n"+user);
		}
	}

}
