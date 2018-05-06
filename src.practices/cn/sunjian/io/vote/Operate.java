package cn.sunjian.io.vote;
/**
 * 3.投票类：
 * 
 * 		显示所有的候选人信息，投票规则等。
 * 		
 * @author sunjian
 *
 */
public class Operate {

	private Student[] stu = {//对象数组形式，定义候选人信息
			new Student(1, "张三", 0),
			new Student(2, "李四", 0),
			new Student(3, "王五", 0),
			new Student(4, "赵六", 0)
	};
	
	private boolean flag = true;//定义标志位
	private String info = "请输入班长候选人代号（数字0结束）：";//选择前的提示信息
	private String err = "此选票无效，请输入正确的班长候选人代号（1-4）";//错误选择时的提示信息
	
	public Operate(){
		this.printInfo();//输出候选人信息
		while(flag){
			this.vote();
		}
		this.printInfo();//输出投票之后的候选人信息
		
		this.getResult();//输出最终投票结果
	}

	//获取最终结果
	private void getResult(){
		java.util.Arrays.sort(this.stu);//对投票后的候选人信息进行排序
		
		System.out.println(
				"最终投票结果：\t\n代号："+this.stu[0].getStuNo()+"的候选人"+this.stu[0].getName()+"同学，"+this.stu[0].getVote()+"票荣获班长职位，恭喜恭喜！");
	}
	
	//投票
	private void vote() {
		InputData input = new InputData();//输入数据
		int num = input.getInt(this.info, this.err);//获得输入的数据
	
		switch(num){
			case 0:{
				this.flag = false;//终止循环
				break;
			}
			case 1:{
				this.stu[0].setVote(this.stu[0].getVote()+1);//修改当前候选人的选票
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

	//输出候选人信息
	public void printInfo() {
		for(int i=0;i<stu.length;i++){			
			System.out.println(
					this.stu[i].getStuNo()+"："+
					this.stu[i].getName()+"【"+
					this.stu[i].getVote()+"】");
		}
	}
}
