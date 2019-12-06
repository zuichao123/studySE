package cn.sunjian.interfaces;
/**
 * 适配器设计模式
 * 
 * @author sunjian
 *
 */

interface Windows{
	public void open();
	public void close();
	public void actived();
	public void xxx();
}
abstract class WindowAdapter implements Windows{
	public void open(){};
	public void close(){};
	public void actived(){};
	public void xxx(){};
}
class WindowImpl extends WindowAdapter{
	public void open(){
		System.out.println("窗口打开");
	}
	public void close(){
		System.out.println("窗口关闭");
	}
}



public class AdapterDemo {

	public static void main(String[] args) {
		Windows w = new WindowImpl();
		w.open();
		w.close();
	}

}
