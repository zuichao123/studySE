package cn.sunjian.gui_event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
 *				��д�ӿ��е����з����������̣����¡��������ݡ��ɿ���
 * @author sunjian
 *
 */


class MyKeyHandle2 extends JFrame implements KeyListener{
	/**
	 * Ĭ�����к�
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea text = new JTextArea() ;
	public MyKeyHandle2(){
		super.setTitle("���̼����¼�") ;
		JScrollPane scr = new JScrollPane(text) ;//���ı����ڹ�����֮��
		scr.setBounds(5,5,300,200) ;//���ù�������С��λ��
		super.add(scr) ;//���������
		text.addKeyListener(this) ;//�ı�������̼���
		
		//���봰�ڵĹر��¼�
		super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	

		super.setSize(310,210) ;
		super.setVisible(true) ;
	}
	
	//��д����
	public void keyPressed(KeyEvent e){//���̵�**������
		text.append("���̡�" + KeyEvent.getKeyText(e.getKeyCode())+ "��������\n") ;
	}

	public void keyReleased(KeyEvent e){//���̵�**���ɿ�
		text.append("���̡�" + KeyEvent.getKeyText(e.getKeyCode())+ "�����ɿ�\n") ;
	}

	public void keyTyped(KeyEvent e){//�������������
		text.append("����������ǣ�" + e.getKeyChar() + "\n") ;
	} 
}


public class MyKeyEventDemo01{
	public static void main(String args[]){
		new MyKeyHandle2() ;
	}
}
