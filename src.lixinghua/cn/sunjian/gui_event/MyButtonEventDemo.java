package cn.sunjian.gui_event;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			��ť������
 * 				�����������һ����ť��������壬�����ʹ���¼��Ĵ���ֻ��Ҫʹ��ActionListener�ӿڡ�
			
 * @author sunjian
 *
 */
class ActionHandle{
	private JFrame frame = new JFrame("Welcome To MLDN") ; 
	private JButton but = new JButton("��ʾ");
	private JLabel lab = new JLabel() ;//��ǩ���
	private JTextField text = new JTextField(10) ;//�����ı�����
	private JPanel pan = new JPanel() ;//���
	public ActionHandle(){
		Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,28) ;
		lab.setFont(fnt) ;	// ���ñ�ǩ����ʾ����
		lab.setText("�ȴ��û�������Ϣ��") ;
		but.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// if(e.getSource() instanceof JButton){}	// �ж��Ƿ��ǰ�ť
				if(e.getSource()==but){// �ж��Ƿ��ǰ�ť
					lab.setText(text.getText()) ;//�������ı������е����ݣ���ʾ�ڱ�ǩ��
				}
			}
		}) ;
		frame.addWindowListener(new WindowAdapter(){   // ����رմ����¼���ϵͳ�˳���
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	
		frame.setLayout(new GridLayout(2,1)) ;//���ô��岼��
		pan.setLayout(new GridLayout(1,2)) ;//������岼��
		pan.add(text);//���������ӵ����ı�����
		pan.add(but) ;//���������Ӱ�ť
		frame.add(pan) ;//�ڴ�����������
		frame.add(lab) ;//�ڴ�������ӱ�ǩ
		frame.pack() ;//�Զ����ô��ڴ�С
		frame.setBackground(Color.WHITE) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;

	}
};

public class MyButtonEventDemo{
	public static void main(String args[]){
		
		new ActionHandle() ;
	}
};