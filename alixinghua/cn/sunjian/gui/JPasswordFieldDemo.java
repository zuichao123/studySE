package cn.sunjian.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/**
 * ͼ�ν��棺
 * 
 * 		JPasswordField��
			���������
 * 
 * @author jack
 *
 */
public class JPasswordFieldDemo {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("JPasswordField") ;
		JPasswordField jpf1 = new JPasswordField() ;
		JPasswordField jpf2 = new JPasswordField() ;
		jpf2.setEchoChar('#') ;	// ���û���
		JLabel lab1 = new JLabel("Ĭ�ϵĻ��ԣ�") ;
		JLabel lab2 = new JLabel("�������á�#����") ;

		lab1.setBounds(10,10,100,20) ;
		lab2.setBounds(10,40,100,20) ;
		jpf1.setBounds(110,10,80,20) ;
		jpf2.setBounds(110,40,50,20) ;

		frame.setLayout(null) ;
		frame.add(lab1) ;
		frame.add(jpf1) ;
		frame.add(lab2) ;
		frame.add(jpf2) ;
		frame.setSize(300,100) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

}
