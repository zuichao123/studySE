package cn.sunjian.array;
/**
 * ������ϰ��
 * 
 * 		��ת������		
 * 
 * @author jack
 *
 */

class Array{
	private int[] temp;//������������
	private int foot;//��������Ǳ����
	
	public Array(int len){//���죬�жϺ�������ʼ������֤���鳤������Ϊ1��
		if (len>0) {
			this.temp = new int[len];
		}else {
			this.temp = new int[1];
		}
	}

	public boolean add(int i){//������ݷ���
		if (this.foot<this.temp.length) {//�������ǰ�Ǳ�λ�ã�С������ĳ��ȣ�û������ʱ���Ǳ�Ϊ0��
			this.temp[foot] = i;//����ǰ������ӵ���ǰ�Ǳ�����λ��
			this.foot++;//�Ǳ��Լ�
			return true;//������
		}else {
			return false;//���򣬷��ؼ�
		}
	}
	
	public int[] getArray(){//�õ�����
		return this.temp;//���ص�ǰ����
	}
}

/*
 * ���鷴ת
 */
class ReverseArray extends Array{
	
	public ReverseArray(int len){
		super(len);//���ø���Ĺ��췽�����Ը����е�������г�ʼ��
	}
	
	public int[] getArray(){
		int[] t = new int[super.getArray().length];//����һ���µ����飬�͸����е������Сһ��
		int count = super.getArray().length-1;//��ȡ������������Ǳ�ֵ
		
		for(int x=0;x<super.getArray().length;x++){
			t[count] = super.getArray()[x];//�������е�����ĵ�һ����ֵ���µ��������һ�����Դ�����ѭ����
			count--;//�Ǳ��Լ�
		}
		return t;//���ط�ת�������
	}
}


/*
 * ��������
 */
class SortArray extends Array{
	
	public SortArray(int len){
		super(len);//���ø����еĹ��췽�����Ը����е�������г�ʼ��
	}
	
	public int[] getArray(){
		java.util.Arrays.sort(super.getArray());//�Ը����е������������
		return super.getArray();//��������������
	}
}



public class ArrayDemo {
	public static void main(String[] args) {
//		SortArray s = new SortArray(10);
		ReverseArray s = new ReverseArray(10);
		
		for(int i=1;i<11;i++){//Ϊ�����������	
			s.add(51+i);
		}
		
//		s.add(89);
//		s.add(891);
//		s.add(819);
//		s.add(189);
//		s.add(809);
//		s.add(9);
		
		print(s.getArray());
		
	}
	
	
	public static void print(int[] aa){//ѭ����������е�����
		for(int x=0;x<aa.length;x++){
			System.out.print(aa[x]+"��");
		}
	}
	
}



















