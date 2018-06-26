package cn.sunjian.gui_event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * 图形界面：
 * 
 * 		事件监听:
 * 			鼠标拖拽监听：
 *				使用MouseMotionAdapter类，只覆写接口中有用的方法；
 *					只覆写鼠标拖拽方法；
 * @author sunjian
 *
 */
class MyMouseMotionHandle extends JFrame{
	/**
	 * 默认序列号
	 */
	private static final long serialVersionUID = 1L;

	public MyMouseMotionHandle(){
		super.setTitle("Welcome To MLDN") ;
		super.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				System.out.println("鼠标拖拽到：X = " + e.getX() + "，Y = " + e.getY

()) ;
			}
		}) ;
		super.addWindowListener(new WindowAdapter(){// 加入事件
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	
		super.setSize(310,210) ;
		super.setVisible(true) ;
	}
};


public class MyMouseMotionEventDemo02{
	public static void main(String args[]){
		new MyMouseMotionHandle() ;
	}
};
