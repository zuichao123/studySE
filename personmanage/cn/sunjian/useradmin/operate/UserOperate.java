package cn.sunjian.useradmin.operate;

import java.util.Iterator;
import java.util.List;

import cn.sunjian.useradmin.factory.DAOFactory;
import cn.sunjian.useradmin.util.InputData;
import cn.sunjian.useradmin.vo.User;

/**
 * �û������ࣺ
 * 
 * 		�˵���ʾ�Ĳ����ࣻ
 * 
 * @author sunjian
 *
 */
public class UserOperate {
	
	/*
	 * ������Ա��Ϣ
	 */
	public static void insert(){
		
		User user = new User();
		InputData input = new InputData();
		
		user.setName(input.getString("������������"));
		user.setAge(input.getInt("���������䣺", "�����������"));
		user.setSex(input.getString("�������Ա�"));
		user.setBirthday(input.getDate("���������գ���ʽ��yyyy-MM-dd��", "��ʽ�������������룡"));
	
		try {
			DAOFactory.getIUserDAOInstance().doCreate(user);//ִ�в������
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * ������Ա��Ϣ
	 */
	public static void update(){
		
		InputData input = new InputData();
		int id = input.getInt("������Ҫ���µ���Ա��ţ�", "��ű��������֣�");
		
		User user = null;
		try {
			user = DAOFactory.getIUserDAOInstance().findById(id);//�Ȳ��Ҹñ�ŵ���Ա
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (user != null) {//�޸ĸñ�ŵ���Ա��Ϣ
			
			user.setName(input.getString("������������ԭ������"+user.getName()+"��"));
			user.setSex(input.getString("�������Ա�ԭ�Ա�"+user.getSex()+"��"));
			user.setBirthday(input.getDate("���������գ�ԭ���գ�"+user.getBirthday()+"��", "��ʽ�������������룡"));

			try {
				DAOFactory.getIUserDAOInstance().doUpdate(user);//ִ�и��²���
			} catch (Exception e) {	
				e.printStackTrace();
			}
			
		}else {
			System.out.println("��Ҫ�޸ĵ���Ա�����ڣ�");
		}
	}
	
	/*
	 * ɾ����Ա��Ϣ
	 */
	public static void delete(){
		
		InputData input = new InputData();
		int id = input.getInt("������Ҫɾ������Ա��ţ�", "��ű�����0-5֮������֣�");
		
		try {
			DAOFactory.getIUserDAOInstance().doDelete(id);//ִ��ɾ������
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ���ҵ�����Ա��Ϣ
	 */
	public static void findId(){
		
		InputData input = new InputData();
		int id = input.getInt("������Ҫ��ѯ�ı�ţ�", "��ű��������֣�");
		
		User user = null;
		try {
			user = DAOFactory.getIUserDAOInstance().findById(id);//���Ҹñ�ŵ���Ա
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (user != null) {
			System.out.println(user);//����ñ�ŵ���Ա��Ϣ
		}
	}
	
	/*
	 * ����������Ա��Ϣ
	 */
	public static void findAll(){
		
		InputData input = new InputData();
		String keyword = input.getString("������Ҫ��ѯ�Ĺؼ��֣�");
		
		List<User> allList = null;
		
		try {
			allList = DAOFactory.getIUserDAOInstance().findAll(keyword);//ִ�в�ѯ�ؼ��ֲ���
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		Iterator<User> iter = allList.iterator();
		
		if (iter.hasNext()) {//���������	�������		
			System.out.println("��ѯ���Ϊ��");
			while(iter.hasNext()){
				User user = iter.next();
				System.out.println(user);
			}
		}else {
			System.out.println("�������ҵ����ݲ����ڣ�2");
		}
		
	}
}
