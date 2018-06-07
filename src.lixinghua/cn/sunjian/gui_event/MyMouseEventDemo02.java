package cn.sunjian.gui_event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			��������
 *				ʹ�������ڲ���+MouseAdapter�ķ�ʽ��ֻ��д���õķ�����
 *					������С��Ҽ���
 *
 * @author sunjian
 *
 */
class MyMouseHandle extends JFrame{
	/**
	 * Ĭ�����к�
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
					mouseInfo = "���" ;
				}
				if(c==MouseEvent.BUTTON3){
					mouseInfo = "�Ҽ�" ;
				}
				if(c==MouseEvent.BUTTON2){
					mouseInfo = "����" ;
				}
				text.append("��굥����" + mouseInfo + "\n") ;
			}
		}) ;

		// ���봰��ر��¼�
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
