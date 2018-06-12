package cn.sunjian.gui_event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 图形界面：
 * 
 * 		事件监听:
 * 			键盘监听：
 *				只覆写有用的方法；用匿名内部类的方式；
 *					只监听键盘输入内容；
 * @author sunjian
 *
 */

class MyKeyHandle extends JFrame{
	/**
	 * 默认序列号
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea text = new JTextArea() ;
	public MyKeyHandle(){
		super.setTitle("Welcome To MLDN") ;
		JScrollPane scr = new JScrollPane(text) ;
		scr.setBounds(5,5,300,200) ;
		super.add(scr) ;

		text.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				text.append("输入的内容是：" + e.getKeyChar() + "\n") ;
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
	
};


public class MyKeyEventDemo02{
	public static void main(String args[]){
		new MyKeyHandle() ;
	}
};
