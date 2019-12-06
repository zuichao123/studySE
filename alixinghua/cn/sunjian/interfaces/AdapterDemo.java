package cn.sunjian.interfaces;
/**
 * ���������ģʽ
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
		System.out.println("���ڴ�");
	}
	public void close(){
		System.out.println("���ڹر�");
	}
}



public class AdapterDemo {

	public static void main(String[] args) {
		Windows w = new WindowImpl();
		w.open();
		w.close();
	}

}
