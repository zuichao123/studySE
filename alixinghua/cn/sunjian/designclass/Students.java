package cn.sunjian.designclass;

/**
 * ����������������Ʒ���
 * 
 * ���һ���࣬����ѧ����ѧ�š�������Ӣ��ɼ�����ѧ�ɼ���������ɼ�
 * 
 * ����ѧ�����ܷ֡���߷֡�ƽ���֡���ͷ�
 * 
 * @author sunjian
 *
 */

class Student{
	
	//����
	private String stuno;
	private String name;
	private float macth;
	private float english;
	private float computer;
	
	//���췽��
	public Student(){}
	public Student(String stuno, String name, float macth, float english, float computer) {
		this.stuno = stuno;
		this.name = name;
		this.macth = macth;
		this.english = english;
		this.computer = computer;
	}
	
	public String getStuno() {
		return stuno;
	}
	public String getName(){
		return name;
	}
	public float getMacth(){
		return macth;
	}
	public float getEnglish(){
		return english;
	}
	public float getComputer(){
		return computer;
	}
	
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setMacth(float m){
		this.macth = m;
	}
	public void setEnglish(float e){
		this.english = e;
	}
	public void setComputer(float c){
		this.computer = c;
	}
	
	/*
	 * ������е�ѧ���ɼ����ܷ�
	 */
	public float sum(){
		return macth+english+computer;
	}
	/*
	 * �������ѧ���ܳɼ���ƽ����
	 */
	public float avg(){
		return sum() / 3;
	}
	/*
	 * �������ѧ������߷ֿ�Ŀ
	 */
	public float max(){
		float max = macth;
		
		max = max>computer?max:computer;
		max = max>english?max:english;
		
		return max;
	}
	/*
	 * �������ѧ����Ŀ����ͷ�
	 */
	public float min(){
		float min = macth;
		
		min = min<computer?min:computer;
		min = min<english?min:english;
		
		return min;
	}
	
}

public class Students{
		
	public static void main(String[] args) {
		Student student = new Student("xy-6-1-001", "���ǲ�", 100, 98, 95);
		
		System.out.println("ѧ��������"+student.getName());
		System.out.println("ѧ��ѧ�ţ�"+student.getStuno());
		System.out.println("�ܷ֣�"+student.sum());
		System.out.println("��߷֣�"+student.max());
		System.out.println("��ͷ֣�"+student.min());
		System.out.println("ƽ���֣�"+student.avg());
	}
		
}
