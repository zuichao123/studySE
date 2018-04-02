package cn.sunjian.arrsys;
/**
 * ��ϵ���鷴ת������
 * 
 * @author sunjian
 *
 */

/*
 * ����������
 * ���Ԫ�ط���
 * ��ȡԪ�ط���
 */
class Array{
	private int temp[];//����һ����������temp
	private int foot;  //��������ĽǱ�λ��
	
	//���췽��
	public Array(int len){//���췽��������temp�������Ը�ֵ������ά��һ���ռ䣩
		if (len>0) {
			this.temp = new int[len];
		}else {
			this.temp = new int[1];
		}
	}
	
	//���Ԫ�ط���
	public boolean add(int i){
		if(this.foot<this.temp.length){//�����ǰ�Ǳ��λ��С������ĳ��ȣ�˵����������ӣ�����λ�ã�
			this.temp[foot] = i;//�Ͱѵ�ǰ��ӵ��������ַ��ڵ�ǰ�Ǳ괦
			this.foot++;//������ǰ�ĽǱ��1������ƶ�һ���Ǳ꣬��Ϊ��������ˣ�
			return true;//������ӳɹ��ı�־true
		}else {
			return false;//���򷵻����ʧ�ܵı�־false
		}
	}
	
	//��ȡԪ�ط���
	public int[] getArray(){
		return this.temp;
	}
}

/*
 * ��ת������
 */
class ReverseArray extends Array{
	
	//���췽��
	public ReverseArray(int len){
		super(len);//���ø���Ĺ��췽��
	}
	
	//��д����Ļ�ȡԪ�صķ���==Ϊ��ת�������
	public int[] getArray(){
		int t[] = new int[super.getArray().length];//����һ���µ����飬�����븸������鳤��һ��
		int count = super.getArray().length-1;//�����������д�����һ����ֵ�ĽǱ�
		
		for (int i = 0; i < t.length; i++) {
			t[count] = super.getArray()[i];//�������е�����ĵ�һ��ֵ����ֵ������������һ����ֵ
			count--;//���ε�����
		}
		return t;//���ص���ת���������
	}
}

/*
 * ������
 */
class SortArray extends Array{
	
	//���췽��
	public SortArray(int len){
		super(len);//���ø���Ĺ��췽��
	}
	
	//��д����Ļ�ȡԪ�صķ���==Ϊ����������
	public int[] getArray(){
		java.util.Arrays.sort(super.getArray());//�������е���������
		
		return super.getArray();//���������ĸ��������
	}
}








public class ArrayDemo {

	public static void main(String[] args) {
		ReverseArray a = new ReverseArray(5);//����һ��������󣬲��涨�䳤��Ϊ5
//		SortArray a = new SortArray(5);
		
		//���������������
		a.add(12);
		a.add(120);
		a.add(102);
		a.add(27);
		a.add(2);
		
		print(a.getArray());
	}
	
	//����һ������������ݵķ���
	public static void print(int[] i){
		for(int x=0;x<i.length;x++){
			System.out.println(i[x]+"��");
		}
	}

}
