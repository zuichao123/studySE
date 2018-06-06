package cn.sunjian.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 图形界面：
 * 		JTextArea
 * 			多行文本输入框：
 * 				如果想要输入多行文本，则可以使用JTextArea实现多行文本的输入，此类扩展了JTextComponent类；
 * 
 * @author jack
 *
 */
public class JTextAreaDemo {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("JTextArea") ;
		JTextArea jta = new JTextArea(3,10) ;	// 设置大小(行，列)
		JLabel lab = new JLabel("多行文本域：") ;
		
		/*
		//自定义标签和多行文本区域的显示布局(标签在左，文本域在右)
		lab.setBounds(10,10,120,20) ; //标签大小
		jta.setBounds(130,10,150,100) ; //组件大小
		frame.setLayout(null) ;	// 取消布局管理器
		*/
		
		JScrollPane scrol = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//设置多行文本的滚动条
		//设置标签和文本域的显示布局为（表格式布局）
		frame.setLayout(new GridLayout(2, 1));
		
		frame.add(lab) ;//在窗口中添加标签
		frame.add(scrol) ;//在窗口中添加滚动条（自定义布局时，传入文本组件对象；表格式布局时，传入滚动条对象）
		frame.setSize(300,150) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

}
