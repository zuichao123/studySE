package cn.sunjian.gui_event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
 *				覆写接口中的所有方法；（键盘：按下、输入内容、松开）
 * @author sunjian
 *
 */


class MyKeyHandle2 extends JFrame implements KeyListener{
	/**
	 * 默认序列号
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea text = new JTextArea() ;
	public MyKeyHandle2(){
		super.setTitle("键盘监听事件") ;
		JScrollPane scr = new JScrollPane(text) ;//将文本放在滚动条之中
		scr.setBounds(5,5,300,200) ;//设置滚动条大小、位置
		super.add(scr) ;//加入滚动条
		text.addKeyListener(this) ;//文本加入键盘监听
		
		//加入窗口的关闭事件
		super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	

		super.setSize(310,210) ;
		super.setVisible(true) ;
	}
	
	//覆写方法
	public void keyPressed(KeyEvent e){//键盘的**键按下
		text.append("键盘“" + KeyEvent.getKeyText(e.getKeyCode())+ "”键按下\n") ;
	}

	public void keyReleased(KeyEvent e){//键盘的**键松开
		text.append("键盘“" + KeyEvent.getKeyText(e.getKeyCode())+ "”键松开\n") ;
	}

	public void keyTyped(KeyEvent e){//键盘输入的内容
		text.append("输入的内容是：" + e.getKeyChar() + "\n") ;
	} 
}


public class MyKeyEventDemo01{
	public static void main(String args[]){
		new MyKeyHandle2() ;
	}
}
