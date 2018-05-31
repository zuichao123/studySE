package cn.sunjian.io_vote;
/**
 * 1.����ѧ���࣬ʵ��Comparable�ӿڣ�����дcompareTo()�Ƚ�������
 * 
 * @author sunjian
 *
 */
public class Student implements Comparable<Student> {

	private int stuNo;//ѧ�����
	private String name;//ѧ������
	private int vote;//ѧ��Ʊ��
	
	public Student(int stuNo, String name, int vote) {
		this.stuNo = stuNo;
		this.name = name;
		this.vote = vote;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}


	@Override
	public int compareTo(Student o) {

		if (this.vote<o.vote) {
			return 1;
		}else if (this.vote>o.vote) {
			return -1;
		}else {			
			return 0;
		}
	}

}
