package cn.itcast.dao;

import cn.itcast.domain.Student;
/**
 * ѧ��
 * @author jack
 *
 */
public interface IStudentDao {

	/**
	 * ���ѧ����Ϣ��XML�ļ���
	 */
	boolean createStudent(Student s);

	/**
	 * ����ѧ������ɾ��ѧ��
	 * ���ѧ�������ڣ�����false
	 */
	boolean deleteStudent(String name);

	/**
	 * ����׼��֤�Ų�ѯѧ����Ϣ
	 * ���ѧ�������ڣ�����null
	 */
	Student findStudent(String examid);

}