package cn.sunjian.useradmin.test;

import java.util.Date;

import cn.sunjian.useradmin.factory.DAOFactory;
import cn.sunjian.useradmin.vo.User;

public class TestUpdate {

	public static void main(String[] args) throws Exception {

		User user = new User();
		
		user.setName("bigPB1");
		user.setSex("women");
		user.setBirthday(new Date());
		
		user.setId(1);//更新第一个ID的人员
		
		DAOFactory.getIUserDAOInstance().doUpdate(user);
	}

}
