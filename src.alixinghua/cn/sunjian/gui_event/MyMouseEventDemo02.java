package cn.sunjian.gui_event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 图形界面：
 * 
 * 		事件监听:
 * 			鼠标监听：
 *				使用匿名内部类+MouseAdapter的方式，只覆写有用的方法；
 *					鼠标左、中、右键；
 *
 * @author sunjian
 *
 */
class MyMouseHandle extends JFrame{
	/**
	 * 默认序列号
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea text = new JTextArea() ;
	public MyMouseHandle(){
		super.setTitle("Welcome To MLDN") ;
		JScrollPane scr = new JScrollPane(text) ;
		scr.setBounds(5,5,300,200) ;
		super.add(scr) ;
		text.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int c = e.getButton() ;
				String mouseInfo = null ;
				if(c==MouseEvent.BUTTON1){
					mouseInfo = "左键" ;
				}
				if(c==MouseEvent.BUTTON3){
					mouseInfo = "右键" ;
				}
				if(c==MouseEvent.BUTTON2){
					mouseInfo = "滚轴" ;
				}
				text.append("鼠标单击：" + mouseInfo + "\n") ;
			}
		}) ;

		// 加入窗体关闭事件
		super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	
		super.setSize(310,210) ;
		super.setVisible(true) ;
	}
}


public class MyMouseEventDemo02{
	public static void main(String args[]){
		new MyMouseHandle() ;
	}
}
