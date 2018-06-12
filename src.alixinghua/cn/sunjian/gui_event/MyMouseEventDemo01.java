package cn.sunjian.gui_event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
 *				��д�ӿ��е����з���������꣺���롢�뿪�����¡��ɿ��ȣ�
 * @author sunjian
 *
 */
class MyMouseHandle01 extends JFrame implements MouseListener{
	/**
	 * Ĭ�����к�
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea text = new JTextArea() ;//�����ı�
	public MyMouseHandle01(){
		super.setTitle("Welcome To MLDN") ;
		JScrollPane scr = new JScrollPane(text) ;
		scr.setBounds(5,5,300,200) ;
		super.add(scr) ;
		text.addMouseListener(this) ;

		// ���봰��ر��¼�
		super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	
		super.setSize(310,210) ;
		super.setVisible(true) ;
	}

	//�ж����Ĳ���
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

	public void mouseEntered(MouseEvent e){
		text.append("�����������\n") ;
	}
	public void mouseExited(MouseEvent e){
		text.append("����뿪�����\n") ;
	}
	public void mousePressed(MouseEvent e){
		text.append("��갴�¡�\n") ;
	}
	public void mouseReleased(MouseEvent e){
		text.append("����ɿ���\n") ;
	}
	
}


public class MyMouseEventDemo01{
	public static void main(String args[]){
		new MyMouseHandle01() ;
	}
}
