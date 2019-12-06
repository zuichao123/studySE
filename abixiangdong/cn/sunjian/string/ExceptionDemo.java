package cn.sunjian.string;

/*
 * 毕老师用电脑上课
 * 
 * 问题领域中设计两个对象
 * 
 * 毕老师     电脑
 * */

class LanPingException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LanPingException(String msg){
		super(msg);
	}
}

class MaoYanException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MaoYanException(String msg){
		super(msg);
	}
}

class NoPlanException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	NoPlanException(String msg){
		super(msg);
	}
}

class Teacther{
	
	private String name;
	private Computer computer;
	
	Teacther(String name){
		this.name = name;
		computer = new Computer();
	}
	
	public void test(){
		System.out.println("开始练习。。");
	}
	
	public void prelect()throws NoPlanException{
		
		try{
			computer.run();
			System.out.println(name+"讲课");
		}catch(LanPingException e){
			System.out.println(e.toString());
			computer.restart();
			prelect();
		}catch (MaoYanException e) {
			System.out.println(e.toString());
			test();
			throw new NoPlanException("课时无法进行，原因:"+e.getMessage());
		}
	}
}




class Computer{
	private int statu = 1;
	
	public void run()throws LanPingException,MaoYanException{
		if(statu == 1){
			throw new LanPingException("电脑蓝屏啦");
		}
		if(statu == 2){
			throw new MaoYanException("电脑冒烟啦");
		}
			
		System.out.println("电脑运行！");	
	}
	public void restart(){
		statu = 0;
		System.out.println("电脑重启！！");
	}
}

public class ExceptionDemo {
	
	public static void main(String[] args){
		Teacther teacther = new Teacther("毕老师");
		
		try {
			teacther.prelect();
		} catch (NoPlanException e) {
			System.out.println(e.toString()+"....");
			System.out.println("换人");
		}
		
	}
}
