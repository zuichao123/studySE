package cn.sunjian.gui_event;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			���ڼ�����
 * 				��ר�Ŵ�������¼������ӿڣ�һ����������б仯�����磺���ڴ򿪡��رյȶ�����ʹ������ӿڽ��м�����
 *					WindowListener��
 *						ʹ��������ڼ�������ȫ����д�����еķ�����
 *					WindowAdapter��
 *						���ø�д�����еķ������õ��ĸ���д�ĸ����ɣ�
 *						Ҳ��ʹ�������ڲ���ķ�ʽ���õ��ĸ���д�ĸ����ɣ��������õ�������һ���ࣻ
 * 
 * @author sunjian
 *
 */
class MyWindowEventHandle implements WindowListener{
	public void windowActivated(WindowEvent e){
		System.out.println("windowActivated --> ���ڱ�ѡ��") ;
	}
	public void windowClosed(WindowEvent e){
		System.out.println("windowClosed --> ���ڱ��ر�") ;
	}
	public void windowClosing(WindowEvent e){
		System.out.println("windowClosing --> ���ڹر�") ;
		System.exit(1) ;//ϵͳ�˳�
	}
	public void windowDeactivated(WindowEvent e){
		System.out.println("windowDeactivated --> ȡ������ѡ��") ;
	}
	public void windowDeiconified(WindowEvent e){
		System.out.println("windowDeiconified --> ���ڴ���С���ָ�") ;
	}
	public void windowIconified(WindowEvent e){
		System.out.println("windowIconified --> ������С��") ;
	}
	public void windowOpened(WindowEvent e){
		System.out.println("windowOpened --> ���ڱ���") ;
	}
}

class MyWindowEventHandle2 extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		System.out.println("windowClosing --> ���ڹر�") ;
		System.exit(1) ;
	}
}

public class MyWindowEventDemo {

	public static void main(String[] args) {
		windowListener();
		windowAdapter();
		innerClassWindowAdapter();
	}

	private static void innerClassWindowAdapter() {
		JFrame frame = new JFrame("innerClassWindowAdapter") ; 
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.out.println("windowClosing --> ���ڹر�") ;
				System.exit(1) ;
			}
		}) ;	// �����¼�
		frame.setSize(300,150) ;
		frame.setBackground(Color.WHITE) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

	private static void windowAdapter() {
		JFrame frame = new JFrame("windowAdapter") ; 
		frame.addWindowListener(new MyWindowEventHandle2()) ;	// �����¼�
		frame.setSize(300,150) ;
		frame.setBackground(Color.WHITE) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

	private static void windowListener() {
		JFrame frame = new JFrame("WindowListener") ; 
		frame.addWindowListener(new MyWindowEventHandle()) ;	// �����¼�
		frame.setSize(300,150) ;
		frame.setBackground(Color.WHITE) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

}
