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
 * 图形界面：
 * 
 * 		事件监听:
 * 			窗口+按钮监听：
 * 				实现一个简单的登录操作；
 *				用户名：jack  密码：123456
 *				点击“登录”如果用户名正确，提示登录成功；如果错误，登录失败；
 *				点击“重置”清空输入内容；
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

	private JButton submit = new JButton("登陆");
	private JButton reset = new JButton("重置");

	private JLabel nameLab = new JLabel("用户名：") ;
	private JLabel passLab = new JLabel("密   码：") ;
	private JLabel infoLab = new JLabel("用户登陆系统") ;

	private JTextField nameText = new JTextField(10) ;//输入姓名是文本框
	private JPasswordField passText = new JPasswordField() ;//密码框

	private JPanel pan = new JPanel() ;//面板

	public ActionHandle(){
		Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,12) ;//设置字体
		infoLab.setFont(fnt) ;	// 设置标签的显示文字

		//登陆事件
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==submit){
					String tname = nameText.getText() ;//得到姓名文本
					String tpass = new String(passText.getPassword()) ;//得到密码文本
					LoginCheck log = new LoginCheck(tname,tpass) ;
					if(log.validate()){
						infoLab.setText("登陆成功，欢迎光临！") ;
					}else{
						infoLab.setText("登陆失败，错误的用户名或密码！") ;
					}
				}
			}
		}) ;

		//重置事件
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==reset){
					nameText.setText("") ;
					passText.setText("") ;
					infoLab.setText("用户登陆系统") ;
				}
			}
		}) ;
		
		// 加入关闭窗口事件
		frame.addWindowListener(new WindowAdapter(){  
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	

                //绝对定位布局
		frame.setLayout(null) ;
		nameLab.setBounds(5,5,60,20) ;
		passLab.setBounds(5,30,60,20) ;
		infoLab.setBounds(5,65,220,30) ;
		nameText.setBounds(65,5,100,20) ;
		passText.setBounds(65,30,100,20) ;
		submit.setBounds(165,5,60,20) ;
		reset.setBounds(165,30,60,20) ;

		//在窗体中添加
		frame.add(pan);
		frame.add(nameLab) ;
		frame.add(passLab) ;
		frame.add(infoLab) ;
		frame.add(nameText) ;
		frame.add(passText) ;
		frame.add(submit) ;
		frame.add(reset) ;

		//设置窗体大小、背景颜色、坐标位置、是否显示
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
