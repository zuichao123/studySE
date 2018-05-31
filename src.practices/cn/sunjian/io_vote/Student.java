package cn.sunjian.io_vote;
/**
 * 1.定义学生类，实现Comparable接口，并覆写compareTo()比较器方法
 * 
 * @author sunjian
 *
 */
public class Student implements Comparable<Student> {

	private int stuNo;//学生编号
	private String name;//学生姓名
	private int vote;//学生票数
	
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
