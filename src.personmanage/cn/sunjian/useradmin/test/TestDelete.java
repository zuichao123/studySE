package cn.sunjian.useradmin.test;

import cn.sunjian.useradmin.factory.DAOFactory;

public class TestDelete {

	public static void main(String[] args) throws Exception {

		boolean flag = DAOFactory.getIUserDAOInstance().doDelete(2);
		
		if (flag) {
			System.out.println("delete person accessfull£¡");
		}else {
			System.out.println("delete failed£¡");
		}
		
	}
}
