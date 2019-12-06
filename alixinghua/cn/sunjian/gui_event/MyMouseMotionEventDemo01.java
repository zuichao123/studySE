package cn.sunjian.gui_event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			�����ק������
 *				ʹ�������ڲ���ķ�ʽ��д�ӿ��е����з���������꣺��ק���ƶ���
 * @author sunjian
 *
 */
class MyMouseMotionHandle01 extends JFrame{
	/**
	 * Ĭ�����к�
	 */
	private static final long serialVersionUID = 1L;

	public MyMouseMotionHandle01(){
		super.setTitle("Welcome To MLDN") ;
		super.addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e){
				System.out.println("�����ק����X = " + e.getX() + "��Y = " + e.getY

()) ;
			}
			public void mouseMoved(MouseEvent e){
				System.out.println("����ƶ������塣") ;
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
}

public class MyMouseMotionEventDemo01{
	public static void main(String args[]){
		new MyMouseMotionHandle01() ;
	}
}