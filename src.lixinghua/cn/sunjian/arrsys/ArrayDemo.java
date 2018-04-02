package cn.sunjian.arrsys;
/**
 * 联系数组反转、排序
 * 
 * @author sunjian
 *
 */

/*
 * 定义数组类
 * 添加元素方法
 * 获取元素方法
 */
class Array{
	private int temp[];//定义一个整形数组temp
	private int foot;  //定义数组的角标位置
	
	//构造方法
	public Array(int len){//构造方法，并对temp数组属性赋值（最少维持一个空间）
		if (len>0) {
			this.temp = new int[len];
		}else {
			this.temp = new int[1];
		}
	}
	
	//添加元素方法
	public boolean add(int i){
		if(this.foot<this.temp.length){//如果当前角标的位置小于数组的长度（说明还可以添加，还有位置）
			this.temp[foot] = i;//就把当前添加的整形数字放在当前角标处
			this.foot++;//并将当前的角标加1（向后移动一个角标，因为添加内容了）
			return true;//返回添加成功的标志true
		}else {
			return false;//否则返回添加失败的标志false
		}
	}
	
	//获取元素方法
	public int[] getArray(){
		return this.temp;
	}
}

/*
 * 反转操作类
 */
class ReverseArray extends Array{
	
	//构造方法
	public ReverseArray(int len){
		super(len);//调用父类的构造方法
	}
	
	//覆写父类的获取元素的方法==为反转后的数组
	public int[] getArray(){
		int t[] = new int[super.getArray().length];//定义一个新的数组，长度与父类的数组长度一致
		int count = super.getArray().length-1;//定义新数组中存放最后一个数值的角标
		
		for (int i = 0; i < t.length; i++) {
			t[count] = super.getArray()[i];//将父类中的数组的第一个值，赋值给新数组的最后一个数值
			count--;//依次倒序存放
		}
		return t;//返回倒序反转后的新数组
	}
}

/*
 * 排序类
 */
class SortArray extends Array{
	
	//构造方法
	public SortArray(int len){
		super(len);//调用父类的构造方法
	}
	
	//覆写父类的获取元素的方法==为排序后的数组
	public int[] getArray(){
		java.util.Arrays.sort(super.getArray());//将父类中的数组排序
		
		return super.getArray();//返回排序后的父类的数组
	}
}








public class ArrayDemo {

	public static void main(String[] args) {
		ReverseArray a = new ReverseArray(5);//定义一个数组对象，并规定其长度为5
//		SortArray a = new SortArray(5);
		
		//在数组中添加内容
		a.add(12);
		a.add(120);
		a.add(102);
		a.add(27);
		a.add(2);
		
		print(a.getArray());
	}
	
	//定义一个输出数组内容的方法
	public static void print(int[] i){
		for(int x=0;x<i.length;x++){
			System.out.println(i[x]+"、");
		}
	}

}
