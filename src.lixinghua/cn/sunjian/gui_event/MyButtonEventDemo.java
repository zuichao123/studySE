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
 * 图形界面：
 * 
 * 		事件监听:
 * 			按钮监听：
 * 				如果现在想让一个按钮变得有意义，则可以使用事件的处理，只需要使用ActionListener接口。
			
 * @author sunjian
 *
 */
class ActionHandle{
	private JFrame frame = new JFrame("Welcome To MLDN") ; 
	private JButton but = new JButton("显示");
	private JLabel lab = new JLabel() ;//标签组件
	private JTextField text = new JTextField(10) ;//单行文本输入
	private JPanel pan = new JPanel() ;//面板
	public ActionHandle(){
		Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,28) ;
		lab.setFont(fnt) ;	// 设置标签的显示文字
		lab.setText("等待用户输入信息！") ;
		but.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// if(e.getSource() instanceof JButton){}	// 判断是否是按钮
				if(e.getSource()==but){// 判断是否是按钮
					lab.setText(text.getText()) ;//将单行文本区域中的内容，显示在标签处
				}
			}
		}) ;
		frame.addWindowListener(new WindowAdapter(){   // 加入关闭窗体事件（系统退出）
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	
		frame.setLayout(new GridLayout(2,1)) ;//设置窗体布局
		pan.setLayout(new GridLayout(1,2)) ;//设置面板布局
		pan.add(text);//在面板中添加单行文本区域
		pan.add(but) ;//在面板中添加按钮
		frame.add(pan) ;//在窗体中添加面板
		frame.add(lab) ;//在窗体中添加标签
		frame.pack() ;//自动设置窗口大小
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