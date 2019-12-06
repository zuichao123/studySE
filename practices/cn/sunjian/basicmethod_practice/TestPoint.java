package cn.sunjian.basicmethod_practice;

public class TestPoint {
	double x,y,z;
	
	public TestPoint(double _x,double _y,double _z){
		x = _x;
		y = _y;
		z = _z;
	}
	
	public void setY(double _y){
		y = _y;
	}
	
	public void setZ(double _z){
		z = _z;
	}
	
	public double distance(TestPoint p){
		return (x-p.x)*(x-p.x)+(y-p.y)*(y-p.y)+(z-p.z)*(z-p.z);
	}
	
	public void setX(double _x){
		x = _x;
	}
	public static void main(String[] args){
		TestPoint p = new TestPoint(3, 4, 8);
		TestPoint p2 = new TestPoint(200, 30, 60);
		
		System.out.println(p.x);
		System.out.println(p.distance(p2));
	}
}
