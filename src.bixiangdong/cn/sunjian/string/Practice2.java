package cn.sunjian.string;

/**
 * �󳤷��ε��ܳ���Բ�ε����
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
			throw new NoValueException("��ֵ�Ƿ�������");
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
			throw new NoValueException("�뾶ֵ�Ƿ�������");
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
		System.out.println("�����ε����area:"+a);
		
		Circle c = new Circle(600);
		double j = c.getArea();
		System.out.println("Բ��ƽ��="+j);
	}

}
