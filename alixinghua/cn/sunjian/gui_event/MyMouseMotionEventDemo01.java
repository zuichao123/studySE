package cn.sunjian.gui_event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * 图形界面：
 * 
 * 		事件监听:
 * 			鼠标拖拽监听：
 *				使用匿名内部类的方式覆写接口中的所有方法；（鼠标：拖拽、移动）
 * @author sunjian
 *
 */
class MyMouseMotionHandle01 extends JFrame{
	/**
	 * 默认序列号
	 */
	private static final long serialVersionUID = 1L;

	public MyMouseMotionHandle01(){
		super.setTitle("Welcome To MLDN") ;
		super.addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e){
				System.out.println("鼠标拖拽到：X = " + e.getX() + "，Y = " + e.getY

()) ;
			}
			public void mouseMoved(MouseEvent e){
				System.out.println("鼠标移动到窗体。") ;
			}
		}) ;
		super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	// 加入事件
		super.setSize(310,210) ;
		super.setVisible(true) ;
	}
}

public class MyMouseMotionEventDemo01{
	public static void main(String args[]){
		new MyMouseMotionHandle01() ;
	}
}