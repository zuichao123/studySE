package cn.sunjian.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * ͼ�ν��棺
 * 
 * 		���ֹ�������
 * 			FlowLayout
 *				��ʽ���ֹ�������
 *			BorderLayout
 *				��һ������İ��滮��Ϊ�����ϱ���������򣬿���ֱ�ӽ���Ҫ������ŵ�����������м��ɣ�
 *			GridLayout
 *				���Ա�����ʽ���й���ģ���ʹ�ô˲��ֹ�������ʱ�����������ʾ��������������
 *			GardLayout
 *				��һ������˴��ص��Ľ��в��֣�����һ���ſ�Ƭһ��������ÿ��ֻ��չ��һ�����棻
 *			���Զ�λ��				
 *				ͨ�����þ�������ķ�ʽ��ɣ���Component���ṩ��setBounds()���������Զ�λһ����������꣬ʹ��X��Y�������ʾ��ʽ���˷����������£�
 *   				public void setBounds(int x,int y,int width,int height);
 * 
 * @author jack
 *
 */
public class LayoutDemo {

	public static void main(String[] args) {

		FlowLayout();
		BorderLayout();
		GridLayout();
		GardLayout();
		AbsoluteLayout();
	}

	private static void AbsoluteLayout() {
		JFrame frame = new JFrame("AbsoluteLayout") ; 
		frame.setLayout(null) ;
		JLabel title = new JLabel("www.mldnjava.cn") ;
		JButton enter = new JButton("����") ;
		JButton help = new JButton("����") ;
		frame.setSize(280,123) ;
		title.setBounds(45,5,150,20) ;
		enter.setBounds(10,30,80,20) ;
		help.setBounds(100,30,80,20) ;
		frame.add(title) ;
		frame.add(enter) ;
		frame.add(help) ;
		frame.setVisible(true) ;
	}

	private static void GardLayout() {
		JFrame frame = new JFrame("GardLayout") ; 
		CardLayout card = new CardLayout() ;
		frame.setLayout(card) ;
		Container con = frame.getContentPane() ;
		con.add(new JLabel("��ǩ-A",JLabel.CENTER),"first") ;
		con.add(new JLabel("��ǩ-B",JLabel.CENTER),"second") ;
		con.add(new JLabel("��ǩ-C",JLabel.CENTER),"thrid") ;
		con.add(new JLabel("��ǩ-D",JLabel.CENTER),"fourth") ;
		con.add(new JLabel("��ǩ-E",JLabel.CENTER),"fifth") ;
		frame.pack() ;
		frame.setVisible(true) ;
		card.show(con,"thrid") ;
		for(int i=0;i<5;i++){
			try{
				Thread.sleep(2000) ;
			}catch(InterruptedException e){}
			card.next(con) ;
		}
	}

	private static void GridLayout() {
		JFrame frame = new JFrame("GridLayout");
		frame.setLayout(new java.awt.GridLayout(3,5,3,33));//���ð�ť�С��С����Ҽ�ࡢ���¼��
		JButton but = null;
		for(int i=0;i<13;i++){
			but = new JButton("��ť"+i);
			frame.add(but);
		}
		
		frame.pack();//��������Զ����������С
		frame.setVisible(true);
	}

	private static void BorderLayout() {
		JFrame frame = new JFrame("BorderLayout");
		frame.setLayout(new java.awt.BorderLayout(3, 3));
		
		frame.add(new JButton("����EAST��"),java.awt.BorderLayout.EAST);
		frame.add(new JButton("����WEST��"),java.awt.BorderLayout.WEST);
		frame.add(new JButton("�ϣ�SOUTH��"),java.awt.BorderLayout.SOUTH);
		frame.add(new JButton("����NORTH��"),java.awt.BorderLayout.NORTH);
		frame.add(new JButton("�У�CENTER��"),java.awt.BorderLayout.CENTER);
		
		frame.setSize(400, 200);
		frame.setVisible(true);
	}

	private static void FlowLayout() {
		JFrame frame = new JFrame("FlowLayout");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));//���Ҽ�ࡢ���¼��
		
		JButton but = null;
		for(int i=0;i<10;i++){
			but = new JButton("��ť"+i);
			frame.add(but);
		}
		
		frame.setSize(300, 200);
		frame.setVisible(true);
	}

}
