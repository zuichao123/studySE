package cn.sunjian.collection_manytomany;

import java.util.ArrayList;
import java.util.List;

/**
 * java�༯��ʵ����ϰ
 * 
 * 		��Զ��ϵ
 * 
 * 	ʵ��Ҫ��
 * 		һ��ѧ������ѡ���ſγ̣�һ�ſγ̿����ж��ѧ���μӣ���ô����Ǹ����͵Ķ�Զ��ϵ��
 * 
 * 	˼·��
 * 		Ҫ��ɱ���������Ӧ�ö��������ࣺѧ����Ϣ��Student���γ���Ϣ��Course����һ��ѧ�����д���һ�����ϣ�
 * 		����ȫ���Ŀγ̣����ڿγ�����ҲҪ����һ�����ϣ�����ȫ����ѧ����
 * 
 * @author sunjian
 *
 */
public class Course {

	private String name;
	private int credit;
	private List<Student> allStudents;
	
	public Course(){//ͨ�����췽��ʵ��������
		this.allStudents = new ArrayList<Student>();
	}
	
	public Course(String name,int credit){
		this();
		this.credit = credit;
		this.name = name;
	}
	
	//�õ����е�ѧ��
	public List<Student> getAllStudents(){
		return this.allStudents;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setCredit(int credit){
		this.credit = credit;
	}
	public int getCredit(){
		return this.credit;
	}
	
	public String toString(){
		return "�γ����ƣ�"+this.name+",��ţ�"+this.credit;
	}
}
