package cn.sunjian.gui_event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			�����ק������
 *				ʹ��MouseMotionAdapter�ֻ࣬��д�ӿ������õķ�����
 *					ֻ��д�����ק������
 * @author sunjian
 *
 */
class MyMouseMotionHandle extends JFrame{
	/**
	 * Ĭ�����к�
	 */
	private static final long serialVersionUID = 1L;

	public MyMouseMotionHandle(){
		super.setTitle("Welcome To MLDN") ;
		super.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				System.out.println("�����ק����X = " + e.getX() + "��Y = " + e.getY

()) ;
			}
		}) ;
		super.addWindowListener(new WindowAdapter(){// �����¼�
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
