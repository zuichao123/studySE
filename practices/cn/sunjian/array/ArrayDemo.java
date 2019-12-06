package cn.sunjian.array;
/**
 * 数组练习：
 * 
 * 		反转、排序		
 * 
 * @author jack
 *
 */

class Array{
	private int[] temp;//定义整形数组
	private int foot;//定义数组角标变量
	
	public Array(int len){//构造，判断后对数组初始化（保证数组长度最少为1）
		if (len>0) {
			this.temp = new int[len];
		}else {
			this.temp = new int[1];
		}
	}

	public boolean add(int i){//添加数据方法
		if (this.foot<this.temp.length) {//如果，当前角标位置，小于数组的长度（没有内容时，角标为0）
			this.temp[foot] = i;//将当前内容添加到当前角标所处位置
			this.foot++;//角标自加
			return true;//返回真
		}else {
			return false;//否则，返回假
		}
	}
	
	public int[] getArray(){//得到数组
		return this.temp;//返回当前数组
	}
}

/*
 * 数组反转
 */
class ReverseArray extends Array{
	
	public ReverseArray(int len){
		super(len);//调用父类的构造方法，对父类中的数组进行初始化
	}
	
	public int[] getArray(){
		int[] t = new int[super.getArray().length];//定义一个新的数组，和父类中的数组大小一致
		int count = super.getArray().length-1;//获取父类数组的最大角标值
		
		for(int x=0;x<super.getArray().length;x++){
			t[count] = super.getArray()[x];//将父类中的数组的第一个赋值给新的数组最后一个（以此类推循环）
			count--;//角标自减
		}
		return t;//返回反转后的数组
	}
}


/*
 * 数组排序
 */
class SortArray extends Array{
	
	public SortArray(int len){
		super(len);//调用父类中的构造方法，对父类中的数组进行初始化
	}
	
	public int[] getArray(){
		java.util.Arrays.sort(super.getArray());//对父类中的数组进行排序
		return super.getArray();//返回排序后的数组
	}
}



public class ArrayDemo {
	public static void main(String[] args) {
//		SortArray s = new SortArray(10);
		ReverseArray s = new ReverseArray(10);
		
		for(int i=1;i<11;i++){//为数组添加数据	
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
	
	
	public static void print(int[] aa){//循环输出数组中的内容
		for(int x=0;x<aa.length;x++){
			System.out.print(aa[x]+"、");
		}
	}
	
}



















