package cn.sunjian.array;


class Array{
	private int[] temp;
	private int foot;
	
	public Array(int len){
		if (len>0) {
			this.temp = new int[len];
		}else {
			this.temp = new int[1];
		}
	}

	public boolean add(int i){
		if (this.foot<this.temp.length) {
			this.temp[foot] = i;
			this.foot++;
			return true;
		}else {
			return false;
		}
	}
	
	public int[] getArray(){
		return this.temp;
	}
}

/*
 * 数组反转
 */
class ReverseArray extends Array{
	
	public ReverseArray(int len){
		super(len);
	}
	
	public int[] getArray(){
		int[] t = new int[super.getArray().length];
		int count = super.getArray().length-1;
		
		for(int x=0;x<super.getArray().length;x++){
			t[count] = super.getArray()[x];
			count--;
		}
		return t;
	}
}


/*
 * 数组排序
 */
class SortArray extends Array{
	
	public SortArray(int len){
		super(len);
	}
	
	public int[] getArray(){
		java.util.Arrays.sort(super.getArray());
		return super.getArray();
	}
}



public class ArrayDemo {
	public static void main(String[] args) {
		SortArray s = new SortArray(10);
//		ReverseArray s = new ReverseArray(10);
		
		for(int i=1;i<11;i++){			
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
	
	
	public static void print(int[] aa){
		for(int x=0;x<aa.length;x++){
			System.out.print(aa[x]+"、");
		}
	}
	
}



















