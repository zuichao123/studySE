package com.sunjian.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * ͼ�ν��棺
 * 
 * 		�¼�����:
 * 			����+��ť������
 * 				ʵ��һ���򵥵ĵ�¼������
 *				�û�����jack  ���룺123456
 *				�������¼������û�����ȷ����ʾ��¼�ɹ���������󣬵�¼ʧ�ܣ�
 *				��������á�����������ݣ�
 *			
 * @author sunjian
 *
 */

class LoginCheck{
	private String name ;
	private String password ;
	public LoginCheck(String name,String password){
		this.name = name ;
		this.password = password ;
	}
	public boolean validate(){
		if("jack".equals(name)&&"123456".equals(password)){
			return true ;
		}else{
			return false ;
		}
	}
};

class ActionHandle{
	private JFrame frame = new JFrame("Welcome To MLDN") ; 

	private JButton submit = new JButton("��½");
	private JButton reset = new JButton("����");

	private JLabel nameLab = new JLabel("�û�����") ;
	private JLabel passLab = new JLabel("��   �룺") ;
	private JLabel infoLab = new JLabel("�û���½ϵͳ") ;

	private JTextField nameText = new JTextField(10) ;//�����������ı���
	private JPasswordField passText = new JPasswordField() ;//�����

	private JPanel pan = new JPanel() ;//���

	public ActionHandle(){
		Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,12) ;//��������
		infoLab.setFont(fnt) ;	// ���ñ�ǩ����ʾ����

		//��½�¼�
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==submit){
					String tname = nameText.getText() ;//�õ������ı�
					String tpass = new String(passText.getPassword()) ;//�õ������ı�
					LoginCheck log = new LoginCheck(tname,tpass) ;
					if(log.validate()){
						infoLab.setText("��½�ɹ�����ӭ���٣�") ;
					}else{
						infoLab.setText("��½ʧ�ܣ�������û��������룡") ;
					}
				}
			}
		}) ;

		//�����¼�
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==reset){
					nameText.setText("") ;
					passText.setText("") ;
					infoLab.setText("�û���½ϵͳ") ;
				}
			}
		}) ;
		
		// ����رմ����¼�
		frame.addWindowListener(new WindowAdapter(){  
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	

                //���Զ�λ����
		frame.setLayout(null) ;
		nameLab.setBounds(5,5,60,20) ;
		passLab.setBounds(5,30,60,20) ;
		infoLab.setBounds(5,65,220,30) ;
		nameText.setBounds(65,5,100,20) ;
		passText.setBounds(65,30,100,20) ;
		submit.setBounds(165,5,60,20) ;
		reset.setBounds(165,30,60,20) ;

		//�ڴ��������
		frame.add(pan);
		frame.add(nameLab) ;
		frame.add(passLab) ;
		frame.add(infoLab) ;
		frame.add(nameText) ;
		frame.add(passText) ;
		frame.add(submit) ;
		frame.add(reset) ;

		//���ô����С��������ɫ������λ�á��Ƿ���ʾ
		frame.setSize(280,130) ;
		frame.setBackground(Color.WHITE) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;

	}
}

public class UserLoginCheck {

	public static void main(String[] args) {
		
		new ActionHandle();
	}

}
