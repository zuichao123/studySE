package cn.sunjian.io.vote;
/**
 * 3.ͶƱ�ࣺ
 * 
 * 		��ʾ���еĺ�ѡ����Ϣ��ͶƱ����ȡ�
 * 		
 * @author sunjian
 *
 */
public class Operate {

	private Student[] stu = {//����������ʽ�������ѡ����Ϣ
			new Student(1, "����", 0),
			new Student(2, "����", 0),
			new Student(3, "����", 0),
			new Student(4, "����", 0)
	};
	
	private boolean flag = true;//�����־λ
	private String info = "������೤��ѡ�˴��ţ�����0��������";//ѡ��ǰ����ʾ��Ϣ
	private String err = "��ѡƱ��Ч����������ȷ�İ೤��ѡ�˴��ţ�1-4��";//����ѡ��ʱ����ʾ��Ϣ
	
	public Operate(){
		this.printInfo();//�����ѡ����Ϣ
		while(flag){
			this.vote();
		}
		this.printInfo();//���ͶƱ֮��ĺ�ѡ����Ϣ
		
		this.getResult();//�������ͶƱ���
	}

	//��ȡ���ս��
	private void getResult(){
		java.util.Arrays.sort(this.stu);//��ͶƱ��ĺ�ѡ����Ϣ��������
		
		System.out.println(
				"����ͶƱ�����\t\n���ţ�"+this.stu[0].getStuNo()+"�ĺ�ѡ��"+this.stu[0].getName()+"ͬѧ��"+this.stu[0].getVote()+"Ʊ�ٻ�೤ְλ����ϲ��ϲ��");
	}
	
	//ͶƱ
	private void vote() {
		InputData input = new InputData();//��������
		int num = input.getInt(this.info, this.err);//������������
	
		switch(num){
			case 0:{
				this.flag = false;//��ֹѭ��
				break;
			}
			case 1:{
				this.stu[0].setVote(this.stu[0].getVote()+1);//�޸ĵ�ǰ��ѡ�˵�ѡƱ
				break;
			}
			case 2:{
				this.stu[1].setVote(this.stu[1].getVote()+1);
				break;
			}
			case 3:{
				this.stu[2].setVote(this.stu[2].getVote()+1);
				break;
			}
			case 4:{
				this.stu[3].setVote(this.stu[3].getVote()+1);
				break;
			}
			default:{
				System.out.println(this.err);
			}
		}	
	}

	//�����ѡ����Ϣ
	public void printInfo() {
		for(int i=0;i<stu.length;i++){			
			System.out.println(
					this.stu[i].getStuNo()+"��"+
					this.stu[i].getName()+"��"+
					this.stu[i].getVote()+"��");
		}
	}
}
