package cn.sunjian.gui_event;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 * 图形界面：
 * 
 * 		事件监听:
 * 			菜单列表框JMenu；
 * 				实现菜单列表框中添加选项、快捷键等；
 * 				
 * @author sunjian
 *
 */
public class JMenuDemo{
	
	
	public static void main(String args[]){
		String fileIconPath = System.getProperty("user.dir")+"/files/lixinghua/image/file.gif";
		String newIconPath = System.getProperty("user.dir")+"/files/lixinghua/image/new.gif";
		String closeIconPath = System.getProperty("user.dir")+"/files/lixinghua/image/file.gif";
		String openIconPath = System.getProperty("user.dir")+"/files/lixinghua/image/file.gif";
		String exitIconPath = System.getProperty("user.dir")+"/files/lixinghua/image/file.gif";
		
		JFrame frame = new JFrame("JMenuDemo") ;//窗体
		Container cont = frame.getContentPane();//得到窗体容器
		final JTextArea text = new JTextArea() ;//多行文本输入框
		JScrollPane scrol = new JScrollPane(text);//滚动条
		ImageIcon icon = new ImageIcon(fileIconPath);//定义图片，并设置文件菜单图片路径
		JMenu menuFile = new JMenu("文件") ;//定义菜单按钮（文件）
		JMenuBar menuBar = new JMenuBar() ;//定义菜单组件
		
		cont.add(scrol) ;	//给窗体加入滚动条
		text.setEditable(true) ;	//设置多行输入框可编辑
		
		menuFile.setIcon(icon) ;//为菜单加入图片
		menuBar.add(menuFile) ;//通过JMenubar将JMenu菜单加入到窗体中

		//定义菜单选项
		JMenuItem newItem = new JMenuItem("新建",new ImageIcon(newIconPath)) ;
		JMenuItem openItem = new JMenuItem("打开",new ImageIcon(openIconPath)) ;
		JMenuItem closeItem = new JMenuItem("关闭",new ImageIcon(closeIconPath)) ;
		JMenuItem exitItem = new JMenuItem("退出",new ImageIcon(exitIconPath)) ;

		// 此时定义完了四个菜单的选项，定义完成之后，增加快捷键
		newItem.setMnemonic('N') ;
		openItem.setMnemonic('O') ;
		closeItem.setMnemonic('C') ;
		exitItem.setMnemonic('E') ;

		newItem.setAccelerator(KeyStroke.getKeyStroke('N',java.awt.Event.CTRL_MASK)) ;
		openItem.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.CTRL_MASK)) ;
		closeItem.setAccelerator(KeyStroke.getKeyStroke('C',java.awt.Event.ALT_MASK)) ;
		exitItem.setAccelerator(KeyStroke.getKeyStroke('E',java.awt.Event.ALT_MASK)) ;

		//给菜单选项“新建”添加监听事件
		newItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.append("=== 选择了“新建”菜单项\n") ;
			}
		}) ;
		//给菜单选项“打开”添加监听事件
		openItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.append("=== 选择了“打开”菜单项\n") ;
			}
		}) ;
		//给菜单选项“关闭”添加监听事件
		closeItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.append("=== 选择了“关闭”菜单项\n") ;
			}
		}) ;
		//给菜单选项“退出”添加监听事件
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.append("=== 选择了“退出”菜单项\n") ;
			}
		}) ;

		//将菜单选择添加到菜单中
		menuFile.add(newItem) ;
		menuFile.add(openItem) ;
		menuFile.add(closeItem) ;
		menuFile.add(exitItem) ;

		frame.setJMenuBar(menuBar) ;	//将菜单添加到窗口中；（ 菜单是需要通过此方法增加的）
		
		//为窗体添加关闭事件
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;
		frame.setSize(300,100) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
}