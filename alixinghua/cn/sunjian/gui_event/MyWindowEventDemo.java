package cn.sunjian.gui_event;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

/**
 * 图形界面：
 * 
 * 		事件监听:
 * 			窗口监听：
 * 				是专门处理窗体的事件监听接口，一个窗体的所有变化，例如：窗口打开、关闭等都可以使用这个接口进行监听；
 *					WindowListener：
 *						使用这个窗口监听必须全部覆写其所有的方法；
 *					WindowAdapter：
 *						不用覆写其所有的方法，用到哪个覆写哪个即可；
 *						也可使用匿名内部类的方式，用到哪个覆写哪个即可，这样不用单独创建一个类；
 * 
 * @author sunjian
 *
 */
class MyWindowEventHandle implements WindowListener{
	public void windowActivated(WindowEvent e){
		System.out.println("windowActivated --> 窗口被选中") ;
	}
	public void windowClosed(WindowEvent e){
		System.out.println("windowClosed --> 窗口被关闭") ;
	}
	public void windowClosing(WindowEvent e){
		System.out.println("windowClosing --> 窗口关闭") ;
		System.exit(1) ;//系统退出
	}
	public void windowDeactivated(WindowEvent e){
		System.out.println("windowDeactivated --> 取消窗口选中") ;
	}
	public void windowDeiconified(WindowEvent e){
		System.out.println("windowDeiconified --> 窗口从最小化恢复") ;
	}
	public void windowIconified(WindowEvent e){
		System.out.println("windowIconified --> 窗口最小化") ;
	}
	public void windowOpened(WindowEvent e){
		System.out.println("windowOpened --> 窗口被打开") ;
	}
}

class MyWindowEventHandle2 extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		System.out.println("windowClosing --> 窗口关闭") ;
		System.exit(1) ;
	}
}

public class MyWindowEventDemo {

	public static void main(String[] args) {
		windowListener();
		windowAdapter();
		innerClassWindowAdapter();
	}

	private static void innerClassWindowAdapter() {
		JFrame frame = new JFrame("innerClassWindowAdapter") ; 
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.out.println("windowClosing --> 窗口关闭") ;
				System.exit(1) ;
			}
		}) ;	// 加入事件
		frame.setSize(300,150) ;
		frame.setBackground(Color.WHITE) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

	private static void windowAdapter() {
		JFrame frame = new JFrame("windowAdapter") ; 
		frame.addWindowListener(new MyWindowEventHandle2()) ;	// 加入事件
		frame.setSize(300,150) ;
		frame.setBackground(Color.WHITE) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

	private static void windowListener() {
		JFrame frame = new JFrame("WindowListener") ; 
		frame.addWindowListener(new MyWindowEventHandle()) ;	// 加入事件
		frame.setSize(300,150) ;
		frame.setBackground(Color.WHITE) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

}
