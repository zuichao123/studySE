package cn.sunjian.collection_onetoone;

import java.util.ArrayList;
import java.util.List;

/**
 * java�༯��ʵ����ϰ
 * 
 * 		һ�Զ��ϵ
 * 
 * 	ʵ��Ҫ��
 * 		ʹ���༯���Ա�ʾ�����¹�ϵ��һ��ѧУ���԰������ѧ����һ��ѧ������һ��ѧУ��
 * 		�����һ�����͵�һ�Զ��ϵ����ʱ�Ϳ���ͨ���༯���й�ϵ�ı�ʾ��
 * 
 * 	˼·��
 * 		һ��ѧУ�ж��ѧ������ôѧ���ĸ�������δ֪�ģ���ô����һ���϶��޷�ʹ����ͨ�Ķ��������ʾ��
 * 		���ԣ�����ͨ���༯��ʾ��
 * 
 * @author sunjian
 *
 */
public class School {

	private String name;
	private List<Student> allStudents;
	
	public School(){
		this.allStudents = new ArrayList<Student>();
	}
	
	public School(String name){
		this();
		this.setName(name);
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

	public List<Student> getAllStudents(){
		return this.allStudents;
	}
	
	public String toString(){
		return "ѧУ������"+this.name;
	}
}
