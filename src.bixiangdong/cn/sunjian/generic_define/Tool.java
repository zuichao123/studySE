package cn.sunjian.generic_define;

import java.lang.reflect.Method;

/*public class Tool {

	private Object object;

	*//**
	 * @return the object
	 *//*
	public Object getObject() {
		return object;
	}

	*//**
	 * @param object the object to set
	 *//*
	public void setObject(Object object) {
		this.object = object;
	}
	
	
}*/

public class Tool<QQ>{
	
	private QQ qq;

	/**
	 * @return the qq
	 */
	public QQ getObject() {
		return qq;
	}

	/**
	 * @param qq the qq to set
	 */
	public void setObject(QQ qq) {
		this.qq = qq;
	}
	
	/**
	 * �����Ͷ����ڷ�����
	 * @param str
	 */
	public <W> void show(W str){
		System.out.println("show:"+str);
	}
	
	public void print(QQ str){
		System.out.println("print:"+str);
	}
	
	/**
	 * ������Ϊ��̬ʱ�����ܷ������϶���ķ��ͣ�
	 * ֻ�ܽ����Ͷ����ڷ�����
	 * 
	 * @param str
	 */
	public static <T> void Method(T str){
		System.out.println("method:"+str);
	}
	
}
