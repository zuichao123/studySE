package cn.sunjian.gui_event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			���̼�����
 *				ֻ��д���õķ������������ڲ���ķ�ʽ��
 *					ֻ���������������ݣ�
 * @author sunjian
 *
 */

class MyKeyHandle extends JFrame{
	/**
	 * Ĭ�����к�
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
				text.append("����������ǣ�" + e.getKeyChar() + "\n") ;
			} 
		}) ;
		super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	// �����¼�
		super.setSize(310,210) ;
		super.setVisible(true) ;
	}
	
};


public class MyKeyEventDemo02{
	public static void main(String args[]){
		new MyKeyHandle() ;
	}
};
