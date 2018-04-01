package cn.sunjian.generic.define.demo;

public class GenericDefineDemo2 {

	public static void main(String[] args) {

		Tool<String > tool = new Tool<String>();
	
		tool.show(new Integer(4));
		tool.show("abc");
		tool.print("nab");
		Tool.Method("ddd");
		Tool.Method(new Integer(8));
		
	}

}
