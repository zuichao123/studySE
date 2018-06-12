package cn.sunjian.stringbuffer;

public class StringBufferDemo {
	
	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		
		bufferMethodDemo();
	}

	public static void bufferMethodDemo() {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(4).append("haha");
		System.out.println(sb);
		sb.insert(1, "aoao");
		System.out.println(sb);
	}

}
