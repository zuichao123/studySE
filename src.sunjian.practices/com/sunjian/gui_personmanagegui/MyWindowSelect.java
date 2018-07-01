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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyWindowSelect extends MyWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int myJFrameGetX = 0;
	private int myJFrameGetY = 0;

//	private static String  userManagerPath = System.getProperty("user.dir")+"/files/lixinghua/file/userManager.txt";
	private String right = System.getProperty("user.dir")+"/files/lixinghua/image/right.png" ;
	private String wrong = System.getProperty("user.dir")+"/files/lixinghua/image/wrong.gif" ;
	
	JFrame mJframeFind;
	JPanel mJpanelFind;
	
	JLabel mJlName;
	JLabel mJlFindResult;
	
	JTextField mJtfName;
	JTextArea mJtaFindResult;
	JScrollPane mJScrollPane;
	
	JButton mJbConfirm;
	JButton mJbCancel;
	
	ImageIcon mIcon;
	JLabel mJlNImageR;
	JLabel mJlNImageW;
	
	public MyWindowSelect(JFrame mJFrame){
		this.myJFrameGetX = mJFrame.getX();
		this.myJFrameGetY = mJFrame.getY();
		
		this.mJframeFind = new JFrame();
		this.mJpanelFind = new JPanel();
		
		this.mJlName = new JLabel("请输入要查询的姓名：");
		this.mJtfName = new JTextField();
		
		this.mJlFindResult = new JLabel("查询结果：");
		this.mJtaFindResult = new JTextArea();
		
		this.mJbConfirm = new JButton("确定");
		this.mJbCancel = new JButton("取消");
		
		this.mIcon = new ImageIcon(right);
		this.mJlNImageR = new JLabel(this.mIcon);
		
		this.mIcon = new ImageIcon(wrong);
		this.mJlNImageW = new JLabel(this.mIcon);
	}

	public void look(){
		
		this.setLayout(null);
		this.mJpanelFind.setLayout(null);
		
		this.mJlName.setSize(150, 100);
		this.mJlName.setLocation(70, 0);
		this.mJlName.setFont(new Font("宋体", Font.BOLD, 14));
		this.mJpanelFind.add(mJlName);
		
		this.mJtfName.setSize(150, 25);
		this.mJtfName.setLocation(this.mJlName.getX()+150, this.mJlName.getY()+35);
		this.mJtfName.setBackground(Color.WHITE);
		this.mJpanelFind.add(mJtfName);
		
		this.mJlNImageR.setSize(25,25);
		this.mJlNImageR.setLocation(mJtfName.getX() + 160,mJlName.getY() + 30);
		this.mJpanelFind.add(mJlNImageR);
		this.mJlNImageR.setVisible(false);
		
		this.mJlNImageW.setSize(25,25);
		this.mJlNImageW.setLocation(mJtfName.getX() + 160,mJtfName.getY());
		this.mJpanelFind.add(mJlNImageW);
		this.mJlNImageW.setVisible(false);
		
		this.mJtaFindResult.setSize(300, 180);
		this.mJtaFindResult.setLocation(this.mJlName.getX(), this.mJlName.getY()+70);
		this.mJtaFindResult.setBackground(Color.WHITE);
		this.mJtaFindResult.setEnabled(true);//可编辑
		this.mJtaFindResult.setLineWrap(true);//自动换行
		this.mJpanelFind.add(mJtaFindResult);
		
		this.mJScrollPane = new JScrollPane(mJtaFindResult);
		this.mJScrollPane.setSize(this.mJtaFindResult.getWidth(), this.mJtaFindResult.getHeight());
		this.mJScrollPane.setLocation(this.mJtaFindResult.getX(), this.mJtaFindResult.getY());
		this.mJpanelFind.add(mJScrollPane);
	
		this.mJbConfirm.setSize(60, 60);
		this.mJbConfirm.setLocation(110, 280);
//		this.mJbConfirm.setFont(new Font("宋体", Font.BOLD, 10));
		this.mJpanelFind.add(mJbConfirm);
		
		this.mJbCancel.setSize(60, 60);
		this.mJbCancel.setLocation(this.mJbConfirm.getX() + 160, this.mJbConfirm.getY());
//		this.mJbCancel.setFont(new Font("宋体", Font.BOLD, 10));
		this.mJpanelFind.add(mJbCancel);
			
		this.mJframeFind.getContentPane().add(mJpanelFind,BorderLayout.CENTER);
		
		this.mJframeFind.setSize(460, 400);
		this.mJframeFind.setLocation(myJFrameGetX + 185,myJFrameGetY + 100);
		this.mJframeFind.setVisible(true);
		this.mJframeFind.setAlwaysOnTop(true);
		this.mJframeFind.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.mJframeFind.setTitle("查找用户");
		
		
		this.mJframeFind.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				//System.exit(1);
				mJframeFind.dispose();
			}
		});
		
		this.mJbCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mJbCancel) {
					mJframeFind.dispose();
				}
				
			}
		});
		
		this.mJbConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mJbConfirm) {
					mJtaFindResult.setText("");
					
					if (!(mJtfName.getText().equals("")) && mJtfName.getText().length() < 7) {
						
						mJlNImageR.setVisible(true);
						mJlNImageW.setVisible(false);
						
						String name = mJtfName.getText();
						
//						Person per = new Person();
						
						DBOperate dbo = new DBOperate();
						String content = dbo.find(name);
						
						if (content != null) {
							
							mJtaFindResult.setText(content);
							
						}else {
							mJtfName.setText("");
							mJlNImageR.setVisible(false);
							mJlNImageW.setVisible(false);
							mJtaFindResult.setText("sorry！\n您输入的姓名不存在，请重新输入！");
						}	
						
					}else if(mJtfName.getText().equals("") || mJtfName.getText().length() > 6){
						mJlNImageW.setVisible(true);
						mJlNImageR.setVisible(false);
					}
					
					
					
				}
			}
		});

		
//		FileOperate fo = new FileOperate(userManagerPath);
//		Person per = null;
//		
//		try {			
//			per = (Person) fo.load();
//			if (per != null) {								
//					superMJtextArea.setText(per.toString());				
//			}else {
//				JOptionPane.showMessageDialog(superMJpanel, "暂无用户，请先添加！");
//			}	
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
	}

}
