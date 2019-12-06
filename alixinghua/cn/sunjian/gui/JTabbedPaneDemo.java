package cn.sunjian.gui;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * ͼ�ν��棺
 * 	
 * 		JTabbedPane��
 * 			����һ����������ö��ѡ����û�ѡ��
 * 
 * @author jack
 *
 */
public class JTabbedPaneDemo {

	public static void main(String[] args) {

		JFrame frame = new JFrame("JTabbedPane") ; // ʵ�����������
		Container cont = frame.getContentPane() ;
		JTabbedPane tab = null ;
		tab = new JTabbedPane(JTabbedPane.TOP) ;// ���ñ�ǩ�ڶ�����ʾ
		JPanel pan1 = new JPanel() ;
		JPanel pan2 = new JPanel() ;
		JButton but = new JButton("��ť") ;
		JLabel lab = new JLabel("��ǩ") ;
		pan1.add(but) ;
		pan2.add(lab) ;
		String picPath = System.getProperty("user.dir")+"/files/lixinghua/image/liya.jpg";
		tab.addTab("ͼƬѡ��",new ImageIcon(picPath),pan1,"���Ǹ�ͼ��") ;
		tab.addTab("����ѡ��",pan2) ;	
		cont.add(tab) ;
		frame.setSize(330,245);// ��������Զ�������С
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

}
