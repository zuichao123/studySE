package com.sunjian.gui_personmanagegui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MyWindowAdd extends MyWindow{
	private String userManagerPath = System.getProperty("user.dir")+"/files/lixinghua/file/userManager.txt";
	private String right = System.getProperty("user.dir")+"/files/lixinghua/image/right.png" ;
	private String wrong = System.getProperty("user.dir")+"/files/lixinghua/image/wrong.gif" ;
	private int myJFrameGetX = 0;
	private int myJFrameGetY = 0;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**************************/

	
	/**************init*******************/
	JFrame mJframeAdd;
	JPanel mJpanelAdd;
	
	JLabel mJlName;
	JLabel mJlAge;
	
	JTextField mJtfName;
	JTextField mJtfAge;
	
	JButton mJbConfirm;
	JButton mJbCancel;
	
	ImageIcon mIcon;
	JLabel mJlNImageR;
	JLabel mJlNImageW;
	JLabel mJlAImageR;
	JLabel mJlAImageW;
	
	JTextArea superMJtextArea;
	
	public MyWindowAdd(JFrame mJFrame,JTextArea mJTextArea){
		this.myJFrameGetX = mJFrame.getX();
		this.myJFrameGetY = mJFrame.getY();
		this.superMJtextArea = mJTextArea;
	}
	
	
	/*��������*/
	public void add(){
		
		/************�������****************/
		this.mJframeAdd = new JFrame();
		this.mJpanelAdd = new JPanel();
		
		this.mJlName = new JLabel("������");
		this.mJlAge = new JLabel("���䣺");
		
		this.mJtfName = new JTextField();
		this.mJtfAge = new JTextField();
		
		this.mJbConfirm = new JButton("ȷ��");
		this.mJbCancel = new JButton("ȡ��");
		
		/************�����*****************/
		this.mJlName.setSize(100, 100);
		this.mJlName.setLocation(12, 5);
		this.mJlName.setFont(new Font("����", Font.BOLD, 14));
		this.mJpanelAdd.add(mJlName);
		
		this.mJtfName.setSize(80, 25);
		this.mJtfName.setLocation(this.mJlName.getX()+45, this.mJlName.getY()+38);
		this.mJtfName.setBackground(Color.WHITE);
		this.mJpanelAdd.add(mJtfName);
		
		this.mIcon = new ImageIcon(right);
		this.mJlNImageR = new JLabel(mIcon);
		this.mJlNImageR.setSize(25,25);
		this.mJlNImageR.setLocation(mJtfName.getX() + 100,mJtfName.getY());
		this.mJpanelAdd.add(mJlNImageR);
		this.mJlNImageR.setVisible(false);
		
		this.mIcon = new ImageIcon(wrong);
		this.mJlNImageW = new JLabel(mIcon);
		this.mJlNImageW.setSize(25,25);
		this.mJlNImageW.setLocation(mJtfName.getX() + 100,mJtfName.getY());
		this.mJpanelAdd.add(mJlNImageW);
		this.mJlNImageW.setVisible(false);
		
		this.mJlAge.setSize(100,100);
		this.mJlAge.setLocation(12, 40);
		this.mJlAge.setFont(new Font("����", Font.BOLD, 14));
		this.mJpanelAdd.add(mJlAge);
		
		this.mJtfAge.setSize(80, 25);
		this.mJtfAge.setLocation(this.mJtfName.getX(), this.mJlAge.getY()+38);
		this.mJtfAge.setBackground(Color.WHITE);
		this.mJpanelAdd.add(mJtfAge);
		
		this.mIcon = new ImageIcon(right);
		this.mJlAImageR = new JLabel(mIcon);
		this.mJlAImageR.setSize(25,25);
		this.mJlAImageR.setLocation(mJtfAge.getX() + 100,mJtfAge.getY());
		this.mJpanelAdd.add(mJlAImageR);
		this.mJlAImageR.setVisible(false);
		
		this.mIcon = new ImageIcon(wrong);
		this.mJlAImageW = new JLabel(mIcon);
		this.mJlAImageW.setSize(25,25);
		this.mJlAImageW.setLocation(mJtfAge.getX() + 100,mJtfAge.getY());
		this.mJpanelAdd.add(mJlAImageW);
		this.mJlAImageW.setVisible(false);
		
		this.mJbConfirm.setSize(60, 60);
		this.mJbConfirm.setLocation(120, 250);
//		this.mJbConfirm.setFont(new Font("����", Font.BOLD, 10));
		this.mJpanelAdd.add(mJbConfirm);
		
		this.mJbCancel.setSize(60, 60);
		this.mJbCancel.setLocation(this.mJbConfirm.getX() + 160, this.mJbConfirm.getY());
//		this.mJbCancel.setFont(new Font("����", Font.BOLD, 10));
		this.mJpanelAdd.add(mJbCancel);
		
		//...........
		
		
		//......................
		
		this.setLayout(null);
		this.mJpanelAdd.setLayout(null);
		
		this.mJframeAdd.getContentPane().add(mJpanelAdd, BorderLayout.CENTER);
		
		this.mJframeAdd.setSize(460,400);
		this.mJframeAdd.setLocation(myJFrameGetX + 185,myJFrameGetY + 100);
		this.mJframeAdd.setVisible(true);
		this.mJframeAdd.setAlwaysOnTop(true);
		this.mJframeAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.mJframeAdd.setTitle("����û�");
		
		
		this.mJframeAdd.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				//System.exit(1);
				mJframeAdd.dispose();
			}
		});
		
		this.mJbConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == mJbConfirm) {
					if (!(mJtfAge.getText().equals("")) && mJtfAge.getText().matches("^\\d+$")) {
						mJlAImageR.setVisible(true);
						mJlAImageW.setVisible(false);
					}
					if (!(mJtfName.getText().equals("")) && mJtfName.getText().length() < 7) {
						mJlNImageR.setVisible(true);
						mJlNImageW.setVisible(false);
					}
					
					if (mJtfAge.getText() != null && mJtfAge.getText().matches("^\\d+$") 
							&& mJtfName.getText() != null && mJtfName.getText().length() < 7) {
						
						String name = mJtfName.getText();
						int age = Integer.parseInt(mJtfAge.getText());
						
						Person per = new Person(name, age);
						FileOperate fo = new FileOperate(userManagerPath);
						
						try {
							fo.save(per);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
						superMJtextArea.setText("��ӳɹ���\n"+per.toString());
						
						JOptionPane.showMessageDialog(mJpanelAdd, "��ӳɹ���");
						
						mJframeAdd.dispose();
						
					}else if (mJtfAge.getText().equals("") || !(mJtfAge.getText().matches("^\\d+$"))) {
						mJlAImageW.setVisible(true);
						mJlAImageR.setVisible(false);
					}if (mJtfName.getText().equals("") || mJtfName.getText().length() > 6) {
						mJlNImageW.setVisible(true);
						mJlNImageR.setVisible(false);
					}
					
				}
				
			}
		});
		
		this.mJbCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mJbCancel) {
					mJframeAdd.dispose();
				}
				
			}
		});
	
		this.mJtfName.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent e) { //ʧȥ����ִ�� 
//				String nameContent = mJtfName.getText();
//			  	
//			  	if (!(nameContent.equals("")) && nameContent.length()<7) {
//			  		mJlNImageR.setVisible(true);
//			  		mJlNImageW.setVisible(false);
//				}else {
//					mJlNImageW.setVisible(true);
//					mJlNImageR.setVisible(false);
//				}
				
			}
			public void focusGained(FocusEvent e) {			//��ý���ִ�еĴ��� 
				 
			}
		});
		
		this.mJtfAge.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent e) { //ʧȥ����ִ�� 
//				String nameContent = mJtfAge.getText();
//				
//				if (nameContent != null && nameContent.matches("^\\d+$")) {
//					mJlAImageR.setVisible(true);
//					mJlAImageW.setVisible(false);
//				}else {
//					mJlAImageW.setVisible(true);
//					mJlAImageR.setVisible(false);
//				}
			}
			public void focusGained(FocusEvent e) {//��ý���ִ�еĴ���
				 
			}
		});
		
	}
}
