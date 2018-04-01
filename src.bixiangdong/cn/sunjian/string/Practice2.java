package cn.sunjian.string;

/**
 * 求长方形的周长和圆形的面积
 * 
 * @author sunjian
 *
 */
interface Areable{
	public double getArea();
}

@SuppressWarnings("serial")
class NoValueException extends RuntimeException{
	public NoValueException() {
		super();
	}
	NoValueException(String msg){
		super(msg);
	}
}

class Rec implements Areable{
	private int length;
	private int width;
	
	public Rec(int length, int width) {
		
		if (length<0 || width <0) {
			throw new NoValueException("数值非法！！！");
		}
		
		this.length = length;
		this.width = width;
	}
	
	public double getArea(){
		return length*width;
	}
}


class Circle implements Areable{
	private int radius;
	public static final double PI = 3.14;
	public Circle(int radius) {
		
		if (radius<=0) {
			throw new NoValueException("半径值非法！！！");
		}
		this.radius = radius;
	}
	public double getArea(){
		return radius*radius*PI;
	}
}

public class Practice2 {

	public static void main(String[] args) {
		Rec r = new Rec(3, 5);
		
		double a = r.getArea();
		System.out.println("长方形的面积area:"+a);
		
		Circle c = new Circle(600);
		double j = c.getArea();
		System.out.println("圆的平方="+j);
	}

}
