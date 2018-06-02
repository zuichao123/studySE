package cn.sunjian.useradmin.test;

import java.util.Date;

import cn.sunjian.useradmin.factory.DAOFactory;
import cn.sunjian.useradmin.vo.User;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		User user = new User();
		
		user.setName("smallPB3");
		user.setAge(29);
		user.setSex("wome");
		user.setBirthday(new Date());
		
		DAOFactory.getIUserDAOInstance().doCreate(user);
	}

}
