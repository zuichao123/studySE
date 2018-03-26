package com.sunjian.basicmethod.practice;
/**
 * ≤‚ ‘÷ÿ‘ÿ
 * @author sunjian
 *
 */
public class TestOverLoad {
	
	static int a = 10;
	static int b = 20;
	static int c = 30;	

	public static void main(String[] args){
		
		
		
		MyMath m = new MyMath();
		int result = m.add(a,b);
		System.out.println(result);
		
		
		int result1 = m.add(a,b,c);
		System.out.println(result1);
		
//		MyMath m1 = new MyMath(a);
//		System.out.println(m1);
//		
//		MyMath m2 = new MyMath(a, b);
//		System.out.println(m2);
	}
}

class MyMath {
	
	public MyMath(){
		
	}
	public MyMath(int a){
		return;
	}
	public MyMath(int a,int b){
		return;
	}
	
	public int add(int a,int b){
		return a+b;
	}
	
	public int add(int a,int b,int c){
		return a+b+c;    
	}
}
