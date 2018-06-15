package cn.itcast.dao;

import cn.itcast.domain.Student;
/**
 * 学生
 * @author jack
 *
 */
public interface IStudentDao {

	/**
	 * 添加学生信息到XML文件中
	 */
	boolean createStudent(Student s);

	/**
	 * 根据学生姓名删除学生
	 * 如果学生不存在，返回false
	 */
	boolean deleteStudent(String name);

	/**
	 * 根据准考证号查询学生信息
	 * 如果学生不存在，返回null
	 */
	Student findStudent(String examid);

}