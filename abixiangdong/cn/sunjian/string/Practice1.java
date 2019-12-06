package cn.sunjian.string;


interface A{
	void show();
}
interface B{
	void add(int a,int b);
}

class C implements A,B{
	
	private int x,y;
	public void show(){
		System.out.println(x+y);
	} 
	public void add(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Practice1 {

	public static void main(String[] args) {
		
		C c = new C();
		c.add(4, 5);
		c.show();
	}

}
