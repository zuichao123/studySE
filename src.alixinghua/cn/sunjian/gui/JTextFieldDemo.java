package cn.sunjian.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * ͼ�ν��棺
 * 
 * 		JTextField��
			�����ı������
 * 
 * @author jack
 *
 */
public class JTextFieldDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("JTextField") ;
		JTextField name = new JTextField(10) ;
		JTextField noed = new JTextField("MLDN",8) ;
		JLabel nameLab = new JLabel("�����û�������") ;
		JLabel noedLab = new JLabel("���ɱ༭�ı���") ;
		name.setColumns(30) ;
		noed.setColumns(10) ;
		noed.setEnabled(false) ;	// ��ʾ���ɱ༭

		nameLab.setBounds(10,10,100,20) ;//���Զ�λ
		noedLab.setBounds(10,40,100,20) ;
		name.setBounds(110,10,80,20) ;
		noed.setBounds(110,40,50,20) ;
		frame.setLayout(null) ;

		//frame.setLayout(new GridLayout(2,2));//���ֹ���������Ҫ��ʹ�ò��ֹ�������ʱ�����Ե��ı����Ĭ������ֵ�������Ҫ������������⣬���Բ��þ��Զ�λ�ķ�ʽ����������5�д��롿��
	
		frame.add(nameLab) ;
		frame.add(name) ;
		frame.add(noedLab) ;
		frame.add(noed) ;
		frame.setSize(300,100) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;

	}

}
