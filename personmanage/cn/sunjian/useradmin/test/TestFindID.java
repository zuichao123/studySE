package cn.sunjian.useradmin.test;

import cn.sunjian.useradmin.factory.DAOFactory;
import cn.sunjian.useradmin.vo.User;

public class TestFindID {

	public static void main(String[] args) throws Exception {

		User user = DAOFactory.getIUserDAOInstance().findById(3);//���ҵ�һ��ID����Ա
		
		if (user != null) {			
			System.out.println("��ID����Ա��Ϣ��\n"+user);
		}
	}

}
