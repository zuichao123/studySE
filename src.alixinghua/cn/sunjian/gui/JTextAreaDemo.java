package cn.sunjian.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * ͼ�ν��棺
 * 		JTextArea
 * 			�����ı������
 * 				�����Ҫ��������ı��������ʹ��JTextAreaʵ�ֶ����ı������룬������չ��JTextComponent�ࣻ
 * 
 * @author jack
 *
 */
public class JTextAreaDemo {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("JTextArea") ;
		JTextArea jta = new JTextArea(3,10) ;	// ���ô�С(�У���)
		JLabel lab = new JLabel("�����ı���") ;
		
		/*
		//�Զ����ǩ�Ͷ����ı��������ʾ����(��ǩ�����ı�������)
		lab.setBounds(10,10,120,20) ; //��ǩ��С
		jta.setBounds(130,10,150,100) ; //�����С
		frame.setLayout(null) ;	// ȡ�����ֹ�����
		*/
		
		JScrollPane scrol = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//���ö����ı��Ĺ�����
		//���ñ�ǩ���ı������ʾ����Ϊ�����ʽ���֣�
		frame.setLayout(new GridLayout(2, 1));
		
		frame.add(lab) ;//�ڴ�������ӱ�ǩ
		frame.add(scrol) ;//�ڴ�������ӹ��������Զ��岼��ʱ�������ı�������󣻱��ʽ����ʱ���������������
		frame.setSize(300,150) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

}
