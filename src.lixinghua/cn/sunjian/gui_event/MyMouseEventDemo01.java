package cn.sunjian.gui_event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
 *				覆写接口中的所有方法；（鼠标：进入、离开、按下、松开等）
 * @author sunjian
 *
 */
class MyMouseHandle01 extends JFrame implements MouseListener{
	/**
	 * 默认序列号
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea text = new JTextArea() ;//多行文本
	public MyMouseHandle01(){
		super.setTitle("Welcome To MLDN") ;
		JScrollPane scr = new JScrollPane(text) ;
		scr.setBounds(5,5,300,200) ;
		super.add(scr) ;
		text.addMouseListener(this) ;

		// 加入窗体关闭事件
		super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	
		super.setSize(310,210) ;
		super.setVisible(true) ;
	}

	//判断鼠标的操作
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

	public void mouseEntered(MouseEvent e){
		text.append("鼠标进入组件。\n") ;
	}
	public void mouseExited(MouseEvent e){
		text.append("鼠标离开组件。\n") ;
	}
	public void mousePressed(MouseEvent e){
		text.append("鼠标按下。\n") ;
	}
	public void mouseReleased(MouseEvent e){
		text.append("鼠标松开。\n") ;
	}
	
}


public class MyMouseEventDemo01{
	public static void main(String args[]){
		new MyMouseHandle01() ;
	}
}
