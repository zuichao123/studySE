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


public class MyWindowUpdate extends MyWindow{
//	private String userManagerPath = System.getProperty("user.dir")+"/files/lixinghua/file/userManager.txt";
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
	JFrame mJframeUpdate;
	JPanel mJpanelUpdate;
	
	JLabel mJlName;
	JLabel mJlAge;
	
	JTextField mJtfName;
	JTextField mJtfAge;
	
	JLabel mJlOldName;
	JLabel mJlOldAge;
	
	JTextField mJtfOldName;
	JTextField mJtfOldAge;
	
	JButton mJbConfirm;
	JButton mJbCancel;
	
	ImageIcon mIcon;
	JLabel mJlNImageR;
	JLabel mJlNImageW;
	JLabel mJlAImageR;
	JLabel mJlAImageW;

	JLabel mJlOldNImageR;
	JLabel mJlOldNImageW;
	JLabel mJlOldAImageR;
	JLabel mJlOldAImageW;
	
	JTextArea superMJtextArea;
	
	public MyWindowUpdate(JFrame mJFrame,JTextArea mJTextArea){
		this.myJFrameGetX = mJFrame.getX();
		this.myJFrameGetY = mJFrame.getY();
		this.superMJtextArea = mJTextArea;
		
		/*********定义组件***************/
		this.mJframeUpdate = new JFrame();
		this.mJpanelUpdate = new JPanel();
		
		this.mJlName = new JLabel("姓名：");
		this.mJlAge = new JLabel("年龄：");
		
		this.mJlOldName = new JLabel("原姓名：");
		this.mJlOldAge = new JLabel("原年龄：");
		
		this.mJtfName = new JTextField();
		this.mJtfAge = new JTextField();
		
		this.mJtfOldName = new JTextField();
		this.mJtfOldAge = new JTextField();
		
		this.mJbConfirm = new JButton("确定");
		this.mJbCancel = new JButton("取消");
		
	}
	
	
	/*创建窗口*/
	public void update(){
		
		/*********************画组件**************************/
		this.mJlOldName.setSize(100, 100);
		this.mJlOldName.setLocation(58, 5);
		this.mJlOldName.setFont(new Font("宋体", Font.BOLD, 14));
		this.mJpanelUpdate.add(mJlOldName);
		
		this.mJtfOldName.setSize(80, 25);
		this.mJtfOldName.setLocation(this.mJlOldName.getX()+60, this.mJlOldName.getY()+38);
		this.mJtfOldName.setBackground(Color.WHITE);
		this.mJpanelUpdate.add(mJtfOldName);
		
		this.mIcon = new ImageIcon(right);
		this.mJlOldNImageR = new JLabel(mIcon);
		this.mJlOldNImageR.setSize(25,25);
		this.mJlOldNImageR.setLocation(this.mJtfOldName.getX() + 100,mJtfOldName.getY());
		this.mJpanelUpdate.add(mJlOldNImageR);
		this.mJlOldNImageR.setVisible(false);
		
		this.mIcon = new ImageIcon(wrong);
		this.mJlOldNImageW = new JLabel(mIcon);
		this.mJlOldNImageW.setSize(25,25);
		this.mJlOldNImageW.setLocation(mJtfOldName.getX() + 100,mJtfOldName.getY());
		this.mJpanelUpdate.add(mJlOldNImageW);
		this.mJlOldNImageW.setVisible(false);
		
		this.mJlName.setSize(100, 100);
		this.mJlName.setLocation(this.mJlOldName.getX()+200,this.mJlOldName.getY());
		this.mJlName.setFont(new Font("宋体", Font.BOLD, 14));
		this.mJpanelUpdate.add(mJlName);
		
		this.mJtfName.setSize(80, 25);
		this.mJtfName.setLocation(this.mJlName.getX()+45, this.mJlName.getY()+38);
		this.mJtfName.setBackground(Color.WHITE);
		this.mJpanelUpdate.add(mJtfName);
		
		this.mIcon = new ImageIcon(right);
		this.mJlNImageR = new JLabel(mIcon);
		this.mJlNImageR.setSize(25,25);
		this.mJlNImageR.setLocation(mJtfName.getX() + 100,mJtfName.getY());
		this.mJpanelUpdate.add(mJlNImageR);
		this.mJlNImageR.setVisible(false);
		
		this.mIcon = new ImageIcon(wrong);
		this.mJlNImageW = new JLabel(mIcon);
		this.mJlNImageW.setSize(25,25);
		this.mJlNImageW.setLocation(mJtfName.getX() + 100,mJtfName.getY());
		this.mJpanelUpdate.add(mJlNImageW);
		this.mJlNImageW.setVisible(false);
		
		this.mJlOldAge.setSize(100,100);
		this.mJlOldAge.setLocation(58, 40);
		this.mJlOldAge.setFont(new Font("宋体", Font.BOLD, 14));
		this.mJpanelUpdate.add(mJlOldAge);
		
		this.mJtfOldAge.setSize(80, 25);
		this.mJtfOldAge.setLocation(this.mJlOldAge.getX()+60, this.mJlOldAge.getY()+38);
		this.mJtfOldAge.setBackground(Color.WHITE);
		this.mJpanelUpdate.add(mJtfOldAge);
		
		this.mIcon = new ImageIcon(right);
		this.mJlOldAImageR = new JLabel(mIcon);
		this.mJlOldAImageR.setSize(25,25);
		this.mJlOldAImageR.setLocation(mJtfOldAge.getX() + 100,mJtfOldAge.getY());
		this.mJpanelUpdate.add(mJlOldAImageR);
		this.mJlOldAImageR.setVisible(false);
		
		this.mIcon = new ImageIcon(wrong);
		this.mJlOldAImageW = new JLabel(mIcon);
		this.mJlOldAImageW.setSize(25,25);
		this.mJlOldAImageW.setLocation(mJtfOldAge.getX() + 100,mJtfOldAge.getY());
		this.mJpanelUpdate.add(mJlOldAImageW);
		this.mJlOldAImageW.setVisible(false);	
		
		this.mJlAge.setSize(100,100);
		this.mJlAge.setLocation(this.mJlOldAge.getX()+200, this.mJlOldAge.getY());
		this.mJlAge.setFont(new Font("宋体", Font.BOLD, 14));
		this.mJpanelUpdate.add(mJlAge);
		
		this.mJtfAge.setSize(80, 25);
		this.mJtfAge.setLocation(this.mJtfName.getX(), this.mJlAge.getY()+38);
		this.mJtfAge.setBackground(Color.WHITE);
		this.mJpanelUpdate.add(mJtfAge);
		
		this.mIcon = new ImageIcon(right);
		this.mJlAImageR = new JLabel(mIcon);
		this.mJlAImageR.setSize(25,25);
		this.mJlAImageR.setLocation(mJtfAge.getX() + 100,mJtfAge.getY());
		this.mJpanelUpdate.add(mJlAImageR);
		this.mJlAImageR.setVisible(false);
		
		this.mIcon = new ImageIcon(wrong);
		this.mJlAImageW = new JLabel(mIcon);
		this.mJlAImageW.setSize(25,25);
		this.mJlAImageW.setLocation(mJtfAge.getX() + 100,mJtfAge.getY());
		this.mJpanelUpdate.add(mJlAImageW);
		this.mJlAImageW.setVisible(false);
		
		this.mJbConfirm.setSize(60, 60);
		this.mJbConfirm.setLocation(120, 250);
		this.mJpanelUpdate.add(mJbConfirm);
		
		this.mJbCancel.setSize(60, 60);
		this.mJbCancel.setLocation(this.mJbConfirm.getX() + 160, this.mJbConfirm.getY());
		this.mJpanelUpdate.add(mJbCancel);
		
		this.setLayout(null);
		this.mJpanelUpdate.setLayout(null);
		
		this.mJframeUpdate.getContentPane().add(mJpanelUpdate, BorderLayout.CENTER);
		
		this.mJframeUpdate.setSize(460,400);
		this.mJframeUpdate.setLocation(myJFrameGetX + 185,myJFrameGetY + 100);
		this.mJframeUpdate.setVisible(true);
		this.mJframeUpdate.setAlwaysOnTop(true);
		this.mJframeUpdate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.mJframeUpdate.setTitle("修改信息");
		
		
		this.mJframeUpdate.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				//System.exit(1);
				mJframeUpdate.dispose();
			}
		});
		
		this.mJbConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == mJbConfirm) {
					//原
					if (!(mJtfOldName.getText().equals("")) && mJtfOldName.getText().length() < 7) {
						mJlOldNImageR.setVisible(true);
						mJlOldNImageW.setVisible(false);
					}else {
						mJlOldNImageW.setVisible(true);
						mJlOldNImageR.setVisible(false);
					}
					if (!(mJtfOldAge.getText().equals("")) && mJtfOldAge.getText().matches("^\\d+$")) {
						mJlOldAImageR.setVisible(true);
						mJlOldAImageW.setVisible(false);
					}else {
						mJlOldAImageW.setVisible(true);
						mJlOldAImageR.setVisible(false);
					}
					
//					if (!(mJtfOldAge.getText().equals("")) && mJtfOldAge.getText().matches("^\\d+$") 
//							&& !(mJtfOldName.getText().equals("")) && mJtfOldName.getText().length() < 7) {
						
//						String name = mJtfOldName.getText();
//						int age = Integer.parseInt(mJtfOldAge.getText());
						
//						Person per = new Person(name, age);
//						FileOperate fo = new FileOperate(userManagerPath);

//						try {
//							fo.save(null);
//						} catch (Exception e1) {
//							e1.printStackTrace();
//						}
						
						
//						mJframeUpdate.dispose();
						
//					}else if (mJtfOldName.getText().equals("") || mJtfOldName.getText().length() > 6) {
//						mJlOldNImageW.setVisible(true);
//						mJlOldNImageR.setVisible(false);
//					}if (mJtfOldAge.getText().equals("") || !(mJtfOldAge.getText().matches("^\\d+$"))) {
//						mJlOldAImageW.setVisible(true);
//						mJlOldAImageR.setVisible(false);
//					}
					
					
					//新
					if (!(mJtfAge.getText().equals("")) && mJtfAge.getText().matches("^\\d+$")) {
						mJlAImageR.setVisible(true);
						mJlAImageW.setVisible(false);
					}
					if (!(mJtfName.getText().equals("")) && mJtfName.getText().length() < 7) {
						mJlNImageR.setVisible(true);
						mJlNImageW.setVisible(false);
					}
					if (!(mJtfAge.getText().equals("")) && mJtfAge.getText().matches("^\\d+$") 
							&& !(mJtfName.getText().equals("")) && mJtfName.getText().length() < 7
							&& !(mJtfOldAge.getText().equals("")) && mJtfOldAge.getText().matches("^\\d+$") 
							&& !(mJtfOldName.getText().equals("")) && mJtfOldName.getText().length() < 7) {
						
						String newName = mJtfName.getText();
						int newAge = Integer.parseInt(mJtfAge.getText());
						String oldName = mJtfOldName.getText();
//						int oldAge = Integer.parseInt(mJtfOldAge.getText());
						
						DBOperate dbo = new DBOperate();
						
						if (dbo.find(oldName) != null) {
							boolean flag = dbo.update(oldName, newName, newAge);
							if (flag) {
								superMJtextArea.setText("修改成功！\n"+dbo.find(newName));
								
								JOptionPane.showMessageDialog(mJpanelUpdate, "修改成功！");
								
							}else {
								superMJtextArea.setText("");
								JOptionPane.showMessageDialog(mJpanelUpdate, "修改失败！");
							}
							
						}else {
							mJtfOldName.setText("");
							mJtfOldAge.setText("");
							mJlOldNImageR.setVisible(false);
							mJlOldNImageW.setVisible(false);
							mJlOldAImageR.setVisible(false);
							mJlOldAImageW.setVisible(false);
							JOptionPane.showMessageDialog(mJpanelUpdate, "sorry！\n您输入的姓名不存在，请重新输入！");
						}
						
						
//						Person per = new Person(name, age);
//						FileOperate fo = new FileOperate(userManagerPath);
//						
//						try {
//							fo.save(per);
//						} catch (Exception e1) {
//							e1.printStackTrace();
//						}
						
//						mJframeUpdate.dispose();
						
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
					mJframeUpdate.dispose();
				}
				
			}
		});
	
		this.mJtfName.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent e) {  
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
			 public void focusGained(FocusEvent e) {
			//获得焦点执行的代码 
			}
		});
		
		this.mJtfAge.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent e) {  
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
			public void focusGained(FocusEvent e) {
				//获得焦点执行的代码 
			}
		});
		
	}
	
}
