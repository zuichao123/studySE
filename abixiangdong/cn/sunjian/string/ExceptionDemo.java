package cn.sunjian.string;

/*
 * ����ʦ�õ����Ͽ�
 * 
 * ���������������������
 * 
 * ����ʦ     ����
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
		System.out.println("��ʼ��ϰ����");
	}
	
	public void prelect()throws NoPlanException{
		
		try{
			computer.run();
			System.out.println(name+"����");
		}catch(LanPingException e){
			System.out.println(e.toString());
			computer.restart();
			prelect();
		}catch (MaoYanException e) {
			System.out.println(e.toString());
			test();
			throw new NoPlanException("��ʱ�޷����У�ԭ��:"+e.getMessage());
		}
	}
}




class Computer{
	private int statu = 1;
	
	public void run()throws LanPingException,MaoYanException{
		if(statu == 1){
			throw new LanPingException("����������");
		}
		if(statu == 2){
			throw new MaoYanException("����ð����");
		}
			
		System.out.println("�������У�");	
	}
	public void restart(){
		statu = 0;
		System.out.println("������������");
	}
}

public class ExceptionDemo {
	
	public static void main(String[] args){
		Teacther teacther = new Teacther("����ʦ");
		
		try {
			teacther.prelect();
		} catch (NoPlanException e) {
			System.out.println(e.toString()+"....");
			System.out.println("����");
		}
		
	}
}
