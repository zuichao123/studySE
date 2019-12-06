package com.sunjian.gui_personmanagegui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class MyWindowDelete extends MyWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private static String  userManagerPath = System.getProperty("user.dir")+"/files/lixinghua/file/userManager.txt";
	private String right = System.getProperty("user.dir")+"/files/lixinghua/image/right.png" ;
	private String wrong = System.getProperty("user.dir")+"/files/lixinghua/image/wrong.gif" ;
	
	private int myJFrameGetX = 0;
	private int myJFrameGetY = 0;
	
	JPanel superMJpanelAdd;

	JFrame mJframeDel;
	JPanel mJpanelDel;
	
	JLabel mJlName;
	JLabel mJlFindResult;
	
	JTextField mJtfName;
	JTextArea mJtaFindResult;
	
	JButton mJbConfirm;
	JButton mJbCancel;
	
	ImageIcon mIcon;
	JLabel mJlNImageR;
	JLabel mJlNImageW;
	
	public MyWindowDelete(JFrame mJFrame){
		this.myJFrameGetX = mJFrame.getX();
		this.myJFrameGetY = mJFrame.getY();
		
		this.mJframeDel = new JFrame();
		this.mJpanelDel = new JPanel();
		
		this.mJlName = new JLabel("请输入要删除的姓名：");
		this.mJtfName = new JTextField();
		
		
		this.mJbConfirm = new JButton("确定");
		this.mJbCancel = new JButton("取消");
		
		this.mIcon = new ImageIcon(right);
		this.mJlNImageR = new JLabel(this.mIcon);
		
		this.mIcon = new ImageIcon(wrong);
		this.mJlNImageW = new JLabel(this.mIcon);
	}

	public void delete(){
		
		this.setLayout(null);
		this.mJpanelDel.setLayout(null);
		
		this.mJlName.setSize(150, 100);
		this.mJlName.setLocation(70, 0);
		this.mJlName.setFont(new Font("宋体", Font.BOLD, 14));
		this.mJpanelDel.add(mJlName);
		
		this.mJtfName.setSize(150, 25);
		this.mJtfName.setLocation(this.mJlName.getX()+150, this.mJlName.getY()+35);
		this.mJtfName.setBackground(Color.WHITE);
		this.mJpanelDel.add(mJtfName);
		
		this.mJlNImageR.setSize(25,25);
		this.mJlNImageR.setLocation(mJtfName.getX() + 160,mJlName.getY() + 30);
		this.mJpanelDel.add(mJlNImageR);
		this.mJlNImageR.setVisible(false);
		
		this.mJlNImageW.setSize(25,25);
		this.mJlNImageW.setLocation(mJtfName.getX() + 160,mJtfName.getY());
		this.mJpanelDel.add(mJlNImageW);
		this.mJlNImageW.setVisible(false);
	
		this.mJbConfirm.setSize(60, 60);
		this.mJbConfirm.setLocation(110, 280);
//		this.mJbConfirm.setFont(new Font("宋体", Font.BOLD, 10));
		this.mJpanelDel.add(mJbConfirm);
		
		this.mJbCancel.setSize(60, 60);
		this.mJbCancel.setLocation(this.mJbConfirm.getX() + 160, this.mJbConfirm.getY());
//		this.mJbCancel.setFont(new Font("宋体", Font.BOLD, 10));
		this.mJpanelDel.add(mJbCancel);
			
		this.mJframeDel.getContentPane().add(mJpanelDel,BorderLayout.CENTER);
		
		this.mJframeDel.setSize(460, 400);
		this.mJframeDel.setLocation(myJFrameGetX + 185,myJFrameGetY + 100);
		this.mJframeDel.setVisible(true);
		this.mJframeDel.setAlwaysOnTop(true);
		this.mJframeDel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.mJframeDel.setTitle("删除用户");
		
		
		this.mJframeDel.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				//System.exit(1);
				mJframeDel.dispose();
			}
		});
		
		this.mJbCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mJbCancel) {
					mJframeDel.dispose();
				}
				
			}
		});
		
		this.mJbConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mJbConfirm) {
					
					if (!(mJtfName.getText().equals("")) && mJtfName.getText().length() < 7) {
						
						mJlNImageR.setVisible(true);
						mJlNImageW.setVisible(false);
						
						String name = mJtfName.getText();
						boolean flag = false;
						
//						Person per = new Person();
						
						DBOperate dbo = new DBOperate();
						String content = dbo.find(name);
						
						if (content != null) {
							flag = dbo.delete(name);
							if (flag) {			
								JOptionPane.showMessageDialog(mJpanelDel, "删除成功！");
								mJtfName.setText("");
								mJlNImageR.setVisible(false);
								mJlNImageW.setVisible(false);
							}else {
								JOptionPane.showMessageDialog(mJpanelDel, "删除失败！");								
								mJtfName.setText("");
								mJlNImageR.setVisible(false);
								mJlNImageW.setVisible(false);
							}
						}else {
							JOptionPane.showMessageDialog(mJpanelDel, "sorry！\n您输入的姓名不存在，请重新输入！");
							mJtfName.setText("");
							mJlNImageR.setVisible(false);
							mJlNImageW.setVisible(false);
						}	
						
					}else if(mJtfName.getText().equals("") || mJtfName.getText().length() > 6){
						mJlNImageW.setVisible(true);
						mJlNImageR.setVisible(false);
					}
				}
			}
		});
	}
	
//	public void delete(){
//		FileOperate fo = new FileOperate(userManagerPath);
//		boolean flag = false;
//		try{
////			flag = fo.delete();
//			DBOperate dbo = new DBOperate();
//			dbo.delete(name)
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		if (flag) {			
//			JOptionPane.showMessageDialog(superMJpanelAdd, "删除成功！");
//		}else {
//			JOptionPane.showMessageDialog(superMJpanelAdd, "删除失败！\n文件被占用或者不存在！");
//		}
//	}
	
}
