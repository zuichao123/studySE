package cn.sunjian.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 图形界面：
 * 
 * 		JTextField：
			单行文本输入框
 * 
 * @author jack
 *
 */
public class JTextFieldDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("JTextField") ;
		JTextField name = new JTextField(10) ;
		JTextField noed = new JTextField("MLDN",8) ;
		JLabel nameLab = new JLabel("输入用户姓名：") ;
		JLabel noedLab = new JLabel("不可编辑文本：") ;
		name.setColumns(30) ;
		noed.setColumns(10) ;
		noed.setEnabled(false) ;	// 表示不可编辑

		nameLab.setBounds(10,10,100,20) ;//绝对定位
		noedLab.setBounds(10,40,100,20) ;
		name.setBounds(110,10,80,20) ;
		noed.setBounds(110,40,50,20) ;
		frame.setLayout(null) ;

		//frame.setLayout(new GridLayout(2,2));//布局管理器（主要是使用布局管理器的时候会忽略掉文本框的默认设置值，如果想要解决这样的问题，可以采用绝对定位的方式【就是以上5行代码】）
	
		frame.add(nameLab) ;
		frame.add(name) ;
		frame.add(noedLab) ;
		frame.add(noed) ;
		frame.setSize(300,100) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;

	}

}
